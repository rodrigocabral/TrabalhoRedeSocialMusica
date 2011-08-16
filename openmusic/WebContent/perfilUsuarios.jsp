<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="domainModel.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%
	Usuario usuario = (Usuario)request.getAttribute("usuario");
%>
<title><%=usuario.getNome() %></title>
</head>
<body>
<!-- atributo com mensagem de confirmação de solicitação de amizade, aguardando aceitação do usuario -->
<%=request.getAttribute("confirma") %>

<form action="/openmusic/Solicitacao?solicitacao=new&cod=<%=usuario.getId() %>">

<input type="submit" value="Adicionar aos Amigos"/>

</form>


<a href="/openmusic/Recado?recado=new&cod=<%=usuario.getId() %>">Recados</a>

</body>
</html> 