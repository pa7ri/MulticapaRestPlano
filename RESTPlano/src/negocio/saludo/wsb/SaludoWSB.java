package negocio.saludo.wsb;

import negocio.FactoriaNegocio;


public class SaludoWSB {
	
	public String saludar(String nombre, String apellido)
	{
		return FactoriaNegocio.getInstancia().nuevoSaludo().saludar(nombre, apellido);
	}

}
