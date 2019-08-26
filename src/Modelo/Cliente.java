package Modelo;

import java.util.ArrayList;

public class Cliente {

	private String nombre;
	private String cedula;
	private int edad;
	private char genero;
	ArrayList<Antecedente> antecedentes;
	
	public Cliente(String pNombre, String pCedula, int pEdad, char pGenero)
	{
		antecedentes = new ArrayList<Antecedente>();
		nombre = pNombre;
		cedula = pCedula;
		edad = pEdad;
		genero = pGenero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public ArrayList<Antecedente> getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(ArrayList<Antecedente> antecedentes) {
		this.antecedentes = antecedentes;
	}
	
	public String toString()
	{
		String a = "Nombre" +nombre +"Cedula" + cedula +"Edad" +edad +"Genero" +genero + "Antecedentes:"+ antecedentes.toString();
		return a;
	}
}
