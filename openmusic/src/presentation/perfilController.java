package presentation;

import java.io.IOException;

import dataAccess.UsuarioRepository;
import domainModel.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domainModel.Usuario;

/**
 * Servlet implementation class perfilController
 */
@WebServlet("/Perfil")
public class perfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioRepository repositorio;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public perfilController() {
        super();
        // TODO Auto-generated constructor stub
        repositorio = new UsuarioRepository();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cod = request.getParameter("cod");
		
		if(cod != null){
			try{
				Usuario usuario = repositorio.Open(Integer.parseInt(cod));
				
				request.setAttribute("usuario", usuario);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			RequestDispatcher perfil = request.getRequestDispatcher("perfilUsuario.jsp");
			perfil.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
