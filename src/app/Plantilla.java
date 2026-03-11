package app;

import java.util.ArrayList;
import java.util.List;

public class Plantilla {
	private List<Empleado> empleados;

	public Plantilla() {
		empleados = new ArrayList<>();
	}

	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}

	public List<Empleado> getEmpleadosPorNombre(String filtroNombre) {
		List<Empleado> auxEmpleados = new ArrayList<>();
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getNombre().trim().equalsIgnoreCase(filtroNombre)
					|| empleados.get(i).getApellidos().trim().equalsIgnoreCase(filtroNombre)) {
				auxEmpleados.add(empleados.get(i));
			}
			if (filtroNombre.equals("")) {
				return empleados;
			}
		}
		return auxEmpleados;
	}
}
