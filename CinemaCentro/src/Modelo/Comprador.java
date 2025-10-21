package Modelo;

import java.time.LocalDate;

public class Comprador {
    private int dni;
    private String nombre;
    private LocalDate fechaNac;
    private String password;
    private String medioPago;


    public Comprador() {
    }


    public Comprador(String nombre, LocalDate fechaNac, String password, String medioPago) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.password = password;
        this.medioPago = medioPago;
    }

  
    public Comprador(int dni, String nombre, LocalDate fechaNac, String password, String medioPago) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.password = password;
        this.medioPago = medioPago;
    }


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    @Override
    public String toString() {
        return "Comprador{" + "dni=" + dni + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", medioPago=" + medioPago + '}';
    }
}