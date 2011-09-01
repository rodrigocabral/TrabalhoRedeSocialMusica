package presentation;


import domainModel.Recado;
import domainModel.Usuario;


import dataAccess.RecadoRepository;
import dataAccess.UsuarioRepository;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

/**
 * Servlet implementation class usuarioController
 */
//@WebServlet("/Recado")
public class recadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//declarando repositorio
	RecadoRepository repositorio;
       
    //construtor
    public recadoController() {
        super();
        
        //inicializando repositorio
        repositorio = new RecadoRepository();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cod_usuario = 0;
		if(request.getParameter("rec") != null){
			try{
			Recado obj = repositorio.Open(Integer.parseInt(request.getParameter("rec").toString()));
			repositorio.Delete(obj);
			}catch(Exception e){
				e.getStackTrace();
			}
		}
		//caso não passe um cod pelo get, pegar o cod do usuario logado
		if(request.getParameter("cod") != null){
			try{
			cod_usuario = Integer.parseInt(request.getParameter("cod").toString());
			UsuarioRepository repusuario = new UsuarioRepository();
			request.setAttribute("usuario", repusuario.Open(cod_usuario));
			}catch (Exception e) {
				e.getStackTrace();
			}
		}else{
			try{
			HttpSession session = request.getSession();
			cod_usuario = Integer.parseInt(session.getAttribute("cod_usuario").toString());
			UsuarioRepository repusuario = new UsuarioRepository();
			request.setAttribute("usuario", repusuario.Open(cod_usuario));
			}catch(Exception e){
				e.getStackTrace();
			}
		}
		try{

				// pegar os recados do usuario em questão
				List<Recado> recados = repositorio.getTop10ByName(cod_usuario);

				
				request.setAttribute("recados", recados);

				// Chamar a pagina JSP
				RequestDispatcher listagem = request.getRequestDispatcher("recadoUsuario.jsp");
				listagem.forward(request, response);

		}catch(Exception ex){
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
			
			String recado = request.getParameter("recado");
			
			if(recado != null){
				
				
				Recado rec = new Recado();
				//usuario que vai receber o recado
				UsuarioRepository user_repo = new UsuarioRepository();
				int cod_usuario_recado = Integer.parseInt(request.getParameter("cod_usuario_recado").toString());
				
				rec.setIdusuario(user_repo.Open(cod_usuario_recado));
				
				//texto do recado
				rec.setRecado(recado);
				
				//usuario que está enviando o recado
				HttpSession session = request.getSession();
				int cod_usuario = Integer.parseInt(session.getAttribute("cod_usuario").toString());
				
				rec.setIdamigo(user_repo.Open(cod_usuario));
				
				
				repositorio.Save(rec);
				
				UsuarioRepository repusuario = new UsuarioRepository();
				request.setAttribute("usuario", repusuario.Open(cod_usuario_recado));
				
				// pegar os recados do usuario em questão
				List<Recado> recados = repositorio.getTop10ByName(cod_usuario_recado);

				
				request.setAttribute("recados", recados);
				request.getRequestDispatcher("recadoUsuario.jsp").forward(request, response);
				return;
				
			}else{
				
				request.setAttribute("erro", "É necessário escrever um texto");
				request.getRequestDispatcher("recadoUsuario.jsp").forward(request, response);
				return;
				
				
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

