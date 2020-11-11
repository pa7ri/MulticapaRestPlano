package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.ciudad.DelegadoCiudad;

public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String evento = null;
		String mensaje = null;
		String url = "/jsp/salida/salida.jsp";
		
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
		
			int res = Integer.parseInt(DelegadoCiudad.getInstancia().ciudadPOST(nombre, longitud, latitud, activo));
			
			if (res != 0) {
				mensaje = "Se ha creado la localidad con id " + res;
			} else {
				mensaje = "Error en la creacion";
			}

			break;
		}
		case "read": {
			int id = Integer.parseInt((request.getParameter("id")));
			String res= DelegadoCiudad.getInstancia().ciudadGET(id);	
			
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

			int res = Integer.parseInt(DelegadoCiudad.getInstancia().ciudadPUT(id, nombre, longitud, latitud, activo));
			
			if (res != 0) {
				mensaje = "Se ha actualizado la localidad con id " + id;
			} else {
				mensaje = "Error en la actualizacion";
			}

			break;
		}

		case "delete": {
			int id = Integer.parseInt((request.getParameter("id")));
			
			int res =Integer.parseInt(DelegadoCiudad.getInstancia().ciudadDELETE(id));
			
			if (res == 1) {
				mensaje = "Se ha eliminado la localidad con id " + id;
			} else {
				mensaje = "Error en la eliminacion";
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
		System.out.println("hola");
	}

}
