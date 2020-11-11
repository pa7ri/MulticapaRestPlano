package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;

public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String evento = null;
		String mensaje = null;
		String url = "/jsp/salida/salida.jsp";
		String urlWS= "http://localhost:8080/MulticapaREST";
		
		evento = request.getParameter("event");

		switch (evento) {
		case "index": {
			url = "/index.html";
			break;
		}
		case "toCreate": {
			url = "/jsp/localidad/create.jsp";
			break;
		}
		case "toRead": {
			url = "/jsp/localidad/read.jsp";
			break;
		}
		case "toUpdate": {
			url = "/jsp/localidad/update.jsp";
			break;
		}
		case "toDelete": {
			url = "/jsp/localidad/delete.jsp";
			break;
		}
		case "create": {
			String nombre = request.getParameter("nombre");
			int longitud = Integer.parseInt((request.getParameter("longitud")));
			int latitud = Integer.parseInt((request.getParameter("latitud")));
			int activo = Integer.parseInt((request.getParameter("activo")));
			
			Client cliente = ClientBuilder.newClient();
			Form ciudadForm= new Form();
			ciudadForm.param("nombre", nombre);
			ciudadForm.param("longitud", String.valueOf(longitud));
			ciudadForm.param("latitud", String.valueOf(latitud));
			ciudadForm.param("activo", String.valueOf(activo));
			
			int res = Integer.parseInt(cliente.target(urlWS).request().post(Entity.form(ciudadForm), String.class));
			
			if (res != 0) {
				mensaje = "Se ha creado la localidad con id " + res;
			} else {
				mensaje = "Error en la creaci�n";
			}

			break;
		}
		case "read": {
			int id = Integer.parseInt((request.getParameter("id")));

			Client cliente = ClientBuilder.newClient();
			String res= cliente.target(urlWS + "/id/" + String.valueOf(id)).request().get(String.class);
			
			if (res != null) {
				mensaje = res;
			} else {
				mensaje = "Error en la lectura";
			}

			break;
		}

		case "update": {
			int id = Integer.parseInt((request.getParameter("id")));
			String nombre = request.getParameter("nombre");
			int longitud = Integer.parseInt((request.getParameter("longitud")));
			int latitud = Integer.parseInt((request.getParameter("latitud")));
			int activo = Integer.parseInt((request.getParameter("activo")));

			Client cliente = ClientBuilder.newClient();
			

			Form ciudadForm= new Form();
			ciudadForm.param("id", String.valueOf(id));
			ciudadForm.param("nombre", nombre);
			ciudadForm.param("longitud", String.valueOf(longitud));
			ciudadForm.param("latitud", String.valueOf(latitud));
			ciudadForm.param("activo", String.valueOf(activo));

			int res = Integer.parseInt(cliente.target(urlWS).request().put(Entity.form(ciudadForm), String.class));

			if (res != 0) {
				mensaje = "Se ha actualizado la localidad con id " + id;
			} else {
				mensaje = "Error en la actualizaci�n";
			}

			break;
		}

		case "delete": {
			int id = Integer.parseInt((request.getParameter("id")));

			Client cliente = ClientBuilder.newClient();
			int res= Integer.parseInt(cliente.target(urlWS + "/" + String.valueOf(id)).request().delete(String.class));
			
			if (res == 1) {
				mensaje = "Se ha eliminado la localidad con id " + id;
			} else {
				mensaje = "Error en la eliminaci�n";
			}

			break;
		}

		default: {
			url = "/index.html";
			break;
		}
		}

		request.getSession().setAttribute("mensaje", mensaje);

		getServletContext().getRequestDispatcher(url).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static void main(String[] args) {
	}

}
