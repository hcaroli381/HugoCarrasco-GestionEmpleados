package app;

public abstract class Empleado {
	private String dni;
	private String nombre;
	private String apellidos;
	private double sueldoBase;

	public Empleado(String dni, String nombre, String apellidos, double sueldoBase) {

		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldoBase = sueldoBase;
	}

	public double getsueldoBase() {
		return sueldoBase;
	}

	public void setsueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public abstract double getSueldo();
}
