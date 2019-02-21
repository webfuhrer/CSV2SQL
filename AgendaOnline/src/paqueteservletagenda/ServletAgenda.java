package paqueteservletagenda;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAgenda
 */
@WebServlet(description = "Servlet que recupera los datos de un contacto y los graba", urlPatterns = { "/ServletAgenda" })
public class ServletAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion=request.getParameter("accion");
		if (accion.equals("listar"))
		{
			//Recuperar los contactos
			ArrayList<Contacto> lista=AccesoBD.listarContactos();
			//Mandarselos a la vista (mostrarContactos.jsp)
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("mostrarContactos.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre=request.getParameter("nombre");//nombre es el name que le he puesto al input
		String telefono=request.getParameter("telefono");//nombre es el name que le he puesto al input
		Contacto c=new Contacto(nombre, telefono);
		AccesoBD.insertarContacto(c);
	}

}
