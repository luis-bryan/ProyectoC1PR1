package Controlador;

import Vista.*;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.*;

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
		vp = new VentanaPrincipal();
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
		System.out.println(banco);

	}

	/**
	 * Busca un cliente <b>Pre:</b>
	 * <ul>
	 * <li>El arrayList de clientes se encuentra inicializado</li>
	 * </ul>
	 * <b>Post:</b>
	 * <ul>
	 * <li>Se encontro un objeto de la clase cliente</li>
	 * </ul>
	 * 
	 * @param pCedula Se usa para buscar el cliente, dado que dos personas no pueden
	 *                tener la misma cedula pCedula != "" y pCedula != null
	 * @return un objeto de la clase cliente si se encontro, null si el cliente no
	 *         existe
	 */
	public Cliente buscarCliente(String pCedula) {
		Cliente c = null;
		try {
			if (banco.getClientes().isEmpty()) {
				for (int i = 0; i < banco.getClientes().size(); i++) {
					if (c.getCedula().equals(pCedula)) {
						c = banco.getClientes().get(i);
					}
				}
			}

		} catch (Exception e) {
			JOptionPane.showInputDialog("El usuario no ha sido encontrado");
		}
		return c;
	}

	public Antecedente buscarAntecedente(String pCodigo, String pCedula) {
		Antecedente a = null;
		try {
			if (buscarCliente(pCedula).getAntecedentes().isEmpty()) {
				for (int i = 0; i < buscarCliente(pCedula).getAntecedentes().size(); i++) {
					if (a.getCodigo() == pCodigo) {
						a = buscarCliente(pCedula).getAntecedentes().get(i);
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showInputDialog("El antecedente no ha sido encontrado");
		}
		return a;
	}

	public void agregarCliente(String pNombre, String pCedula, int pEdad, char pGenero) {
		Cliente c = buscarCliente(pCedula);
		try {
			if (c == null) {
				c = new Cliente(pNombre, pCedula, pEdad, pGenero);
				banco.getClientes().add(c);
				escribirArchivoCliente();
			}
		} catch (Exception e) {
			JOptionPane.showInputDialog("El cliente ya existe en el sistema");
		}
	}

	public void agregarAntecedente(String pCodigo, String pDescripcion, String pTitulo, String pCedula) {
		Antecedente a = buscarAntecedente(pCodigo, pCedula);
		if (a == null) {
			a = new Antecedente(pCodigo, pDescripcion, pTitulo);
			buscarCliente(pCedula).getAntecedentes().add(a);
			escribirArchivoCliente();
		}
	}

	public void eliminarCliente(String pCedula) {
		Cliente c = buscarCliente(pCedula);
		if (c != null) {
			banco.getClientes().remove(c);
		}
	}

	public void eliminarAntecedente(String pCodigo, String pCedula) {
		Antecedente a = buscarAntecedente(pCodigo, pCedula);
		if (a != null) {
			buscarCliente(pCedula).getAntecedentes().remove(a);
		}
	}

	public void modificarCliente(String pCedula, String pNombre, int pEdad, char pGenero) {
		Cliente c = buscarCliente(pCedula);
		if (c != null) {
			c.setNombre(pNombre);
			c.setEdad(pEdad);
			c.setGenero(pGenero);
		}
	}

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
			String codigo = "";
			String titulo = "";
			String descripcion = "";
			ArrayList<Antecedente> listaNuevosAntecedentes = new ArrayList<Antecedente>();
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
						String[] antecedente = antecedentes[i].split(";");
						for (int j = 0; j < antecedente.length; j++) {
							String[] keyValue = antecedente[j].split(":");
							if (keyValue[0].equals("Codigo") || keyValue[0].equals("[Codigo")) {
								codigo = keyValue[1];
							} else if (keyValue[0].equals("Titulo")) {
								titulo = keyValue[1];
							} else if (keyValue[0].equals("Descripcion")) {
								descripcion = keyValue[1].replace("]", "");
							}
						}
						Antecedente nuevo = new Antecedente(codigo, titulo, descripcion);
						listaNuevosAntecedentes.add(nuevo);
					}
				} else if (cadena.equals("----------")) {
					Cliente nuevoCliente = new Cliente(nombre, cedula, edad, genero);
					nuevoCliente.setAntecedentes(listaNuevosAntecedentes);
					banco.getClientes().add(nuevoCliente);
					listaNuevosAntecedentes = new ArrayList<Antecedente>();
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Hubo un error en la lectura del archivo");
		}
	}
}