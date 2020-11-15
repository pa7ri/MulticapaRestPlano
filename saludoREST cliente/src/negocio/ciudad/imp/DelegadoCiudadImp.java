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
		String 	res = cliente.target(urlWS + "/" + String.valueOf(id))
				.request()
				.get(String.class);

		cliente.close();
		return res;
	}

	@Override
	public String ciudadPOST(TLocalidad tl) {
		Client cliente = ClientBuilder.newClient();
		
		String res = cliente.target(urlWS + "/json")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(tl), String.class);
		
		cliente.close();
		//return res.readEntity(String.class);  //Convertir Response a String
		return res;
	}

	@Override
	public String ciudadPUT(TLocalidad tl) {
		Client cliente = ClientBuilder.newClient();
		String res = cliente.target(urlWS + "/json")
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.json(tl), String.class);

		cliente.close();
		return res;
	}

	@Override
	public String ciudadDELETE(int id) {
		Client cliente = ClientBuilder.newClient();
		String res= cliente.target(urlWS + "/" + String.valueOf(id))
				.request()
				.delete(String.class);

		cliente.close();
		return res;
	}

}
