package presentation;


import domainModel.Amigo;


import dataAccess.AmigoRepository;

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
//@WebServlet("/Amigo")
public class amigoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//declarando repositorio
	AmigoRepository repositorio;
       
    //construtor
    public amigoController() {
        super();
        
        //inicializando repositorio
        repositorio = new AmigoRepository();
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
				List<Amigo> amigos = repositorio.getTop10ByName();

				// Passa a listagem para a p�gina JSP
				request.setAttribute("amigos", amigos);

				// Chamar a pagina JSP
				RequestDispatcher listagem = request.getRequestDispatcher("amigosListagem.jsp");
				listagem.forward(request, response);

			}



		}catch(Exception ex){
			ex.printStackTrace();
		}

		


		try{
			//recebendo dados do formulario
			
			
			String idAmigo1 = request.getParameter("idAmigo1");
			String idAmigo2 = request.getParameter("idAmigo2");
			
			
			Amigo amigo = new Amigo();
			
			amigo.setIdAmigo1(Integer.parseInt(idAmigo1));
			amigo.setIdAmigo2(Integer.parseInt(idAmigo2));
			
			
								
			repositorio.Save(amigo);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

