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
import javax.servlet.http.HttpSession;

import java.util.List;

/**
 * Servlet implementation class usuarioController
 */
//@WebServlet("/Solicitacao")
public class solicitacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//declarando repositorio
	SolicitacaoRepository repositorio;
	UsuarioRepository usuariorepositorio;
       
    //construtor
    public solicitacaoController() {
        super();
        
        //inicializando repositorio
        repositorio = new SolicitacaoRepository();
        usuariorepositorio = new UsuarioRepository();
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
		int cod2 = Integer.parseInt(request.getParameter("cod_solicitacao").toString());
		HttpSession session = request.getSession();
		if(request.getParameter("cod_solicitacao") != null){
			try{
				//pegar codigo do usuario da sess�o
				//int cod1 = Integer.parseInt(request.getAttribute("cod_usuario").toString());
				int cod1 = Integer.parseInt(session.getAttribute("cod_usuario").toString());
				Solicitacao solicitacao = repositorio.getByUsuario(cod1,cod2);
				
				if(solicitacao != null){
					request.setAttribute("erro", "j� existe uma solicita��o para este usu�rio!");
					
					AmigoRepository repamigo = new AmigoRepository();
					Amigo amigo = new Amigo();
					amigo = repamigo.getByName(Integer.parseInt(session.getAttribute("cod_usuario").toString()),cod2);
					request.setAttribute("amigo", amigo);
					
					request.setAttribute("usuario", usuariorepositorio.Open(cod2));
					request.getRequestDispatcher("perfilUsuarios.jsp").forward(request, response);
					return;
				}else{
					Solicitacao s = new Solicitacao();
					
					Usuario u = usuariorepositorio.Open(cod2);												
					s.setIdSolicitado(u);
					
					u = usuariorepositorio.Open(cod1);
					s.setIdSolicitador(u);
					
					repositorio.Save(s);
					//enviar mensagem para a p�gina perfilUsuario onde se encontra o usu�rio
					AmigoRepository repamigo = new AmigoRepository();
					Amigo amigo = new Amigo();
					amigo = repamigo.getByName(Integer.parseInt(session.getAttribute("cod_usuario").toString()),cod2);
					request.setAttribute("amigo", amigo);
					
					request.setAttribute("usuario", usuariorepositorio.Open(cod2));
					request.setAttribute("confirma", "Solicita��o realizada com sucesso, aguarde a confirma��o");
					request.getRequestDispatcher("perfilUsuarios.jsp").forward(request, response);
					return;
				}
				//request.setAttribute("usuario", usuario);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			AmigoRepository repamigo = new AmigoRepository();
			Amigo amigo = new Amigo();
			amigo = repamigo.getByName(Integer.parseInt(session.getAttribute("cod_usuario").toString()),cod2);
			request.setAttribute("amigo", amigo);
			try{
			request.setAttribute("usuario", usuariorepositorio.Open(cod2));
			}catch (Exception e) {
				e.getStackTrace();
			}
			request.getRequestDispatcher("perfilUsuarios.jsp").forward(request, response);
			return;
		}else{
			AmigoRepository repamigo = new AmigoRepository();
			Amigo amigo = new Amigo();
			amigo = repamigo.getByName(Integer.parseInt(session.getAttribute("cod_usuario").toString()),cod2);
			request.setAttribute("amigo", amigo);
			try{
			request.setAttribute("usuario", usuariorepositorio.Open(cod2));
			}catch (Exception e) {
				e.getStackTrace();
			}
			request.getRequestDispatcher("perfilUsuarios.jsp").forward(request, response);
			return;
		}
	}

}

