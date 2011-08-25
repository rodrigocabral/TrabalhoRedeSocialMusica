package presentation;

import java.io.IOException;

import dataAccess.AmigoRepository;
import dataAccess.UsuarioRepository;
import domainModel.Amigo;
import domainModel.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domainModel.Usuario;

/**
 * Servlet implementation class perfilController
 */
//@WebServlet("/Perfil")
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
		int cod = 0;
		//caso não passe um cod pelo get, pegar o cod do usuario logado
		if(request.getParameter("cod").toString() != null){
			cod = Integer.parseInt(request.getParameter("cod").toString());
			AmigoRepository repamigo = new AmigoRepository();
			Amigo amigo = new Amigo();
			amigo = repamigo.getByName(5,cod);
			request.setAttribute("amigo", amigo);
		}else{
			//para acessar o proprio perfil
			cod = Integer.parseInt(request.getAttribute("cod_usuario").toString());
		}
		
		try{
				Usuario usuario = repositorio.Open(cod);
				
				request.setAttribute("usuario", usuario);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			RequestDispatcher perfil = request.getRequestDispatcher("perfilUsuarios.jsp");
			perfil.forward(request, response);
			return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
