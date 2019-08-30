package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelAntecedentes extends JPanel {
	JPanel panelbotones;
	JButton agregar;
	JButton eliminar;

	public PanelAntecedentes() {
		setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("LISTA DE ANTECEDENTES")));
		setLayout(new GridLayout(2, 1));
		JList<String> listaAntecedentes = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		JScrollPane desplazamientolista = new JScrollPane(listaAntecedentes);
		desplazamientolista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listaAntecedentes.setModel(model);
		add(desplazamientolista);
		panelbotones = new JPanel();
		panelbotones.setLayout(new GridLayout(2,1));

		agregar = new JButton("AGREGAR ANTECEDENTE");
		panelbotones.add(agregar).setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		eliminar = new JButton("ELIMINAR ANTECEDENTE");
		panelbotones.add(eliminar).setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		add(panelbotones).setBackground(Color.white);
	}

	public JPanel getPanelbotones() {
		return panelbotones;
	}

	public void setPanelbotones(JPanel panelbotones) {
		this.panelbotones = panelbotones;
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
}
