package Vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import  java.util.Date;
public class VentanaAgregarAntecedente extends JFrame{
	JLabel tipoan;
	JLabel descripcionan;
	JLabel fecha;

	JTextField tipoan_;
	JTextField descripcionan_;
	JTextField dia;
	JTextField mes;
	JTextField a�o;
	
	JButton agregar;

	public VentanaAgregarAntecedente() {
		
		setTitle("AGREGAR ANTECEDENTE");
		setSize(700, 620);
		setResizable(false);
		setLayout(new GridLayout(4, 1));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	


		 tipoan = new JLabel("TIPO ANTECEDENTE:");
		add(tipoan);
		tipoan_ = new JTextField(30);
		add(tipoan_);
		descripcionan = new JLabel("DESCRIPCI�N:");
		add(descripcionan);
		descripcionan_ = new JTextField(30);
		add(descripcionan_);
		fecha = new JLabel("FECHA");
		add(fecha);
		dia = new JTextField(10);
		add(dia);
		mes = new JTextField(10);
		add(mes);
		a�o = new JTextField(10);
		add(a�o);
		agregar = new JButton("AGREGAR ANTECEDENTE");
		add(agregar);
		agregar.setActionCommand("AGREGAR ANTECEDENTE");

	}

	public JLabel getTipoan() {
		return tipoan;
	}

	public void setTipoan(JLabel tipoan) {
		this.tipoan = tipoan;
	}

	public JLabel getDescripcionan() {
		return descripcionan;
	}

	public void setDescripcionan(JLabel descripcionan) {
		this.descripcionan = descripcionan;
	}

	public JLabel getFecha() {
		return fecha;
	}

	public void setFecha(JLabel fecha) {
		this.fecha = fecha;
	}

	public JTextField getTipoan_() {
		return tipoan_;
	}

	public void setTipoan_(JTextField tipoan_) {
		this.tipoan_ = tipoan_;
	}

	public JTextField getDescripcionan_() {
		return descripcionan_;
	}

	public void setDescripcionan_(JTextField descripcionan_) {
		this.descripcionan_ = descripcionan_;
	}

	public JTextField getDia() {
		return dia;
	}

	public void setDia(JTextField dia) {
		this.dia = dia;
	}

	public JTextField getMes() {
		return mes;
	}

	public void setMes(JTextField mes) {
		this.mes = mes;
	}

	public JTextField getA�o() {
		return a�o;
	}

	public void setA�o(JTextField a�o) {
		this.a�o = a�o;
	}

	public JButton getAgregar() {
		return agregar;
	}

	public void setAgregar(JButton agregar) {
		this.agregar = agregar;
	}


}
