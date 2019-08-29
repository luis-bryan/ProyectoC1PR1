package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelClientes extends JPanel implements ActionListener {
	JButton agregar;
	JButton eliminar;
	JButton modificar;
	JPanel pBotones;


	public PanelClientes() {
		setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("LISTA DE CLIENTES")));
		setLayout(new GridLayout(2,1));
		JList<String> listaCliente = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		JScrollPane desplazamientolista = new JScrollPane(listaCliente);
		desplazamientolista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		model.addElement("BRYAN TORRES");
		listaCliente.setModel(model);
		add(desplazamientolista);
	
		pBotones= new JPanel();
		pBotones.setLayout(new GridLayout(3,1));
		
		agregar = new JButton("AGREGAR CLIENTE");
		pBotones.add(agregar).setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		modificar = new JButton("MODIFICAR CLIENTE");
		pBotones.add(modificar).setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		eliminar = new JButton("ELIMINAR CLIENTE");
		pBotones.add(eliminar).setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		add(pBotones).setBackground(Color.white);;
		agregar.addActionListener(this);
		modificar.addActionListener(this);
		eliminar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("AGREGAR CLIENTE")){

		} else if (e.getActionCommand().equals("MODIFICAR CLIENTE")){

		} else if (e.getActionCommand().equals("ELIMINAR CLIENTE")){

		}
	}
}
