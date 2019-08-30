package Modelo;

import java.util.ArrayList;

public class Banco {
  private ArrayList<Cliente> clientes;

  /**
   * Constructor de la clase Banco
   * <b>Pre:</b>
   * <ul>
   * <li>El arrayList de antecedentes se ha inicializadp</li>
   * </ul>
   * <b>Post:</b>
   * <ul>
   * <li>Se crea el arraylist de clientes</li>
   * </ul>
   */
  public Banco() {
    clientes = new ArrayList<Cliente>();
  }

  /**
   * Metodo que me retorna el ArrayList de clientes
   *
   * @return la lista de clientes en el banco
   */
  public ArrayList<Cliente> getClientes() {
    return clientes;
  }

  /**
   * modifica la lista de clientes
   *
   * @param clientes
   */
  public void setClientes(ArrayList<Cliente> clientes) {
    this.clientes = clientes;
  }

  /**
   * Metodo que se imprime en el archivo
   *
   * @return String en donde se contiene el toString de antecedentes y de clientes
   */
  @Override
  public String toString() {
    String toReturn = "Numero de personas:" + clientes.size() + '\n';

    for (int i = 0; i < clientes.size(); i++) {
      toReturn += "Persona No. " + i + "\n";
      toReturn += clientes.get(i).toString();
      toReturn += "\n----------\n";
    }
    return toReturn;
  }
}
