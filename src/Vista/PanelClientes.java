package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Modelo.Banco;
import Modelo.Cliente;

public class PanelClientes extends JPanel {
	JButton agregar;
	JButton eliminar;
	JButton modificar;
	JPanel pBotones;
	JList listaclientes;
	VentanaAgregar va;
	VentanaModificar vm;
	DefaultListModel<String> model;

	public PanelClientes() {
		setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("LISTA DE CLIENTES")));
		setLayout(new GridLayout(2, 1));
		listaclientes = new JList<String>();
		model = new DefaultListModel<String>();
		JScrollPane desplazamientolista = new JScrollPane(listaclientes);
		vm = new VentanaModificar();
		desplazamientolista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listaclientes.setModel(model);
		listaclientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add(desplazamientolista);

		pBotones = new JPanel();
		pBotones.setLayout(new GridLayout(3, 1));

		agregar = new JButton("AGREGAR CLIENTE");
		pBotones.add(agregar).setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		modificar = new JButton("MODIFICAR CLIENTE");
		pBotones.add(modificar).setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		eliminar = new JButton("ELIMINAR CLIENTE");
		pBotones.add(eliminar).setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		add(pBotones).setBackground(Color.white);
		add(pBotones).setBackground(Color.white);

	}

	public JButton getAgregar() {
		return agregar;
	}

	public void setAgregar(JButton agregar) {
		this.agregar = agregar;
	}

	public JButton getEliminar() {
		return eliminar;
	}

	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}

	public JButton getModificar() {
		return modificar;
	}

	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}

	public JPanel getpBotones() {
		return pBotones;
	}

	public void setpBotones(JPanel pBotones) {
		this.pBotones = pBotones;
	}

	public JList getListaclientes() {
		return listaclientes;
	}

	public void setListaclientes(JList listaclientes) {
		this.listaclientes = listaclientes;
	}

	public VentanaAgregar getVa() {
		return va;
	}

	public void setVa(VentanaAgregar va) {
		this.va = va;
	}

	public VentanaModificar getVm() {
		return vm;
	}

	public void setVm(VentanaModificar vm) {
		this.vm = vm;
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<String> model) {
		this.model = model;
	}

}
