package Controlador;

import Vista.*;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.*;

public class ControlBanco 
{
	VentanaPrincipal vp;
	Banco banco;
	Antecedente antecedente;
	private File archivo = new File("data/datos.txt");

	public ControlBanco()
	{
		vp= new VentanaPrincipal();
		banco= new Banco();
		if(archivo.exists())
		{
			System.out.println("El archivo existe");
		}
		else
		{
			try
			{
				archivo.createNewFile();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public Cliente buscarCliente(String pCedula)
	{
		Cliente c = null;
		try
		{
			if(banco.getClientes().isEmpty())
			{
				for(int i=0; i<banco.getClientes().size(); i++)
				{
					if(c.getCedula().equals(pCedula))
					{
						c=banco.getClientes().get(i);
					}
				}
			}

		}
		catch(Exception e)
		{
			JOptionPane.showInputDialog("El usuario no ha sido encontrado");
		}
		return c;
	}

	public Antecedente buscarAntecedente(int pCodigo, String pCedula)
	{
		Antecedente a = null;
		try
		{
			if(buscarCliente(pCedula).getAntecedentes().isEmpty())
			{
				for(int i=0; i<buscarCliente(pCedula).getAntecedentes().size(); i++)
				{
					if(a.getCodigo() == pCodigo)
					{
						a=buscarCliente(pCedula).getAntecedentes().get(i);
					}
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
				escribirArchivoCliente();
			}
		}
		catch(Exception e)
		{
			JOptionPane.showInputDialog("El cliente ya existe en el sistema");
		}
	}

	public void agregarAntecedente(int pCodigo, String pDescripcion, String pTitulo, String pCedula)
	{
		Antecedente a = buscarAntecedente(pCodigo, pCedula);
		if(a==null)
		{
			a = new Antecedente(pCodigo, pDescripcion, pTitulo);
			
			buscarCliente(pCedula).getAntecedentes().add(a);
			escribirArchivoCliente();
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
	
	public void eliminarAntecedente(int pCodigo, String pCedula)
	{
		Antecedente a = buscarAntecedente(pCodigo, pCedula);
		if(a!=null)
		{
			buscarCliente(pCedula).getAntecedentes().remove(a);
		}
	}
	
	public void modificarCliente(String pCedula, String pNombre, int pEdad, char pGenero)
	{
		Cliente c = buscarCliente(pCedula);
		if(c!=null)
		{
			c.setNombre(pNombre);
			c.setEdad(pEdad);
			c.setGenero(pGenero);
		}
	}
	
	public void escribirArchivoCliente()
	{
		FileWriter escritura;
		PrintWriter pw;
		try
		{
			escritura = new FileWriter(archivo);
			pw = new PrintWriter(escritura);
			pw.println("-----------------------------------------------------------------------------");
			pw.println(banco.toString());
			pw.println("-----------------------------------------------------------------------------");
			pw.close();
			escritura.close();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "No se pudo agregar el cliente al archivo");
		}
	}
	
	public void lecturaArchivo()
	{
		String cadena=null;
		FileReader lectura;
		BufferedReader lec;
		try
		{
			lectura = new FileReader(archivo);
			lec = new BufferedReader(lectura);
			while((cadena=lec.readLine()) != null)
			{
				String [] valores = cadena.split(",");
			}
		}
		catch(IOException e)
		{
			
		}
		
	}
}