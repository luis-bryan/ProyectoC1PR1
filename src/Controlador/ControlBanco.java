package Controlador;

import Vista.*;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

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
		try
		{
			for(int i=0; i<banco.getClientes().size(); i++)
			{
				if(c.getCedula().equals(pCedula))
				{
					c=banco.getClientes().get(i);
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showInputDialog("El usuario no ha sido encontrado");
		}
		return c;
	}
	
	public Antecedente buscarAntecedente(int pCodigo)
	{
		Antecedente a = null;
		try
		{
			for(int i=0; i<cliente.getAntecedentes().size(); i++)
			{
				if(a.getCodigo() == pCodigo)
				{
					a=cliente.getAntecedentes().get(i);
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showInputDialog("El antecedente no ha sido encontrado");
		}
		return a;
	}

	public void agregarCliente(String pNombre, String pCedula, int pEdad, char pGenero)
	{
		Cliente c = buscarCliente(pCedula);
		try
		{
			if(c==null)
			{
				c = new Cliente(pNombre, pCedula, pEdad, pGenero);
				banco.getClientes().add(c);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showInputDialog("El cliente ya existe en el sistema");
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
	
	public void modificarCliente(String pCedula, String pNombre, int pEdad, char pGenero)
	{
		Cliente c = buscarCliente(pCedula);
		if(c!=null)
		{
			cliente.setNombre(pNombre);
			cliente.setEdad(pEdad);
			cliente.setGenero(pGenero);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String evento = e.getActionCommand();
		
	}
	
	
}