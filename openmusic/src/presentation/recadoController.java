package presentation;


import domainModel.Recado;


import dataAccess.RecadoRepository;
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
		//caso não passe um cod pelo get, pegar o cod do usuario logado
		if(request.getParameter("cod").toString() != null){
			cod_usuario = Integer.parseInt(request.getParameter("cod").toString());
		}else{
			cod_usuario = Integer.parseInt(request.getAttribute("cod_usuario").toString());
		}
		try{

				// Gera uma listagem de clientes
				List<Recado> recados = repositorio.getTop10ByName(cod_usuario);

				
				request.setAttribute("recados", recados);
				request.setAttribute("cod_usuario_recado", cod_usuario);

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
				
				UsuarioRepository user_repo = new UsuarioRepository();
				String cod_usuario_recado = request.getParameter("cod_usuario_recado");
				
				rec.setIdusuario(user_repo.Open(Integer.parseInt(cod_usuario_recado)));
				
				rec.setRecado(recado);
				
				String cod_usuario = (String)request.getAttribute("cod_usuario");
				
				rec.setIdamigo(user_repo.Open(Integer.parseInt(cod_usuario)));
				
				
				repositorio.Save(rec);
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

