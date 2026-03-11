package app;

public class Tecnico extends Empleados {

	private int categoria;

	public Tecnico(String dni, String nombre, String apellidos, double sueldoBase, int categoria) {
		super(dni, nombre, apellidos, sueldoBase);
		this.categoria = categoria;
	}

	@Override
	public double getSueldo() {
		return (getsueldoBase() + categoria) * 100;
	}

}
