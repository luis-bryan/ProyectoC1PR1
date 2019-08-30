package Controlador;


import javax.swing.JOptionPane;

public class ControlAgregar {

  public ControlAgregar() {

  }

  public boolean validarInformacion(String nombre, String cedula, String genero, String edad) {
    if (nombre.matches("[0-9]*") || nombre.matches("^$")) {
      JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL CAMPO NOMBRE", "ADVERTENCIA ",
        JOptionPane.ERROR_MESSAGE);
      return false;
    } else if (cedula.matches("^$")) {
      JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL CAMPO CEDULA", "ADVERTENCIA ",
        JOptionPane.ERROR_MESSAGE);
      return false;
    } else if (!genero.matches("M|F")) {
      JOptionPane.showMessageDialog(null, "HAY UN ERRROR EN EL CAMPO GENERO", "ADVERTENCIA",
        JOptionPane.ERROR_MESSAGE);
      return false;
    } else if (!edad.matches("[0-9]*")) {
      JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL CAMPO EDAD", "ADVERTENCIA",
        JOptionPane.ERROR_MESSAGE);
      return false;
    } else {
      return true;
    }
  }
}
