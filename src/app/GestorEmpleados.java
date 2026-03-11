package app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestorEmpleados {
	private Plantilla plantilla;
	private IEntradaSalida consola;

	public GestorEmpleados(Plantilla plantilla, IEntradaSalida consola) {
		this.plantilla = plantilla;
		this.consola = consola;
	}

	public void ejecutar() {

		int opcion = 0;
		do {
			consola.mostrarMenu();
			opcion = consola.leerEntero("Introduce una opción :");
			switch (opcion) {
			case 1 -> contratarEmpleado();
			case 2 -> listarTodos();
			case 3 -> listarPorFiltro();
			case 4 -> consola.imprimirLinea("Hasta pronto!!");
			default -> opcion = consola.leerEntero("Introduce una opción :");
			}
		} while (opcion != 4);
	}

	private void contratarEmpleado() {
		Empleado empleado = null;
		String nombre, apellidos, dni;
		double sueldoBase, ventas;
		int opcion, categoria;
		do {

			consola.imprimirLinea("1 - Técnico");
			consola.imprimirLinea("2 - Comercial");
			opcion = consola.leerEntero("¿Qué tipo de empleado quieres contratar?");
		} while (!(opcion > 0 && opcion < 3));
		nombre = consola.leerTexto("Introduce el nombre del empleado");
		apellidos = consola.leerTexto("Introduce los apellidos del empleado");
		dni = consola.leerTexto("Introduce el DNI del empleado");
		sueldoBase = consola.leerImporte("Introduce el sueldo base del empleado");

		if (opcion == 1) {
			categoria = consola.leerEntero("Introduce el número de categoria");
			empleado = new Tecnico(dni, nombre, apellidos, sueldoBase, categoria);
		} else if (opcion == 2) {
			ventas = consola.leerImporte("Introduce el importe de las ventas del empleado");
			empleado = new Comercial(dni, nombre, apellidos, sueldoBase);
			((Comercial) empleado).setVentas(ventas);
		}
		plantilla.agregarEmpleado(empleado);
	}

	private void listarTodos() {
		List<Empleado> auxEmpleados = new ArrayList<>();
		auxEmpleados = plantilla.getEmpleadosPorNombre("");
		ordenarPorNombre(auxEmpleados);
		listarEmpleados(auxEmpleados);
	}

	private void listarPorFiltro() {
		String filtro;
		filtro = consola.leerTexto("¿Nombre o apellido por el que buscar?");
		listarEmpleados(plantilla.getEmpleadosPorNombre(filtro));

	}

	private void listarEmpleados(List<Empleado> empleados) {
		for (int i = 0; i < empleados.size(); i++) {
			consola.imprimirLinea("N - " + empleados.get(i).getNombre() + " Apellidos : "
					+ empleados.get(i).getApellidos() + " Sueldo : " + empleados.get(i).getSueldo() + "€");
		}
	}

	private void ordenarPorNombre(List<Empleado> empleados) {
		empleados.sort(Comparator.comparing(Empleado::getNombre));
	}

}
