package negocio.saludo.imp;

import negocio.saludo.Saludo;

public class SaludoImp implements Saludo {
	
	public String saludar(String nombre, String apellido)
	{
		return "Hola "+nombre+" "+apellido;
	}

}
