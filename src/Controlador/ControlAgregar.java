package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.Banco;
import Modelo.Cliente;
import Vista.PanelClientes;
import Vista.VentanaAgregar;
import Vista.VentanaModificar;
import Vista.VentanaPrincipal;

public class ControlAgregar implements ActionListener {

	VentanaAgregar va = new VentanaAgregar();
	Banco banco;
	PanelClientes pc;

	public ControlAgregar(PanelClientes pc, Banco banco) {
		this.banco = banco;
		this.va = pc.getVa();
		this.pc = pc;

		va.getAgregar().addActionListener(this);

	}

	public boolean validarInformacion(String nombre, String cedula) {
		if (nombre.matches("[0-9]*") || nombre.matches("^$")) {
			JOptionPane.showMessageDialog(va, "HAY UN ERROR EN EL CAMPO NOMBRE", "ADVERTENCIA ",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (cedula.matches("^$")) {
			JOptionPane.showMessageDialog(va, "HAY UN ERROR EN EL CAMPO CEDULA", "ADVERTENCIA ",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("AGREGAR")) {

				String auxnombre = va.getNombre_().getText();
				String auxedad = va.getEdad_().getText();
				int edad = Integer.parseInt(auxedad);
				String auxcedula = va.getCedula_().getText();
				String auxgenero = va.getGenero_().getText();

				if (validarInformacion(auxnombre, auxcedula)) {

					int input = JOptionPane.showOptionDialog(va,
							"DATOS INGRESADOS CORRECTAMENTE \n ¿ DESEA GUARDAR CLIENTE ?", "IMPORTANTE",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
					if (input == JOptionPane.YES_OPTION) {
						Cliente x = new Cliente(auxnombre, auxcedula, Integer.parseInt(auxedad), auxgenero.charAt(0));
						System.out.println(x.toString());
						banco.getClientes().add(x);

						System.out.println(banco.getClientes().toString());
						pc.getModel().addElement(auxnombre);

						va.setVisible(false);

						va.getEdad_().setText("");

						va.getNombre_().setText("");
						va.getCedula_().setText("");
						va.getGenero_().setText("");
					}
				}
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(va,
					"HAY DATOS INCORRECTOS EN ALGUNAS CASILLAS \n POR FAVOR VUELVE A VALIDAR LA INFORMACIÓN",
					"ADVERTENCIA ", JOptionPane.ERROR_MESSAGE);
		}

	}

}
