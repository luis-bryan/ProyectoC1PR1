package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	PanelTitulo pt;
	PanelClientes pc;
	
	
	public VentanaPrincipal() {
		setTitle("BANCO TOBEPE " + "¡ DONDE TU DINERO ESTA SEGURO !");
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		pt = new PanelTitulo();
		pc = new PanelClientes();
		pt.setBackground(Color.white);
		pc.setBackground(Color.white);
		getContentPane().add(pt).setBounds(0, 0, 1385, 50);
		getContentPane().add(pc).setBounds(0, 50,432, 680);;
		setVisible(true);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);

	
	}

}
