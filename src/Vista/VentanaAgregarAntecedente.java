package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaAgregarAntecedente extends JFrame {
  private JLabel tipoan;
  private JLabel descripcionan;
  private JLabel codigo;

  private JTextField tipoan_;
  private JTextField descripcionan_;
  private JTextField codigo_;

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
    descripcionan = new JLabel("DESCRIPCIÓN:");
    add(descripcionan);
    descripcionan_ = new JTextField(30);
    add(descripcionan_);
    codigo = new JLabel("Codigo");
    add(codigo);
    codigo_ = new JTextField();
    add(codigo_);
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

  public JLabel getCodigo() {
    return codigo;
  }

  public void setCodigo(JLabel codigo) {
    this.codigo = codigo;
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

  public JButton getAgregar() {
    return agregar;
  }

  public void setDescripcionan_(JTextField descripcionan_) {
    this.descripcionan_ = descripcionan_;
  }

  public JTextField getCodigo_() {
    return codigo_;
  }

  public void setCodigo_(JTextField codigo_) {
    this.codigo_ = codigo_;
  }
}
