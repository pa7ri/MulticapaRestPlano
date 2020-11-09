package negocio;

import negocio.saludo.Saludo;
import negocio.imp.FactoriaNegocioImp;

public abstract class FactoriaNegocio {

	protected static FactoriaNegocio instancia;
	
	public static FactoriaNegocio getInstancia()
	{
		if (instancia==null) instancia= new FactoriaNegocioImp();
		return instancia;
	}
	
	public abstract Saludo nuevoSaludo();
}
