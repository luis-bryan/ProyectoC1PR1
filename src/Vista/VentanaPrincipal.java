package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controlador.ControlAgregar;
import Controlador.ControlBanco;
import Modelo.Cliente;

public class VentanaPrincipal extends JFrame implements ActionListener{
	PanelTitulo pt;
	PanelClientes pc;
	PanelAntecedentes pa;
	PanelInformaciónAnte pi;
	VentanaAgregar va;
	VentanaModificar vm;
	ControlBanco cb;
	ControlAgregar ca;

	public VentanaPrincipal() {
		setTitle("BANCO TOBEPE " + "? DONDE TU DINERO ESTA SEGURO !");
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		pt = new PanelTitulo();
		pc = new PanelClientes();
		pa = new PanelAntecedentes();
		pi = new PanelInformaciónAnte();
		va = new VentanaAgregar();
		vm = new VentanaModificar();
		ca = new ControlAgregar();
		cb = new ControlBanco();
		for (int i=0; i<cb.getBanco().getClientes().size(); i++){
			pc.getModel().addElement(cb.getBanco().getClientes().get(i).getCedula());
		}

		pc.getAgregar().addActionListener(this);
		pc.getModificar().addActionListener(this);
		pc.getEliminar().addActionListener(this);

		pa.getAgregar().addActionListener(this);
		pa.getEliminar().addActionListener(this);

		va.getAgregar().addActionListener(this);

		vm.getModificar().addActionListener(this);


		pt.setBackground(Color.white);
		pc.setBackground(Color.white);
		pa.setBackground(Color.white);
		pi.setBackground(Color.white);
		va.setBackground(Color.white);
		getContentPane().add(pt).setBounds(0, 0, 1385, 50);
		getContentPane().add(pc).setBounds(0, 50, 450, 680);
		getContentPane().add(pa).setBounds(452, 50, 450, 680);
		getContentPane().add(pi).setBounds(902, 50, 460, 680);
		setVisible(true);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public PanelTitulo getPt() {
		return pt;
	}

	public void setPt(PanelTitulo pt) {
		this.pt = pt;
	}

	public PanelClientes getPc() {
		return pc;
	}

	public void setPc(PanelClientes pc) {
		this.pc = pc;
	}

	public PanelAntecedentes getPa() {
		return pa;
	}

	public void setPa(PanelAntecedentes pa) {
		this.pa = pa;
	}

	public PanelInformaciónAnte getPi() {
		return pi;
	}

	public void setPi(PanelInformaciónAnte pi) {
		this.pi = pi;
	}

	public VentanaAgregar getVa() {
		return va;
	}

	public void setVa(VentanaAgregar va) {
		this.va = va;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("AGREGAR CLIENTE")) {
			va.setVisible(true);

		} else if (e.getActionCommand().equals("MODIFICAR CLIENTE")) {
			for (int i = 0; i < cb.getBanco().getClientes().size(); i++) {
				if (cb.getBanco().getClientes().get(i).getCedula().equals(pc.listaclientes.getSelectedValue())) {
					Cliente selected = cb.getBanco().getClientes().get(i);
					vm.getNombre_().setText(selected.getNombre());
					vm.getCedula_().setText(selected.getCedula());
					vm.getCedula_().setDisabledTextColor(Color.GRAY);
					vm.getCedula_().setEnabled(false);
					vm.getCedula_().setSelectionColor(Color.GRAY);
					vm.getEdad_().setText(Integer.toString(selected.getEdad()));
					vm.getGenero_().setText(String.valueOf(selected.getGenero()));
				}
			}
			vm.setVisible(true);


		} else	if (e.getActionCommand().equals("AGREGAR")) {

			String auxnombre = va.getNombre_().getText();
			String auxedad = va.getEdad_().getText();
			int edad = Integer.parseInt(auxedad);
			String auxcedula = va.getCedula_().getText();
			String auxgenero = va.getGenero_().getText();
			if (ca.validarInformacion(auxnombre, auxcedula)) {

				int input = JOptionPane.showOptionDialog(va,
					"DATOS INGRESADOS CORRECTAMENTE \n ¿ DESEA GUARDAR CLIENTE?", "IMPORTANTE",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
				if (input == JOptionPane.YES_OPTION) {
					cb.agregarCliente(auxnombre, auxcedula, edad, auxgenero.charAt(0));

					System.out.println(cb.getBanco().getClientes().toString());
					pc.getModel().addElement(auxcedula);

					va.setVisible(false);

					va.getEdad_().setText("");
					va.getNombre_().setText("");
					va.getCedula_().setText("");
					va.getGenero_().setText("");
				}
			}
		}else if(e.getActionCommand().equals("MODIFICAR")){
			String auxnombre = vm.getNombre_().getText();
			String auxcedula = vm.getCedula_().getText();
			System.out.println(auxcedula);
			String auxedad = vm.getEdad_().getText();
			int edad = Integer.parseInt(auxedad);
			String auxgenero = vm.getGenero_().getText();
			cb.modificarCliente(auxcedula, auxnombre,edad,auxgenero.charAt(0));
			vm.setVisible(false);
		} else if(e.getActionCommand().equals("ELIMINAR CLIENTE")){
			if (!pc.getListaclientes().isSelectionEmpty()){
				String cedula = pc.getListaclientes().getSelectedValue().toString();
				int opcion = JOptionPane.showOptionDialog(null, "Deseas eliminar el cliente con cedula " + cedula + "?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (opcion == JOptionPane.YES_OPTION){
					Cliente toDelete = cb.buscarCliente(cedula);
					if (toDelete != null){
						cb.eliminarCliente(cedula);
						pc.getModel().removeElement(cedula);
						pc.getListaclientes().setModel(pc.getModel());
					}
				}
			}
		}
	}




}
