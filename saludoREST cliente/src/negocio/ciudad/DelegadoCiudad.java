package negocio.ciudad;

import negocio.ciudad.imp.DelegadoCiudadImp;
import negocio.ciudad.TLocalidad;

public abstract class DelegadoCiudad {
	protected static DelegadoCiudad instancia;
	
	public static DelegadoCiudad getInstancia()
	{
		if (instancia == null) instancia= new DelegadoCiudadImp();
		return instancia;
	}
	
	public abstract String ciudadGET(int id);
	public abstract String ciudadPOST(TLocalidad tl);
	public abstract String ciudadPUT(TLocalidad tl);
	public abstract String ciudadDELETE(int id);
}
