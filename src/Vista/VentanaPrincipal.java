package Vista;

import java.awt.Color;

import javax.swing.JFrame;

import Controlador.ControlBanco;

public class VentanaPrincipal extends JFrame {
	PanelTitulo pt;
	PanelClientes pc;
	PanelAntecedentes pa;
	PanelInformaci�nAnte pi;
	
	
	public VentanaPrincipal() {
		setTitle("BANCO TOBEPE " + "? DONDE TU DINERO ESTA SEGURO !");
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		pt = new PanelTitulo();
		pc = new PanelClientes();
		pa=new PanelAntecedentes();
		pi=new PanelInformaci�nAnte();
		
		pt.setBackground(Color.white);
		pc.setBackground(Color.white);
		pa.setBackground(Color.white);
		pi.setBackground(Color.white);
		getContentPane().add(pt).setBounds(0, 0, 1385, 50);
		getContentPane().add(pc).setBounds(0, 50,450, 680);
		getContentPane().add(pa).setBounds(452, 50, 450,680);
		getContentPane().add(pi).setBounds(902, 50, 460, 680);
		setVisible(true);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
