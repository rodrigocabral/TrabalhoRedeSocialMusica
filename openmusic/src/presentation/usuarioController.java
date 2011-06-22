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
		//pegar o codigo do usuário clicado após realizar a busca
		String cod = request.getParameter("cod");
		
		try{
		Usuario u = repositorio.Open(Integer.parseInt(cod));
		request.setAttribute("usuario", u);
		request.getRequestDispatcher("perfilUsuario.jsp").forward(request, response);
		return;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			//recebendo dados do formulario
			
			
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
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

