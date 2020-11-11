package negocio.ciudad.imp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;

import negocio.ciudad.DelegadoCiudad;

public class DelegadoCiudadImp extends DelegadoCiudad {

	String urlWS= "http://localhost:8080/MulticapaREST";
	
	@Override
	public String ciudadGET(int id) {
		Client cliente = ClientBuilder.newClient();		
		String 	res= cliente.target(urlWS + "/id/" + String.valueOf(id)).request().get(String.class);
		
		cliente.close();
		return res;
	}

	@Override
	public String ciudadPOST(String nombre, int longitud, int latitud, int activo) {
		Client cliente = ClientBuilder.newClient();
		Form ciudadForm= new Form();
		ciudadForm.param("nombre", nombre);
		ciudadForm.param("longitud", String.valueOf(longitud));
		ciudadForm.param("latitud", String.valueOf(latitud));
		ciudadForm.param("activo", String.valueOf(activo));
		String res = cliente.target(urlWS).request().post(Entity.form(ciudadForm), String.class);

		cliente.close();
		return res;
	}

	@Override
	public String ciudadPUT(int id, String nombre, int longitud, int latitud, int activo) {
		Client cliente = ClientBuilder.newClient();
		Form ciudadForm= new Form();
		ciudadForm.param("id", String.valueOf(id));
		ciudadForm.param("nombre", nombre);
		ciudadForm.param("longitud", String.valueOf(longitud));
		ciudadForm.param("latitud", String.valueOf(latitud));
		ciudadForm.param("activo", String.valueOf(activo));
		String res = cliente.target(urlWS).request().put(Entity.form(ciudadForm), String.class);

		cliente.close();
		return res;
	}

	@Override
	public String ciudadDELETE(int id) {
		Client cliente = ClientBuilder.newClient();
		String res= cliente.target(urlWS + "/" + String.valueOf(id)).request().delete(String.class);

		cliente.close();
		return res;
	}

}
