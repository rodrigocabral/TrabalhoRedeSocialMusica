package presentation;


import domainModel.Solicitacao;


import dataAccess.SolicitacaoRepository;

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
//@WebServlet("/Solicitacao")
public class solicitacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//declarando repositorio
	SolicitacaoRepository repositorio;
       
    //construtor
    public solicitacaoController() {
        super();
        
        //inicializando repositorio
        repositorio = new SolicitacaoRepository();
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
				List<Solicitacao> solicitacao = repositorio.getTop10ByName();

				// Passa a listagem para a p�gina JSP
				request.setAttribute("usuarios", solicitacao);

				// Chamar a pagina JSP
				RequestDispatcher listagem = request.getRequestDispatcher("usuarioCadastrar.jsp");
				listagem.forward(request, response);

			}



		}catch(Exception ex){
			ex.printStackTrace();
		}

		


		try{
			//recebendo dados do formulario
			
			
			String solicitador = request.getParameter("solicitador");
			String solicitado = request.getParameter("solicitado");
			
			
			Solicitacao solicitacao = new Solicitacao();
			
			solicitacao.setIdSolicitador(Integer.parseInt(solicitador));
			solicitacao.setIdSolicitado(Integer.parseInt(solicitado));
			
								
			repositorio.Save(solicitacao);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

