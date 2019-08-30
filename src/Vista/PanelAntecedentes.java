package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelAntecedentes extends JPanel {
  private JPanel panelbotones;
  private JButton agregar;
  private JButton eliminar;
  private JList<String> listaAntecedentes;
  private DefaultListModel<String> model;

  public PanelAntecedentes() {
    setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("LISTA DE ANTECEDENTES")));
    setLayout(new GridLayout(2, 1));
    listaAntecedentes = new JList<String>();
    model = new DefaultListModel<String>();
    JScrollPane desplazamientolista = new JScrollPane(listaAntecedentes);
    listaAntecedentes.setSelectedIndex(ListSelectionModel.SINGLE_SELECTION);
    desplazamientolista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    listaAntecedentes.setModel(model);
    add(desplazamientolista);
    panelbotones = new JPanel();
    panelbotones.setLayout(new GridLayout(2, 1));

    agregar = new JButton("AGREGAR ANTECEDENTE");
    panelbotones.add(agregar).setFont(new Font("Comic Sans MS", Font.BOLD, 15));
    eliminar = new JButton("ELIMINAR ANTECEDENTE");
    panelbotones.add(eliminar).setFont(new Font("Comic Sans MS", Font.BOLD, 15));
    add(panelbotones).setBackground(Color.white);

    agregar.setActionCommand("AGREGAR A");
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

  public JList<String> getListaAntecedentes() {
    return listaAntecedentes;
  }

  public void setListaAntecedentes(JList<String> listaAntecedentes) {
    this.listaAntecedentes = listaAntecedentes;
  }

  public DefaultListModel<String> getModel() {
    return model;
  }

  public void setModel(DefaultListModel<String> model) {
    this.model = model;
  }
}
