package presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.UsuarioRepository;
import domainModel.Usuario;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/Login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UsuarioRepository repo = new UsuarioRepository();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
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
			

			Usuario user = repo.OpenByLogin(usuario);

			if(user == null){
				
				
				request.setAttribute("erro", "Senha/Login não conferem.");
				request.getRequestDispatcher("login.jsp");
				
				
			}
			else {
				if(user.getSenha().equalsIgnoreCase(senha)){
					//request.setAttribute("msg", "Logado");
					request.setAttribute("login_usuario", usuario);
					request.setAttribute("senha_usuario", senha);
					request.setAttribute("usuario", user);
					request.getRequestDispatcher("perfilUsuarios.jsp").forward(request, response);
					return;
				}
				else {
					request.setAttribute("erro", "A senha não confere");
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
