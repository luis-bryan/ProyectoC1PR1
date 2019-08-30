package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaModificar extends JFrame {
  private JLabel nombre;
  private JLabel cedula;
  private JLabel edad;
  private JLabel genero;

  private JTextField nombre_;
  private JTextField cedula_;
  private JTextField edad_;
  private JTextField genero_;

  private JButton modificar;

  public VentanaModificar() {
    setTitle("MODIFICAR ESTUDIANTE");
    setSize(700, 620);
    setResizable(false);
    setLayout(new GridLayout(4, 2));
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);

    nombre = new JLabel("NOMBRE:");
    add(nombre);
    nombre_ = new JTextField(30);
    add(nombre_);
    cedula = new JLabel("CEDULA:");
    add(cedula);
    cedula_ = new JTextField(30);
    add(cedula_);
    edad = new JLabel("EDAD:");
    add(edad);
    edad_ = new JTextField(30);
    add(edad_);
    genero = new JLabel("GENERO");
    add(genero);
    genero_ = new JTextField(30);
    add(genero_);
    modificar = new JButton("MODIFICAR");
    add(modificar);
    modificar.setActionCommand("MODIFICAR");

  }

  public JButton getModificar() {
    return modificar;
  }

  public void setModificar(JButton modificar) {
    this.modificar = modificar;
  }

  public JLabel getNombre() {
    return nombre;
  }

  public void setNombre(JLabel nombre) {
    this.nombre = nombre;
  }

  public JLabel getCedula() {
    return cedula;
  }

  public void setCedula(JLabel cedula) {
    this.cedula = cedula;
  }

  public JLabel getEdad() {
    return edad;
  }

  public void setEdad(JLabel edad) {
    this.edad = edad;
  }

  public JLabel getGenero() {
    return genero;
  }

  public void setGenero(JLabel genero) {
    this.genero = genero;
  }

  public JTextField getNombre_() {
    return nombre_;
  }

  public void setNombre_(JTextField nombre_) {
    this.nombre_ = nombre_;
  }

  public JTextField getCedula_() {
    return cedula_;
  }

  public void setCedula_(JTextField cedula_) {
    this.cedula_ = cedula_;
  }

  public JTextField getEdad_() {
    return edad_;
  }

  public void setEdad_(JTextField edad_) {
    this.edad_ = edad_;
  }

  public JTextField getGenero_() {
    return genero_;
  }

  public void setGenero_(JTextField genero_) {
    this.genero_ = genero_;
  }

}
