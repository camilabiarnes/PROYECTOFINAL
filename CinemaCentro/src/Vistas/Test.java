/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Comprador;
import Persistencia.CompradorData;
import java.time.LocalDate;
import java.util.List;

/**
 * Clase de prueba para demostrar CRUD básico de Comprador.
 */
public class Test {

	public static void main(String[] args) {
		CompradorData dao = new CompradorData();

		// Crear comprador de ejemplo
		Comprador c = new Comprador(12345678, "Juan Perez", LocalDate.of(1990, 1, 1), "miPassword123", "tarjeta");

		// Guardar
		int dniGuardado = dao.guardarComprador(c);
		System.out.println("DNI guardado: " + dniGuardado);

		// Buscar por DNI
		Comprador buscado = dao.buscarCompradorPorDni(12345678);
		System.out.println("Comprador buscado: " + buscado);

		// Listar todos
		List<Comprador> lista = dao.listarCompradores();
		System.out.println("Lista de compradores (total=" + lista.size() + "): ");
		for (Comprador x : lista) {
			System.out.println(" - " + x);
		}

		// Actualizar
		buscado.setNombre("Juan P. Actualizado");
		buscado.setMedioPago("efectivo");
		buscado.setPassword("nuevaPass456");
		boolean ok = dao.actualizarComprador(buscado);
		System.out.println("Actualizado: " + ok);

		// Volver a buscar y mostrar
		Comprador actualizado = dao.buscarCompradorPorDni(12345678);
		System.out.println("Comprador actualizado: " + actualizado);

		// Eliminar
		boolean borrado = dao.eliminarComprador(12345678);
		System.out.println("Eliminado: " + borrado);
	}
}

