package presentation;


import domainModel.Usuario;

import dataAccess.UsuarioRepository;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Servlet implementation class usuarioController
 */
//@WebServlet("/Usuario")
public class usuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//declarando repositorio
	UsuarioRepository repositorio;
       
    //construtor
    public usuarioController() {
        super();
        
        //inicializando repositorio
        repositorio = new UsuarioRepository();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String busca = request.getParameter("busca");
		
		try{
			
			if(busca != null){
				
				// Gera uma listagem de clientes
				List<Usuario> usuarios = repositorio.getTop10ByName(busca);
				
				// Passa a listagem para a p�gina JSP
				request.setAttribute("usuarios", usuarios);
				
				// Chamar a pagina JSP
				RequestDispatcher listagem = request.getRequestDispatcher("usuarioCadastrar.jsp");
				listagem.forward(request, response);
				
			}
		
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
		
		
		try{
			//recebendo dados do formulario
			
			
			String nome = request.getParameter("nome");
			String sobrenome = request.getParameter("sobrenome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String sexo = request.getParameter("sexo");
			String data_nascimento = request.getParameter("datanascimento");
			
			
			Usuario usuario = new Usuario();
			
			usuario.setNome(nome);
			usuario.setSobrenome(sobrenome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setSexo(sexo);
			
			
			
			
			repositorio.Save(usuario);
			
		}
		catch(Exception ex){
		
			ex.printStackTrace();
			
		}
	}

}
