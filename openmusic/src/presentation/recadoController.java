package presentation;


import domainModel.Recado;


import dataAccess.RecadoRepository;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Servlet implementation class usuarioController
 */
@WebServlet("/Recado")
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
				List<Recado> recados = repositorio.getTop10ByName();

				// Passa a listagem para a p�gina JSP
				request.setAttribute("recados", recados);

				// Chamar a pagina JSP
				RequestDispatcher listagem = request.getRequestDispatcher("recadosListar.jsp");
				listagem.forward(request, response);

			}



		}catch(Exception ex){
			ex.printStackTrace();
		}

		


		try{
			//recebendo dados do formulario
			
			
			String idamigos = request.getParameter("idamigos");
			String texto = request.getParameter("recado");
			
			
			Recado recado = new Recado();
			
			recado.setIdAmigo(Integer.parseInt(idamigos));
			recado.setRecado(texto);
			
			
								
			repositorio.Save(recado);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

