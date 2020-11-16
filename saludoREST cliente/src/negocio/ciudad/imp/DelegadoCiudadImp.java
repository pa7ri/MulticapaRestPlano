package negocio.ciudad.imp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.util.EntityUtils;

import negocio.ciudad.*;

public class DelegadoCiudadImp extends DelegadoCiudad {

	String urlWS= "http://localhost:8080/saludoREST/servicios/localidad/wsb";
	
	@Override
	public String ciudadGET(int id) {
		Client cliente = ClientBuilder.newClient();		
		String 	res = cliente.target(urlWS + "/read/" + String.valueOf(id))
				.request()
				.get(String.class);

		cliente.close();
		return res;
	}

	@Override
	public String ciudadPOST(TLocalidad tl) {
		Client cliente = ClientBuilder.newClient();
		
		Form localidadForm= new Form();
		localidadForm.param("nombre", tl.getNombre());
		localidadForm.param("longitud", String.valueOf(tl.getLongitud()));
		localidadForm.param("latitud", String.valueOf(tl.getLatitud()));
		localidadForm.param("activo", String.valueOf(tl.getActivo()));
		String res = cliente.target(urlWS + "/create")
				.request()
				.put(Entity.form(localidadForm), String.class);
		
		cliente.close();
		return res;
	}

	@Override
	public String ciudadPUT(TLocalidad tl) {
		Client cliente = ClientBuilder.newClient();
		Form localidadForm= new Form();
		localidadForm.param("id", String.valueOf(tl.getId()));
		localidadForm.param("nombre", tl.getNombre());
		localidadForm.param("longitud", String.valueOf(tl.getLongitud()));
		localidadForm.param("latitud", String.valueOf(tl.getLatitud()));
		localidadForm.param("activo", String.valueOf(tl.getActivo()));
		String res = cliente.target(urlWS + "/update")
				.request()
				.put(Entity.form(localidadForm), String.class);

		cliente.close();
		return res;
	}

	@Override
	public String ciudadDELETE(int id) {
		Client cliente = ClientBuilder.newClient();
		String res= cliente.target(urlWS + "/delete/" + String.valueOf(id))
				.request()
				.delete(String.class);

		cliente.close();
		return res;
	}

}
