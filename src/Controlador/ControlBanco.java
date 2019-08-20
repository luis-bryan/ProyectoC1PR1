package Controlador;

import Vista.*;
import Modelo.*;

public class ControlBanco 
{
	VentanaPrincipal vp;
	Banco banco;
	Cliente cliente;
	Antecedente antecedente;

	public ControlBanco()
	{
		vp= new VentanaPrincipal();
		banco= new Banco();
	}

	public Cliente buscarCliente(String pCedula)
	{
		Cliente c = null;
		for(int i=0; i<banco.getClientes().size(); i++)
		{
			if(c.getCedula() == pCedula)
			{
				c=banco.getClientes().get(i);
			}
		}
		return c;
	}
	
	public Antecedente buscarAntecedente(int pCodigo)
	{
		Antecedente a = null;
		for(int i=0; i<cliente.getAntecedentes().size(); i++)
		{
			if(a.getCodigo() == pCodigo)
			{
				a=cliente.getAntecedentes().get(i);
			}
		}
		return a;
	}
	
	public void agregarCliente(String pNombre, String pCedula, int pEdad, char pGenero)
	{
		Cliente c = buscarCliente(pCedula);
		if(c==null)
		{
			c = new Cliente(pNombre, pCedula, pEdad, pGenero);
			banco.getClientes().add(c);
		}
	}
	
	public void agregarAntecedente(int pCodigo, String pInformacion)
	{
		Antecedente a = buscarAntecedente(pCodigo);
		if(a==null)
		{
			a = new Antecedente(pCodigo, pInformacion);
			cliente.getAntecedentes().add(a);
		}
	}
	
	public void eliminarCliente(String pCedula)
	{
		Cliente c = buscarCliente(pCedula);
		if(c!=null)
		{
			banco.getClientes().remove(c);
		}
	}
	
	public void eliminarAntecedente(int pCodigo)
	{
		Antecedente a = buscarAntecedente(pCodigo);
		if(a!=null)
		{
			cliente.getAntecedentes().remove(a);
		}
	}
	
	public void modificarCliente(String pCedula)
	{
		Cliente c = buscarCliente(pCedula);
		if(c!=null)
		{
			
		}
	}
}