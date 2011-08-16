package presentation;


import domainModel.Usuario;

import dataAccess.UsuarioRepository;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Servlet implementation class usuarioController
 */
//@WebServlet("/Usuarios")
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
		//request.getRequestDispatcher("perfilUsuarios.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			//recebendo dados do formulario
			
			String busca = request.getParameter("busca");
			
			if(busca != null){
				
				List<Usuario> usuarios = repositorio.getTop10ByName(busca);
				
				request.setAttribute("usuarios", usuarios);
				
				RequestDispatcher listagem = request.getRequestDispatcher("busca.jsp");
				listagem.forward(request, response);
				
			}
			
			
			
			String nome = request.getParameter("nome");
			String sobrenome = request.getParameter("sobrenome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String sexo = request.getParameter("sexo");
			String data_nascimento = request.getParameter("datanascimento");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String pais = request.getParameter("pais");
			
			
			Usuario usuario = new Usuario();
			
			usuario.setNome(nome);
			usuario.setSobrenome(sobrenome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setSexo(sexo);
			usuario.setDatanascimento(data_nascimento);
			usuario.setCidade(cidade);
			usuario.setEstado(estado);
			usuario.setPais(pais);
			
								
			repositorio.Save(usuario);
			
			RequestDispatcher listagem = request.getRequestDispatcher("login.jsp");
			listagem.forward(request, response);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

