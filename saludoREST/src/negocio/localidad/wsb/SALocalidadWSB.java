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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import negocio.FactoriaNegocio;
import negocio.localidad.TLocalidad;

@Path("/localidad/wsb")
public class SALocalidadWSB {
	
	
	@GET
	@Path("/read/{id}")
	@Produces("text/plain")
	public String readGET(@PathParam("id") int id)
	{
		return FactoriaNegocio.getInstancia().generaSALocalidad()
				.read(id).toString();
	}
	
	
	@POST
	@Path("/create")
	@Produces("text/plain")
	public String readPOST(@FormParam("nombre") String nombre, @FormParam("longitud") int longitud, 
			@FormParam("latitud") int latitud, @FormParam("activo") int activo)
	{ 	
		TLocalidad tl = new TLocalidad(nombre, longitud, latitud, activo);
		String res = String.valueOf(FactoriaNegocio.getInstancia().generaSALocalidad().create(tl));
		
		//return Response.ok(res).build();
		return res;
	}
	
	
	@PUT
	@Path("/update")
	@Produces("text/plain")
	public String readPUT(@FormParam("id") int id, @FormParam("nombre") String nombre, @FormParam("longitud") int longitud, 
			@FormParam("latitud") int latitud, @FormParam("activo") int activo)
	{	
		TLocalidad tl = new TLocalidad(id, nombre, longitud, latitud, activo);
		return String.valueOf(FactoriaNegocio.getInstancia().generaSALocalidad().update(tl));
	}
	
	
	@DELETE
	@Path("/delete/{id}")
	@Produces("text/plain")
	public String readDELETE(@PathParam("id") int id)
	{		
		return String.valueOf(FactoriaNegocio.getInstancia().generaSALocalidad().delete(id));
	}
	
}
