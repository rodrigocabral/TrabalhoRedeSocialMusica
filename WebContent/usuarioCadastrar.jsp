<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="domainModel.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cadastro do Usuário</title>
</head>
<body>

<form method="post" action="/openmusic/Usuarios" name="form1" >

	<input type="text" name="busca"  />
	 
	<input type="submit" value="buscar" />
	
</form>



<% 
	List usuarios = (List) request.getAttribute("usuarios");
    if(usuarios!= null) {
	   %>
	   <table>
	   <tr><td>ID</td><td>Nome</td></tr>
	   <%
		   Iterator it = usuarios.iterator();
		   while(it.hasNext()){
			   Usuario u = (Usuario)it.next();
		   %>
		   <tr>
		   		<td><%=u.getId() %></td>
		   		<td><%=u.getNome() %></td>
		   </tr>
		 <% 
	   }
	   %>
	   </table>
	<%
	}else
		out.println("<h1>Sem usuários</h1>");	
    %>



<br /><br />





<%
Usuario usuario = (Usuario)request.getAttribute("Usuario");
%>
<form action="/openmusic/Usuarios" method="post" >
		<table>
			<tr><td>Nome: </td><td><input type="text" name="nome" value="<% if(usuario != null) { out.print(usuario.getNome()); } %>" /></td></tr>
			<tr><td>Sobrenome: </td><td><input type="text" name="sobrenome" value="<% if(usuario != null) { out.print(usuario.getSobrenome()); } %>" /></td></tr>
			<tr><td>Email: </td><td><input type="text" name="email" value="<% if(usuario != null) { out.print(usuario.getEmail()); } %>" /></td></tr>
			<tr><td>Senha: </td><td><input type="password" name="senha" value="<% if(usuario != null) { out.print(usuario.getSenha()); } %>" /></td></tr>
			<tr><td>Confirme Senha: </td><td><input type="password" name="confirma_senha" value="<% if(usuario != null) { out.print(usuario.getSenha()); } %>" /></td></tr>
			<tr><td>Sexo: </td><td><input type="text" name="sexo" value="<% if(usuario != null) { out.print(usuario.getSexo()); } %>" /></td></tr>
			<tr><td>Data Nascimento: </td><td><input type="text" name="data_nascimento" value="<% if(usuario != null) { out.print(usuario.getDatanascimento()); } %>" /></td></tr>
			
		</table>
		<input type="submit" value="Salvar" />
	</form>

</body>
</html>