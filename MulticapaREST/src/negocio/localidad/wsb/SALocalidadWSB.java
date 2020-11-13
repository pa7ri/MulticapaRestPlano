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
	@Path("/{id}")
	@Produces("text/plain")
	public String readGET(@PathParam("id") int id)
	{
		return FactoriaNegocio.getInstancia().generaSALocalidad()
				.read(id).toString();
	}
	
	
	@POST
	@Path("/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response readPOST(TLocalidad tl)
	{ 
		String res = String.valueOf(FactoriaNegocio.getInstancia().generaSALocalidad().create(tl));
		
		return Response.ok(res).build();
	}
	
	
	@DELETE
	@Path("/{id}")
	@Produces("text/plain")
	public String readDELETE(@PathParam("id") int id)
	{		
		return String.valueOf(FactoriaNegocio.getInstancia().generaSALocalidad().delete(id));
	}
	
	
	@PUT
	@Produces("text/plain")
	@Consumes(MediaType.APPLICATION_JSON)
	public String readPUT(TLocalidad tl)
	{
		return String.valueOf(FactoriaNegocio.getInstancia().generaSALocalidad().update(tl));
	}
	
}
