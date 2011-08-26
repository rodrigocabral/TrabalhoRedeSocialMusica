package presentation;


import domainModel.Solicitacao;
import domainModel.Usuario;


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
		
		if(request.getParameter("cod_solicitacao") != null){
			try{
				int cod2 = Integer.parseInt(request.getParameter("cod_solicitacao").toString());
				//pegar codigo do usuario da sessão
				//int cod1 = Integer.parseInt(request.getAttribute("cod_usuario").toString());
				HttpSession session = request.getSession();
				int cod1 = Integer.parseInt(session.getAttribute("cod_usuario").toString());
				Solicitacao solicitacao = repositorio.getByUsuario(cod1,cod2);
				
				if(solicitacao != null){
					request.setAttribute("erro", "já existe uma solicitação para este usuário!");
					RequestDispatcher perfil = request.getRequestDispatcher("perfilUsuarios.jsp");
					perfil.forward(request, response);
					return;
				}else{
					Solicitacao s = new Solicitacao();
					
					Usuario u = usuariorepositorio.Open(cod2);												
					s.setIdSolicitado(u);
					
					u = usuariorepositorio.Open(cod1);
					s.setIdSolicitador(u);
					
					repositorio.Save(s);
					//enviar mensagem para a página perfilUsuario onde se encontra o usuário
					request.setAttribute("confirma", "Solicitação realizada com sucesso, aguarde a confirmação");
					RequestDispatcher perfil = request.getRequestDispatcher("perfilUsuarios.jsp");
					perfil.forward(request, response);
					return;
				}
				//request.setAttribute("usuario", usuario);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			RequestDispatcher perfil = request.getRequestDispatcher("perfilUsuarios.jsp");
			perfil.forward(request, response);
			return;
		}else{
			RequestDispatcher perfil = request.getRequestDispatcher("perfilUsuarios.jsp");
			perfil.forward(request, response);
			return;
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}

