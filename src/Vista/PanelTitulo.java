package Vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTitulo extends JPanel {
	JLabel titulo = new JLabel("BANCO TOBEPE");

	public PanelTitulo() {
		titulo.setFont(new Font("Berlin Sans FB", Font.BOLD, 35));
		add(titulo);
	}
}