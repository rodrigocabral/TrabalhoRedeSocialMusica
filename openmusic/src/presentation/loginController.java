package presentation;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataAccess.UsuarioRepository;
import domainModel.Usuario;

/**
 * Servlet implementation class loginController
 */
//@WebServlet("/Login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UsuarioRepository repo = new UsuarioRepository();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Recebe os paratros do formulao
		
		try{
		
			String usuario = request.getParameter("login");
			String senha = request.getParameter("senha");
			try  {  
			    MessageDigest md = MessageDigest.getInstance( "MD5" );  
			    md.update( senha.getBytes() );  
			    BigInteger hash = new BigInteger( 1, md.digest() );  
			    senha = hash.toString( 16 ); 
			 }  

			 catch(NoSuchAlgorithmException ns)  {  
			    ns.printStackTrace();  
			 }
			

			Usuario user = repo.OpenByLogin(usuario);

			if(user == null){
				request.setAttribute("erro", "Login inexistente!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			else {
				if(user.getSenha().equals(senha)){
					int id = user.getId();
					//request.setAttribute("login_usuario", usuario);
					//request.setAttribute("cod_usuario", id);
					HttpSession session = request.getSession();
					session.setAttribute("cod_usuario", Integer.toString(id));
					//System.out.print(id);
					//request.setAttribute("nome", user.getNome());
					request.getRequestDispatcher("home.jsp").forward(request, response);
					return;
				}
				else {
					request.setAttribute("erro", "A senha não confere!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
				}
			}
				
		}
		catch (Exception ex){
			
			ex.printStackTrace();
			
		}
	}

}
