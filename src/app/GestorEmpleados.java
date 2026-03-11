package app;

import java.util.List;

public class GestorEmpleados {
	private Plantilla plantilla;
	private IEntradaSalida consola;

	public GestorEmpleados(Plantilla plantilla, IEntradaSalida consola) {
		this.plantilla = plantilla;
		this.consola = consola;
	}

	public void ejecutar() {

	}

	private void contratarEmpleado() {
		Empleado empleado = null;
		String nombre, apellidos, dni;
		double sueldoBase, ventas;
		int opcion, categoria;
		do {
			opcion = consola.leerEntero("¿Qué tipo de empleado quieres contratar?");
			consola.imprimirLinea("1 - Técnico");
			consola.imprimirLinea("2 - Comercial");
		} while (opcion != 1 || opcion != 2);
		nombre = consola.leerTexto("Introduce el nombre del empleado");
		apellidos = consola.leerTexto("Introduce los apellidos del empleado");
		dni = consola.leerTexto("Introduce el DNI del empleado");
		sueldoBase = consola.leerImporte("Introduce el sueldo base del empleado");

		if (opcion == 1) {
			categoria = consola.leerEntero("Introduce el número de categoria");
			empleado = new Tecnico(dni, nombre, apellidos, sueldoBase, categoria);
		} else if (opcion == 2) {
			ventas = consola.leerImporte("Introduce el importe de las ventas del empleado");
			empleado = new Comercial(dni, nombre, apellidos, sueldoBase, ventas);
		}
		plantilla.agregarEmpleado(empleado);
	}

	private void listarTodos() {

	}

	private void listarPorFiltro() {

	}

	private void listarEmpleados() {

	}

	private void ordenarPorNombre(List<Empleado> empleados) {

	}

}
