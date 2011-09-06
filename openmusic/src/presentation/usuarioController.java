package presentation;

import domainModel.Usuario;


import dataAccess.UsuarioRepository;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import org.apache.commons.io.*;


/**
 * Servlet implementation class usuarioController
 */
// @WebServlet("/Usuarios")
public class usuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// declarando repositorio
	UsuarioRepository repositorio;

	// construtor
	public usuarioController() {
		super();

		// inicializando repositorio
		repositorio = new UsuarioRepository();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// request.getRequestDispatcher("perfilUsuarios.jsp").forward(request,
		// response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			// recebendo dados do formulario

			String busca = request.getParameter("busca");

			if (busca != null) {

				List<Usuario> usuarios = repositorio.getTop10ByName(busca);

				request.setAttribute("usuarios", usuarios);

				RequestDispatcher listagem = request
						.getRequestDispatcher("busca.jsp");
				listagem.forward(request, response);

			}
			
			
			String nome = request.getParameter("nome");
			String sobrenome = request.getParameter("sobrenome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String sexo = request.getParameter("sexo");
			String data_nascimento = request.getParameter("data_nascimento");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String pais = request.getParameter("pais");
			String foto = request.getParameter("foto");
			
			Usuario usuario = new Usuario();

			usuario.setNome(nome);
			usuario.setSobrenome(sobrenome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setSexo(sexo);
			usuario.setDatanascimento(data_nascimento);
			usuario.setCidade(cidade);
			usuario.setEstado(estado);
			
			//usuario.setFoto(foto);
			
			
			
			boolean isMultiPart = ServletFileUpload.isMultipartContent(request);

			
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
								this.inserirImagem(item);
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

			// implementação de demais métodos do Servlet.

			repositorio.Save(usuario);

			RequestDispatcher listagem = request
					.getRequestDispatcher("login.jsp");
			listagem.forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private  void inserirImagem(FileItem item) {
	     
		Connection conexao = null;
		 
		/**
		 
		  Estabeleça a conexão
		 
		*/
		 
		      PreparedStatement declaracao = null;
		 
		            String sql = "INSERT INTO TabelaTeste (codigo, imagem) VALUES(?, ?)";
		 
		try {
		                  declaracao = (PreparedStatement) conexao.prepareStatement(sql);
		                  declaracao.setInt(1, 1); // codigo 1
		                 declaracao.setBinaryStream(2, item.getInputStream(),
		                                           (int) item.getSize() );
		                  declaracao.executeUpdate();
		 
		             } catch (SQLException ex) {
		                        ex.printStackTrace();
		            } catch (Exception ex) {
		                  ex.printStackTrace();
		            }
		}

}
