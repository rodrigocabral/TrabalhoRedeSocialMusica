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
		
		String reposta = request.getParameter("resp");
		int cod_usuario = Integer.parseInt(request.getAttribute("cod_usuario").toString());
		int cod_amigo = Integer.parseInt(request.getParameter("cod"));

		try{
			if(reposta.equals("s")){
				//salvar na tabela amigos e excluir de  solicitação
				Solicitacao s = solicitacaorepositorio.getByUsuario(cod_usuario,cod_amigo);

				Amigo a = new Amigo();
				a.setIdAmigo1(s.getIdSolicitado());
				a.setIdAmigo2(s.getIdSolicitador());
				repositorio.Save(a);
				solicitacaorepositorio.Delete(s);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				return;
			}else{
				//excluir de  solicitação
				Solicitacao s = solicitacaorepositorio.getByUsuario(cod_usuario,cod_amigo);
				solicitacaorepositorio.Delete(s);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				return;
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