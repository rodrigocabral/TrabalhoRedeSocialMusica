package presentation;


import domainModel.Usuario;

import dataAccess.UsuarioRepository;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

//importações para criptografia
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import org.apache.commons.io.*;

/**
 * Servlet implementation class usuarioController
 */
//@WebServlet("/Usuarios")
public class usuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//declarando repositorio
	UsuarioRepository repositorio;
       
    //construtor
    public usuarioController() {
        super();
        
        //inicializando repositorio
        repositorio = new UsuarioRepository();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("function").equals("Edit")){
			try{
			HttpSession session = request.getSession();
			Usuario usuario = repositorio.Open(Integer.parseInt(session.getAttribute("cod_usuario").toString()));
			request.setAttribute("usuario", usuario);
			
			RequestDispatcher listagem = request.getRequestDispatcher("usuarioEditar.jsp");
			listagem.forward(request, response);
			return;
			}catch (Exception e) {
				e.getStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			//recebendo dados do formulario
			
			
			if(request.getParameter("busca")!= null){
				
				List<Usuario> usuarios = repositorio.getTop10ByName(request.getParameter("busca").toString());
				
				request.setAttribute("usuarios", usuarios);
				
				RequestDispatcher listagem = request.getRequestDispatcher("busca.jsp");
				listagem.forward(request, response);
				return;
			}
			if(request.getParameter("foto") != null){
				boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
				Usuario usuario = repositorio.OpenByLogin(request.getAttribute("email_foto").toString());
				
				if (isMultiPart){
					
					FileItemFactory factory = new DiskFileItemFactory();
					ServletFileUpload upload = new ServletFileUpload(factory);
					String formulario = "";
					try {
						List<FileItem> items =  upload.parseRequest(request);
						Iterator<FileItem> iter = items.iterator();
						while (iter.hasNext()) {
							FileItem item = iter.next();
							if (item.getFieldName().equals("tipoForm")) {
								formulario = item.getString();
							}
							if (!item.isFormField()) {
								if (item.getName().length() > 0) {
									usuario.setFoto(item.getName());
									repositorio.Save(usuario);
									RequestDispatcher listagem = request.getRequestDispatcher("login.jsp");
									listagem.forward(request, response);
									return;
								}
							}
						}
					} catch (FileUploadException ex) {
						//ex.printStackTrace();
						String tmp = ex.getMessage();
					} catch (Exception ex) {
						//ex.printStackTrace();
						String tmp = ex.getMessage();
					}
				}


			}
			
			
			Usuario usuario = new Usuario();
			
			String nome = request.getParameter("nome");
			String sobrenome = request.getParameter("sobrenome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			//caso o usuario esteja enviando pelo usuarioEditar
			//entrará nessa condição
			//pois só no usuárioEditar existe o campo hidden senha_oculta
			if(request.getParameter("senha_oculta") != null){
				HttpSession session = request.getSession();
				usuario = repositorio.Open(Integer.parseInt(session.getAttribute("cod_usuario").toString()));
				if(!senha.equals(request.getParameter("senha_oculta"))){
					//criptografando senha
					try  {  
					    MessageDigest md = MessageDigest.getInstance( "MD5" );  
					    md.update( senha.getBytes() );  
					    BigInteger hash = new BigInteger( 1, md.digest() );  
					    senha = hash.toString( 16 ); 
					 }  

					 catch(NoSuchAlgorithmException ns)  {  
					    ns.printStackTrace();  
					 }
				}
			}else{
			//criptografando senha
				try  {  
					MessageDigest md = MessageDigest.getInstance( "MD5" );  
					md.update( senha.getBytes() );  
					BigInteger hash = new BigInteger( 1, md.digest() );  
					senha = hash.toString( 16 ); 
				}  

				catch(NoSuchAlgorithmException ns)  {  
					ns.printStackTrace();  
				}
			 
			}
			String sexo = request.getParameter("sexo");
			String data_nascimento = request.getParameter("data_nascimento");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String pais = request.getParameter("pais");
			
			
			usuario.setNome(nome);
			usuario.setSobrenome(sobrenome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setSexo(sexo);
			usuario.setDatanascimento(data_nascimento);
			usuario.setCidade(cidade);
			usuario.setEstado(estado);
			usuario.setPais(pais);
			
								
			repositorio.Save(usuario);
			request.setAttribute("email_foto", email);
			if(request.getParameter("senha_oculta") != null){
				RequestDispatcher listagem = request.getRequestDispatcher("home.jsp");
				listagem.forward(request, response);
				return;
			}else{
				RequestDispatcher listagem = request.getRequestDispatcher("usuarioFoto.jsp");
				listagem.forward(request, response);
				return;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

