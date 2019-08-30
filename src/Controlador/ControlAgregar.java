package Controlador;


import javax.swing.JOptionPane;

public class ControlAgregar {

	public ControlAgregar() {

	}
	public boolean validarInformacion(String nombre, String cedula) {
		if (nombre.matches("[0-9]*") || nombre.matches("^$")) {
			JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL CAMPO NOMBRE", "ADVERTENCIA ",
				JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (cedula.matches("^$")) {
			JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL CAMPO CEDULA", "ADVERTENCIA ",
				JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}
}
