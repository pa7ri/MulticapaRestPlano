package presentacion.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.FactoriaNegocio;
import negocio.localidad.SALocalidad;
import negocio.localidad.TLocalidad;

/**
 * Servlet implementation class Controlador
 */
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		String evento= null;
    		String mensaje= null;
    		String url= "/jsp/salida/salida.jsp"; 
    		
    		evento= request.getParameter("event");
    		
    		
    
    		
    		switch (evento)
    		{
    			case "index": { url= "/index.html"; break; }
    			case "toCreate": { url= "/jsp/localidad/create.jsp"; break; }
    			case "toRead": { url= "/jsp/localidad/read.jsp"; break; }
    			case "toUpdate": { url= "/jsp/localidad/update.jsp"; break; }
    			case "toDelete": { url= "/jsp/localidad/delete.jsp"; break; }
    			case "create": { 
    							 String nombre= request.getParameter("nombre");
    							 int longitud=  Integer.parseInt((request.getParameter("longitud"))); 
    							 int latitud=   Integer.parseInt((request.getParameter("latitud")));
    							 int activo=    Integer.parseInt((request.getParameter("activo")));
    							 TLocalidad tl= new TLocalidad( nombre, longitud, latitud, activo);
    							 
    				             SALocalidad sa= FactoriaNegocio.getInstancia().generaSALocalidad();
    				             int res= sa.create(tl);
    				             
    				             if (res>0) { mensaje="Se ha creado la localidad con id "+ res; }
    				             else {mensaje= "Error en la creación"; }
    				    				
    				             break; }
    			case "read": { 
			    				 int id= Integer.parseInt((request.getParameter("id")));
							 
					             SALocalidad sa= FactoriaNegocio.getInstancia().generaSALocalidad();
					             TLocalidad tl= sa.read(id);
					             
					             if (tl!=null) { mensaje= tl.toString(); }
					             else {mensaje= "Error en la lectura"; }
					    				
					             break; }
    			    		
    			case "update": {
    							 int id=  Integer.parseInt((request.getParameter("id")));
    							 String nombre= request.getParameter("nombre");
								 int longitud=  Integer.parseInt((request.getParameter("longitud"))); 
								 int latitud=   Integer.parseInt((request.getParameter("latitud")));
								 int activo=    Integer.parseInt((request.getParameter("activo")));
								 TLocalidad tl= new TLocalidad(id, nombre, longitud, latitud, activo);
								 
					             SALocalidad sa= FactoriaNegocio.getInstancia().generaSALocalidad();
					             int res= sa.update(tl);
					             
					             if (res>0) { mensaje="Se ha actualizado la localidad con id " + id; }
					             else {mensaje= "Error en la actualización"; }
					    				
					             break; }
    			
    			case "delete": {
			    				 int id= Integer.parseInt((request.getParameter("id")));
								 
					             SALocalidad sa= FactoriaNegocio.getInstancia().generaSALocalidad();
					             int res= sa.delete(id);
					             
					             if (res == 1) { mensaje= "Se ha eliminado la localidad con id " + id; }
					             else {mensaje= "Error en la eliminación"; }
					    				
					             break; }
    					
    			default: { url= "/index.html"; break; }
    		}
    		
    		
    		request.getSession().setAttribute("mensaje", mensaje);
    
    		getServletContext().getRequestDispatcher(url).forward(request, response);
    		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	

}
