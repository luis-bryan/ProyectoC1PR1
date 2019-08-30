package Modelo;

public class Antecedente {

	private String codigo;
	private String descripcion;
	private String titulo;
	
	/**
	 * Constructor de la clase Antecedente
	 * 
	 * @param pCodigo de identificacion del antecedente
	 *        pCodigo != null y pCodigo != ""
	 * @param pTitulo titulo del antecedente financiero
	 *        pTitulo != null y pTitulo != ""
	 * @param pDescripcion resumen del antecedente
	 *        pDescripcion != null y pDescripcion != ""
	 */
	public Antecedente(String pCodigo, String pTitulo, String pDescripcion)
	{
		codigo = pCodigo;
		descripcion = pDescripcion;
		titulo = pTitulo;
	}

	/**
	 * metodo que me devuelve el codigo del antecedente
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * metodo que modifica el codigo
	 * @param codigo != null y codigo != ""
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * obtiene la descripcion del antecedente
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * modifica la descripcion del antecedente
	 * @param descripcion != null y descripcion != ""
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * toString de la clase para imprimir y modificar en el archivo de texto
	 */
	@Override
	public String toString() {
		return "Codigo:"+codigo+";Titulo:"+titulo+";Descripcion:"+descripcion;
	}
	public String toStringMostrar() {
		return "\nCodigo:"+codigo+"\nTitulo:"+titulo+"\nDescripcion:"+descripcion;
	}
}
