/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Comprador;
import Modelo.Conexion;
import Modelo.PasswordUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DAO para la entidad Comprador. Implementa operaciones CRUD básicas.
 */
public class CompradorData {

    private static final Logger LOGGER = Logger.getLogger(CompradorData.class.getName());

    /**
     * Guarda un nuevo comprador en la base de datos. Hashea la contraseña antes de persistirla.
     *
     * @param comprador El objeto Comprador a guardar.
     * @return El DNI del comprador guardado o -1 en caso de error.
     */
    public int guardarComprador(Comprador comprador) {
        String sql = "INSERT INTO comprador (dni, nombre, fechaNac, password, medioPago) VALUES (?, ?, ?, ?, ?)";
        int result = -1;

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, comprador.getDni());
            ps.setString(2, comprador.getNombre());
            if (comprador.getFechaNac() != null) {
                ps.setDate(3, Date.valueOf(comprador.getFechaNac()));
            } else {
                ps.setDate(3, null);
            }

            // Hasheamos la contraseña con salt usando PasswordUtils
            String rawPass = comprador.getPassword();
            String storedPass = null;
            if (rawPass != null && !rawPass.isEmpty()) {
                storedPass = PasswordUtils.hashPassword(rawPass);
            }
            ps.setString(4, storedPass);
            ps.setString(5, comprador.getMedioPago());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                result = comprador.getDni();
                System.out.println("Comprador guardado con DNI: " + result);
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al guardar el comprador", ex);
        }
        return result;
    }

    /**
     * Busca un comprador por DNI.
     *
     * @param dni DNI a buscar
     * @return Comprador encontrado o null si no existe / error
     */
    public Comprador buscarCompradorPorDni(int dni) {
        String sql = "SELECT dni, nombre, fechaNac, password, medioPago FROM comprador WHERE dni = ?";
        Comprador comprador = null;

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int cdni = rs.getInt("dni");
                    String nombre = rs.getString("nombre");
                    Date fecha = rs.getDate("fechaNac");
                    String medioPago = rs.getString("medioPago");

                    LocalDate fechaNac = (fecha != null) ? fecha.toLocalDate() : null;

                    comprador = new Comprador(cdni, nombre, fechaNac, null, medioPago);
                    // Por seguridad no devolvemos la contraseña en texto ni el hash
                }
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al buscar comprador por DNI", ex);
        }
        return comprador;
    }

    /**
     * Lista todos los compradores en la base de datos.
     *
     * @return Lista de compradores (vacía si no hay o en caso de error)
     */
    public List<Comprador> listarCompradores() {
        List<Comprador> lista = new ArrayList<>();
        String sql = "SELECT dni, nombre, fechaNac, medioPago FROM comprador";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int dni = rs.getInt("dni");
                String nombre = rs.getString("nombre");
                Date fecha = rs.getDate("fechaNac");
                String medioPago = rs.getString("medioPago");

                LocalDate fechaNac = (fecha != null) ? fecha.toLocalDate() : null;
                Comprador c = new Comprador(dni, nombre, fechaNac, null, medioPago);
                lista.add(c);
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al listar compradores", ex);
        }
        return lista;
    }

    /**
     * Actualiza los datos de un comprador existente. Si la contraseña es no nula y no vacía,
     * se reemplaza (y se hashea) en la base de datos.
     *
     * @param comprador Comprador con los nuevos datos (debe tener DNI válido)
     * @return true si se actualizó correctamente
     */
    public boolean actualizarComprador(Comprador comprador) {
        String sql = "UPDATE comprador SET nombre = ?, fechaNac = ?, medioPago = ?";
        boolean actualizarPass = comprador.getPassword() != null && !comprador.getPassword().isEmpty();
        if (actualizarPass) {
            sql += ", password = ?";
        }
        sql += " WHERE dni = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int idx = 1;
            ps.setString(idx++, comprador.getNombre());
            if (comprador.getFechaNac() != null) {
                ps.setDate(idx++, Date.valueOf(comprador.getFechaNac()));
            } else {
                ps.setDate(idx++, null);
            }
            ps.setString(idx++, comprador.getMedioPago());

            if (actualizarPass) {
                String hashed = PasswordUtils.hashPassword(comprador.getPassword());
                ps.setString(idx++, hashed);
            }

            ps.setInt(idx, comprador.getDni());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al actualizar comprador", ex);
            return false;
        }
    }

    /**
     * Elimina un comprador por DNI.
     *
     * @param dni DNI del comprador a eliminar
     * @return true si se eliminó correctamente
     */
    public boolean eliminarComprador(int dni) {
        String sql = "DELETE FROM comprador WHERE dni = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, dni);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar comprador", ex);
            return false;
        }
    }

}
