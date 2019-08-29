package Modelo;

public class Antecedente {

	private String codigo;
	private String descripcion;
	private String titulo;
	
	public Antecedente(String pCodigo, String pTitulo, String pDescripcion)
	{
		codigo = pCodigo;
		descripcion = pDescripcion;
		titulo = pTitulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Codigo:"+codigo+";Titulo:"+titulo+";Descripcion:"+descripcion;
	}
	
	
}
