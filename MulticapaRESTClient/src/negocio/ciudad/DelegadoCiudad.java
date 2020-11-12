package negocio.ciudad;

import negocio.ciudad.imp.DelegadoCiudadImp;

public abstract class DelegadoCiudad {
	protected static DelegadoCiudad instancia;
	
	public static DelegadoCiudad getInstancia()
	{
		if (instancia == null) instancia= new DelegadoCiudadImp();
		return instancia;
	}
	
	public abstract String ciudadGET(int id);
	public abstract String ciudadPOST(String nombre, int longitud, int latitud, int activo);
	public abstract String ciudadPUT(int id, String nombre, int longitud, int latitud, int activo);
	public abstract String ciudadDELETE(int id);
}
