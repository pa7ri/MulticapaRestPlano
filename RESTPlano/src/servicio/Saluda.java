package servicio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.FactoriaNegocio;
import negocio.saludo.wsb.SaludoWSB;

public class Saluda extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException  {

			     String nombre = req.getParameter("nombre");
			     String apellido= req.getParameter("apellido");
			     
			     SaludoWSB saludoWSB= new SaludoWSB();
			     String respuesta= saludoWSB.saludar(nombre, apellido);
			     
			     res.getWriter().write(respuesta);
			}
}
