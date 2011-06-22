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
		
		//criar sessão
		//request.setAttribute("cod_usuario", arg1)
		
		//pegar os parametros de codigo e solicitação passaados pela url
		String solicitar = request.getParameter("solicitacao");
		String cod2 = request.getParameter("cod");
		
		if(solicitar != null)
		if(cod2 != null){
			try{
				//pegar codigo do usuario da sessão
				String cod1 = (String) request.getAttribute("cod_usuario");
				Solicitacao solicitacao = repositorio.getByUsuario(Integer.parseInt(cod1),Integer.parseInt(cod2));
				
				if(solicitacao != null){
					request.setAttribute("erro", "Você já fez uma solicitação para este usuário, aguarde a confirmação");
					request.getRequestDispatcher("perfilUsuario.jsp").forward(request, response);
					return;
				}else{
					Solicitacao s = new Solicitacao();
					
					Usuario u = usuariorepositorio.Open(Integer.parseInt(cod2));												
					s.setIdSolicitado(u);
					
					u = usuariorepositorio.Open(Integer.parseInt(cod1));
					s.setIdSolicitador(u);
					
					repositorio.Save(s);
					//enviar mensagem para a página perfilUsuario onde se encontra o usuário
					request.setAttribute("confirma", "Solicitação realizada com sucesso, aguarde a confirmação");
					request.getRequestDispatcher("perfilUsuario.jsp").forward(request, response);
					return;
				}
				//request.setAttribute("usuario", usuario);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			RequestDispatcher perfil = request.getRequestDispatcher("perfilUsuario.jsp");
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

