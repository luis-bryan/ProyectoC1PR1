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

	@Override
	public String toString()
	{
		String toReturn = "Numero de personas:"+clientes.size()+'\n';
		
		for (int i = 0; i < clientes.size(); i++) {
			toReturn+= "Persona No. " + i + "\n";
			toReturn+= clientes.get(i).toString();
			toReturn+= "\n----------\n";
		}
		return toReturn;
	}
}
