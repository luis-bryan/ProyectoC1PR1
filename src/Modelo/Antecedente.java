package Modelo;

public class Antecedente {

	private int codigo;
	private String descripcion;
	
	public Antecedente(int pCodigo, String pDescripcion)
	{
		codigo = pCodigo;
		descripcion = pDescripcion;
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
	
	
}
