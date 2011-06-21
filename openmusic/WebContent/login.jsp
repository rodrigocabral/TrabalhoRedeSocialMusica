<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="domainModel.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Faça Seu Login.</title>
</head>
<body>
<% String erro = (String)request.getAttribute("erro"); 
 if(erro != null){
	 %><p>Atencao! Aconteceu um erro: <%=erro %></p><% 
 }
%>
<form method="post" action="/openmusic/Login">
<label>Login: </label>
<input type="text" value="" name="login" /><br/>
<p></p>
<label>Senha: </label>
<input type="password" value="" name="senha" /><p></p>
<input type="submit" value="Entrar" />
</form>

</body>
</html>