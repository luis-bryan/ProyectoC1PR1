package Modelo;

public class Antecedente {

	private int codigo;
	private String descripcion;
	private String titulo;
	
	public Antecedente(int pCodigo, String pTitulo, String pDescripcion)
	{
		codigo = pCodigo;
		descripcion = pDescripcion;
		titulo = pTitulo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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
		return "codigo"+codigo+"titulo"+titulo+"descripcion"+descripcion;
	}
	
	
}
