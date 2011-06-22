package presentation;


import domainModel.Amigo;
import domainModel.Solicitacao;
import domainModel.Usuario;


import dataAccess.AmigoRepository;
import dataAccess.SolicitacaoRepository;
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
//@WebServlet("/Amigo")
public class amigoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//declarando repositorio
	AmigoRepository repositorio;
	SolicitacaoRepository solicitacaorepositorio;
	UsuarioRepository usuariorepositorio;
	
       
    //construtor
    public amigoController() {
        super();
        
        //inicializando repositorio
        repositorio = new AmigoRepository();
        solicitacaorepositorio = new SolicitacaoRepository();
        usuariorepositorio = new UsuarioRepository();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reposta = request.getParameter("resp");
		String cod_usuario = request.getAttribute("cod_usuario");
		
		try{
			if(reposta.equals("s")){
				//salvar na tabela amigos e excluir de  solicitação
				Solicitacao s = solicitacaorepositorio.getBySolicitacao(Integer.parseInt(cod_usuario));
								
				Amigo a = new Amigo();
				a.setIdAmigo1(s.getIdSolicitador());
				a.setIdAmigo2(s.getIdSolicitado());
				repositorio.Save(a);
				solicitacaorepositorio.Delete(s);
			}else{
				//excluir de  solicitação
				Solicitacao s = solicitacaorepositorio.getBySolicitacao(Integer.parseInt(cod_usuario));
				solicitacaorepositorio.Delete(s);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

}

