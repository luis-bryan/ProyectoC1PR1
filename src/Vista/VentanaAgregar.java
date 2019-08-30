package Vista;

import Controlador.ControlAgregar;
import Controlador.ControlBanco;
import Modelo.Cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaAgregar extends JFrame {
  JLabel nombre;
  JLabel cedula;
  JLabel edad;
  JLabel genero;
  ControlAgregar ca;
  JTextField nombre_;
  JTextField cedula_;
  JTextField edad_;
  JTextField genero_;
  JButton agregar;
  JButton volver;

  public VentanaAgregar() {
    ca = new ControlAgregar();

    setTitle("AGREGAR ESTUDIANTE");
    setSize(700, 620);
    setResizable(false);
    setLayout(new GridLayout(5, 1));
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(false);

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
    agregar = new JButton("AGREGAR");
    add(agregar);
    volver = new JButton("VOLVER");
    add(volver);
    volver.setActionCommand("VOLVER");
    agregar.setActionCommand("AGREGAR");
  }

  public JButton getAgregar() {
    return agregar;
  }

  public void setAgregar(JButton agregar) {
    this.agregar = agregar;
  }

  public JLabel getNombre() {
    return nombre;
  }

  public void setNombre(JLabel nombre) {
    this.nombre = nombre;
  }

  public JLabel getEdad() {
    return edad;
  }

  public void setEdad(JLabel edad) {
    this.edad = edad;
  }

  public JLabel getCedula() {
    return cedula;
  }

  public void setCedula(JLabel cedula) {
    this.cedula = cedula;
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

  public JButton getVolver() {
    return volver;
  }
}