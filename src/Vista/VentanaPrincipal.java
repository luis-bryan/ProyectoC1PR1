package Vista;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	PanelTitulo pt;

	public VentanaPrincipal() {
		setTitle("BANCO TOBEPE " + "¡ DONDE TU DINERO ESTA SEGURO !");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);

		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		pt = new PanelTitulo();
		add(pt);
		setVisible(true);

	}

}
