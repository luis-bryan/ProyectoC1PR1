package Controlador;

import Modelo.Antecedente;
import Modelo.Banco;
import Modelo.Cliente;
import Vista.VentanaPrincipal;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ControlBanco {
  VentanaPrincipal vp;
  Banco banco;
  Antecedente antecedente;
  private File archivo = new File("data/datos.txt");

  /**
   * Constructor de la clase ControlBanco
   *
   * <b>Pre:</b>
   * <ul>
   * <li>Existe una carpeta Data</li>
   * </ul>
   * <b>Post:</b>
   * <ul>
   * <li>Existe un archivo de texto datos.txt dentro de la carpeta data</li>
   * <li>Se creo el objeto banco</li>
   * <li>Se realizo la lectura del archivo</li>
   * </ul>
   */
  public ControlBanco() {
    banco = new Banco();
    if (archivo.exists()) {
      System.out.println("El archivo existe");
    } else {
      try {
        archivo.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    lecturaArchivo();

  }

  /**
   * Busca un cliente
   * <b>Pre:</b>
   * <ul>
   * <li>El arrayList de clientes se encuentra inicializado</li>
   * </ul>
   * <b>Post:</b>
   * <ul>
   * <li>Se encontro un objeto de la clase cliente</li>
   * </ul>
   *
   * @param pCedula Se usa para buscar el cliente, dado que dos personas no pueden tener la misma cedula
   *                pCedula != "" y pCedula != null
   * @return un objeto de la clase cliente si se encontro, null si el cliente no existe
   */
  public Cliente buscarCliente(String pCedula) {
    Cliente c = null;
    try {
      if (!banco.getClientes().isEmpty()) {
        for (int i = 0; i < banco.getClientes().size(); i++) {
          if (banco.getClientes().get(i).getCedula().equals(pCedula)) {
            c = banco.getClientes().get(i);
          }
        }
      }

    } catch (Exception e) {
      JOptionPane.showInputDialog("El usuario no ha sido encontrado");
    }
    return c;
  }

  /**
   * Busca un objeto de la clase antecedente
   *
   * <b>Pre:</b>
   * <ul>
   * <li>El arrayList de clientes se encuentra inicializado</li>
   * <li>El arrayList de antecedentes se encuentra inicializado</li>
   * </ul>
   *
   * <b>Post:</b>
   * <ul>
   * <li>Se encontro un objeto de la clase Antecedente</li>
   * </ul>
   *
   * @param c       Toma el cliente dado
   *                c != "" y c != null
   * @param pCodigo Busca dentro de los antecedentes del cliente dicho codigo
   *                pCodigo != "" y pCodigo != null
   * @return un objeto de la clase Antecedente si se encontro. En caso contrario devuelve null
   */
  public Antecedente buscarAntecedente(String pCodigo, Cliente c) {
    Antecedente a = null;
      if (c.getAntecedentes()!=null) {
        for (int i = 0; i < c.getAntecedentes().size(); i++) {
          if (c.getAntecedentes().get(i).getCodigo().equals(pCodigo)) {
            a = c.getAntecedentes().get(i);
          }
        }
      }
    return a;
  }

  /**
   * Metodo que agrega un Cliente al arrayList y lo escribe en el archivo
   *
   * <b>Pre:</b>
   * <ul>
   * <li>El arrayList de clientes se encuentra inicializado</li>
   * </ul>
   *
   * <b>Post:</b>
   * <ul>
   * <li>Se agrego un objeto de la clase Cliente al arraylList y se escribio en el archivo dicho cliente</li>
   * </ul>
   *
   * @param pNombre El nombre digitado por el usuario
   *                pNombre != null y pNombre != ""
   * @param pCedula La cedula digitada por el usuario
   *                pCedula != null y pCedula != "";
   * @param pEdad   Edad ingresada por el usuario
   *                pEdad != 0
   * @param pGenero Genero seleccionado por el usuario
   */
  public void agregarCliente(String pNombre, String pCedula, int pEdad, char pGenero) {
    Cliente c = buscarCliente(pCedula);
      if (c == null) {
        c = new Cliente(pNombre, pCedula, pEdad, pGenero);
        banco.getClientes().add(c);
        escribirArchivoCliente();
      } else{
        JOptionPane.showInputDialog("El cliente ya existe en el sistema");

      }
  }

  /**
   * Metodo que agrega un antecedente a la lista de antecedentes de un cliente
   *
   * <b>Pre:</b>
   * <ul>
   * <li>El arrayList de antecedentes se encuentra inicializado</li>
   * <li>El arrayList de clientes se encuentra inicializado</li>
   * <li>El cliente a sido encontrado</li>
   * <li>El archivo existe</li>
   * </ul>
   *
   * <b>Post:</b>
   * <ul>
   * <li>Se agrego un antecedente a un cliente y se escribio en el archivo</li>
   * </ul>
   *
   * @param pCodigo      codigo digitado por el usuario
   *                     pCodigo != null y pCodigo != ""
   * @param pDescripcion resumen general del antecedente
   *                     pDescripcion != null y pDescripcion != ""
   * @param pTitulo      titulo del antecedente ingresado por el usuario
   *                     pTitulo != null y pTitulo != ""
   * @param pCedula      cedula del cliente al que se le agrega el antecedente
   *                     pCedula != null y pCedula != ""
   */
  public void agregarAntecedente(String pCodigo, String pDescripcion, String pTitulo, String pCedula) {
    Cliente c = buscarCliente(pCedula);
    Antecedente a = buscarAntecedente(pCodigo, c);
    if (a == null) {
      a = new Antecedente(pCodigo, pDescripcion, pTitulo);
      buscarCliente(pCedula).getAntecedentes().add(a);
      escribirArchivoCliente();
    }
  }

  /**
   * Metodo que elimina un cliente de la lista y del antecedente
   *
   * <b>Pre:</b>
   * <ul>
   * <li>El arrayList de clientes se encuentra inicializado</li>
   * </ul>
   * <b>Post:</b>
   * <ul>
   * <li>Se elimino el cliente de la lista</li>
   * </ul>
   *
   * @param pCedula cedula ingresada
   *                pCedula != null y pCedula != ""
   */
  public void eliminarCliente(String pCedula) {
    Cliente c = buscarCliente(pCedula);
    if (c != null) {
      banco.getClientes().remove(c);
      escribirArchivoCliente();
    }
  }

  /**
   * Metodo que elimina un antecedente de un cliente
   *
   * <b>Pre:</b>
   * <ul>
   * <li>El arrayList de clientes se encuentra inicializado</li>
   * <li>El arrayList de antecedentes se encuentra inicializado</li>
   * </ul>
   * <b>Post:</b>
   * <ul>
   * <li>Se elimino un atencedente del cliente seleccionado</li>
   * </ul>
   *
   * @param pCodigo codigo del antecedente
   *                pCodigo != null y pCodigo != ""
   * @param pCedula cedula del cliente seleccionado
   *                pCedula != null y pCedula != ""
   */
  public void eliminarAntecedente(String pCodigo, String pCedula) {
    Cliente c = buscarCliente(pCedula);

    Antecedente a = buscarAntecedente(pCodigo, c);
    if (a != null) {
      buscarCliente(pCedula).getAntecedentes().remove(a);
      escribirArchivoCliente();
    }
  }

  /**
   * Metodo que modifica los datos de un cliente
   * <b>Pre:</b>
   * <ul>
   * <li>El arrayList de clientes se encuentra inicializado</li>
   * </ul>
   * <b>Post:</b>
   * <ul>
   * <li>Se modifico el nombre, la edad y el genero de dicho cliente</li>
   * </ul>
   *
   * @param pCedula identificador del cliente
   *                pCedula != null y pCedula != ""
   * @param pNombre digitado por el usuario
   *                pNombre != null y pNombre != ""
   * @param pEdad   ingresado por el usuario
   *                pEdad != 0
   * @param pGenero seleccionado por el usuario
   */
  public void modificarCliente(String pCedula, String pNombre, int pEdad, char pGenero) {
    Cliente c = buscarCliente(pCedula);
    if (c != null) {
      c.setNombre(pNombre);
      c.setEdad(pEdad);
      c.setGenero(pGenero);
      escribirArchivoCliente();
    }
  }

  /**
   * Metodo que escribe en el archivo
   *
   * <b>Pre:</b>
   * <ul>
   * <li>El archivo existe</li>
   * </ul>
   * <b>Post:</b>
   * <ul>
   * <li>Se imprime el toString de banco en el archivo</li>
   * </ul>
   */
  public void escribirArchivoCliente() {
    FileWriter escritura;
    PrintWriter pw;
    try {
      escritura = new FileWriter(archivo);
      pw = new PrintWriter(escritura);
      pw.println(banco.toString());
      pw.close();
      escritura.close();
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "No se pudo agregar el cliente al archivo");
    }
  }

  /**
   * Metodo que hace la respectiva lectura del archivo de texto
   *
   * <b>Pre:</b>
   * <ul>
   * <li>El archivo existe</li>
   * </ul>
   * <b>Post:</b>
   * <ul>
   * <li>Se hizo la lectura del archivo segun los separadores "=", ";", "," y ":"</li>
   * </ul>
   */
  public void lecturaArchivo() {
    String cadena = null;
    FileReader lectura;
    BufferedReader lec;
    try {
      lectura = new FileReader(archivo);
      lec = new BufferedReader(lectura);
      String nombre = "";
      String cedula = "";
      int edad = 0;
      char genero = ' ';
      ArrayList<Antecedente> listaNuevosAntecedentes = new ArrayList<Antecedente>();
      Antecedente nuevo;

      while ((cadena = lec.readLine()) != null) {
        String[] separado = cadena.split("=");
        if (separado[0].equals("Nombre")) {
          nombre = separado[1];
        } else if (separado[0].equals("Cedula")) {
          cedula = separado[1];
        } else if (separado[0].equals("Edad")) {
          edad = Integer.parseInt(separado[1]);
        } else if (separado[0].equals("Genero")) {
          genero = separado[1].charAt(0);
        } else if (separado[0].equals("Antecedentes")) {
          String[] antecedentes = separado[1].split(",");
          for (int i = 0; i < antecedentes.length; i++) {
            String[] partesAntecedente = antecedentes[i].split(";");
            String codigo = "";
            String titulo = "";
            String descripcion = "";
            for (int j = 0; j < partesAntecedente.length; j++) {
              String[] keyValue = partesAntecedente[j].split(":");
              if (keyValue[0].trim().equals("Codigo") || keyValue[0].trim().equals("[Codigo")) {
                codigo = keyValue[1];
              } else if (keyValue[0].equals("Titulo")) {
                titulo = keyValue[1];
              } else if (keyValue[0].equals("Descripcion")) {
                descripcion = keyValue[1].replace("]", "");
              }
            }
            nuevo = new Antecedente(codigo, titulo, descripcion);
            listaNuevosAntecedentes.add(nuevo);
          }
        } else if (cadena.equals("----------")) {
          Cliente nuevoCliente = new Cliente(nombre, cedula, edad, genero);
          nuevoCliente.setAntecedentes(listaNuevosAntecedentes);
          banco.getClientes().add(nuevoCliente);
          listaNuevosAntecedentes = new ArrayList<Antecedente>();
        }
      }
      lectura.close();
      lec.close();
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Hubo un error en la lectura del archivo");
    }
  }

  public VentanaPrincipal getVp() {
    return vp;
  }

  public void setVp(VentanaPrincipal vp) {
    this.vp = vp;
  }

  public Banco getBanco() {
    return banco;
  }

  public void setBanco(Banco banco) {
    this.banco = banco;
  }

  public Antecedente getAntecedente() {
    return antecedente;
  }

  public void setAntecedente(Antecedente antecedente) {
    this.antecedente = antecedente;
  }

  public File getArchivo() {
    return archivo;
  }

  public void setArchivo(File archivo) {
    this.archivo = archivo;
  }
}