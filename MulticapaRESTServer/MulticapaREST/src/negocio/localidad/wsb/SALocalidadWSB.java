package negocio.localidad.wsb;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import negocio.FactoriaNegocio;
import negocio.localidad.TLocalidad;


public class SALocalidadWSB {
	
	/*TODO Revisar si debemos usar QueryParam o PathParam o FormParam*/
	
	@GET
	@Path("/id/{id}")
	/**
	 * Devuelve la localidad con id el parámetro
	 * @param id
	 * @return null si error
	 */
	public TLocalidad readGET(@PathParam("id") int id)
	{
		return FactoriaNegocio.getInstancia().generaSALocalidad().read(id);
	}
	
	@DELETE
	/**
	 * Devuelve el resultado de intentar eliminar la localidad con el id del parámetro
	 * @param id
	 * @return -1 si error
	 * 			1 en otro caso
	 */
	public int readDELETE(@QueryParam("id") int id)
	{		
		return FactoriaNegocio.getInstancia().generaSALocalidad().delete(id);
	}
	
	@POST
	@Path("/nombre/{nombre}/longitud/{longitud}/latitud/{latitud}/activo/{activo}")
	/**
	 * Añade la localidad con los atributos pasados por parámetro
	 * @param nombre
	 * @param longitud
	 * @param latitud
	 * @param activo
	 * @return 	0 si no se ha podido crear
	 * 			el id correspondiente a la localidad en otro caso
	 */
	public int readPOST(@PathParam("nombre") String nombre, @PathParam("longitud") int longitud, @PathParam("latitud") int latitud, @PathParam("activo") int activo)
	{ 
		TLocalidad tl = new TLocalidad(nombre, longitud, latitud, activo);
		return FactoriaNegocio.getInstancia().generaSALocalidad().create(tl);
	}
	
	
	@PUT
	@Path("/id/{id}/nombre/{nombre}/longitud/{longitud}/latitud/{latitud}/activo/{activo}")
	/**
	 * Intenta actualizar el elemento con id el parámetro id de la bbdd con los datos aportados por parámetro
	 * @param id
	 * @param nombre
	 * @param longitud
	 * @param latitud
	 * @param activo
	 * @return -1 si error,
	 * 			1 en otro caso
	 */
	public int readPUT(@PathParam("id") int id, @PathParam("nombre") String nombre, @PathParam("longitud") int longitud, @PathParam("latitud") int latitud, @PathParam("activo") int activo)
	{
		TLocalidad tl = new TLocalidad(id, nombre, longitud, latitud, activo);
		return FactoriaNegocio.getInstancia().generaSALocalidad().update(tl);
	}
	
}
