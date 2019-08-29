package Modelo;

import java.util.ArrayList;

public class Cliente {

	private String nombre;
	private String cedula;
	private int edad;
	private char genero;
	ArrayList<Antecedente> antecedentes;
	
	/**
	 * Constructor de la clase cliente
	 * 
	 * <b>Pre:</b>
	 * <ul>
	 * <li>El arrayList de antecedentes es inicializado</li>
	 * </ul>
	 * <b>Post:</b>
	 * <ul>
	 * <li>Se crea el arraylist de antecedentes</li>
	 * </ul>
	 * 
	 * @param pNombre
	 * @param pCedula
	 * @param pEdad
	 * @param pGenero
	 */
	public Cliente(String pNombre, String pCedula, int pEdad, char pGenero)
	{
		antecedentes = new ArrayList<Antecedente>();
		nombre = pNombre;
		cedula = pCedula;
		edad = pEdad;
		genero = pGenero;
	}

	/**
	 * obtiene el nombre de un cliente
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * modifica el nombre del cliente
	 * @param nombre != null y nombre != ""
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * obtiene la cedula del cliente
	 * @return cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * modifica la cedula
	 * @param cedula != null y cedula != ""
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * obtiene la edad del cliente
	 * @return edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * modifica la edad del cliente
	 * @param edad != 0
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * obtiene el genero seleccionado por el cliente
	 * @return genero
	 */
	public char getGenero() {
		return genero;
	}

	/**
	 * modifica el genero de un cliente
	 * @param genero
	 */
	public void setGenero(char genero) {
		this.genero = genero;
	}

	/**
	 * obtiene la lista de antecedentes
	 * @return antecedentes != null
	 */
	public ArrayList<Antecedente> getAntecedentes() {
		return antecedentes;
	}

	/** 
	 * modifica algun antecedente de un cliente
	 * @param antecedentes != null
	 */
	public void setAntecedentes(ArrayList<Antecedente> antecedentes) {
		this.antecedentes = antecedentes;
	}
	
	/**
	 * se imprime en el archivo
	 * @return a
	 */
	public String toString()
	{
		String a = "Nombre=" +nombre+ "\nCedula=" + cedula +"\nEdad=" +edad +"\nGenero=" +genero + "\nAntecedentes="+ antecedentes.toString();
		return a;
	}
}
