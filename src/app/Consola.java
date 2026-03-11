package app;

import java.util.Scanner;

public class Consola implements IEntradaSalida {
	private Scanner sc;

	public Consola() {
		this.sc = new Scanner(System.in);
	}

	@Override
	public void imprimir(String texto) {
		System.out.print(texto);
	}

	@Override
	public void imprimirLinea(String texto) {
		System.out.println(texto);
	}

	@Override
	public String leerTexto(String mensaje) {
		imprimirLinea(mensaje);
		return sc.next();
	}

	@Override
	public int leerEntero(String mensaje) {
		int resultado = 0;
		boolean hayError = true;
		imprimir(mensaje);
		do {
			try {
				resultado = sc.nextInt();
				hayError = false;
			} catch (Exception e) {
				imprimir("Error: Introduce un número entero válido.");
				sc.nextLine();
			}
		} while (hayError);
		return resultado;
	}

	@Override
	public double leerImporte(String mensaje) {
		imprimir(mensaje);
		String auxResultado;
		double resultado = 0.0;
		boolean hayError = true;
		do {
			try {
				auxResultado = leerTexto("");
				resultado = Double.valueOf(auxResultado.replace(',', '.'));
				hayError = false;
			} catch (Exception e) {

				System.err.println("Error: Introduce un número decimal válido.");
				sc.nextLine();

			}
		} while (hayError);
		return resultado;

	}

	@Override
	public void mostrarMenu() {
		imprimirLinea("1 - Contratar empleado");
		imprimirLinea("2 - Listar todos los empleados");
		imprimirLinea("3 - Listar empleados con filtro");
		imprimirLinea("4 - Salir");
	}

	@Override
	public void limpiarPantalla() {
		for (int i = 0; i < 50; i++) {
			imprimirLinea("");
		}
	}

	@Override
	public void pausa() {
		imprimir("Pulse una tecla para continuar...");
	}

}
