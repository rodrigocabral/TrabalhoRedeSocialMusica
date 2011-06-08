<?xml version="1.0" encoding="ISO-8859-1" ?>
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
			<tr><td>Cidade: </td><td><input type="text" name="cidade" value="<% if(usuario != null) { out.print(usuario.getCidade()); } %>" /></td></tr>
			<tr><td>Estado: </td>
			<td>
			<select name="estado" id="estado">
          	<option><% if(usuario != null) { out.print(usuario.getEstado()); } %></option>
            <option>MG</option>
            <option>AL</option>
            <option>AM</option>
            <option>AP</option>
            <option>BA</option>
            <option>CE</option>
            <option>DF</option>
            <option>ES</option>
            <option>GO</option>
            <option>MA</option>
            <option>AC</option>
            <option>MS</option>
            <option>MT</option>
            <option>PA</option>
            <option>PB</option>
            <option>PE</option>
            <option>PI</option>
            <option>PR</option>
            <option>RJ</option>
            <option>RN</option>
            <option>RO</option>
            <option>RR</option>
            <option>RS</option>
            <option>SC</option>
            <option>SE</option>
            <option>SP</option>
            <option>TO</option>
          </select>
			</td></tr>
			<tr><td>Pais: </td><td><input type="text" name="pais" value="<% if(usuario != null) { out.print(usuario.getPais()); } %>" /></td></tr>
		</table>
		<input type="submit" value="Salvar" />
	</form>

</body>
</html>