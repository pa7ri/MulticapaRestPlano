package negocio.imp;

import negocio.FactoriaNegocio;
import negocio.saludo.Saludo;
import negocio.saludo.imp.SaludoImp;

public class FactoriaNegocioImp extends FactoriaNegocio {

	
	public Saludo nuevoSaludo() {
		
		return new SaludoImp();
	}

}
