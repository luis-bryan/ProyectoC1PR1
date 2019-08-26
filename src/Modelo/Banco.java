package Modelo;

import java.util.ArrayList;

public class Banco {

	ArrayList<Cliente> clientes;
	
	public Banco()
	{
		clientes = new ArrayList<Cliente>();
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
}
