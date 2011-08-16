<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="domainModel.Recado" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Recado</title>
</head>
<body>


<form method="post" action="/openmusic/Recado">

<textarea name="recado" rows="10" cols="50"></textarea>

<input type="hidden" name="cod_usuario_recado" value="<%=request.getAttribute("cod_usuario_recado") %>"/>

<input type="submit" value="enviar" />


</form>


<% 
	List recados = (List) request.getAttribute("recados");
    if(recados!= null) {
	   %>
	   <table>
	   <tr><td>ID</td><td>Nome</td></tr>
	   <%
		   Iterator it = recados.iterator();
		   while(it.hasNext()){
			   Recado u = (Recado)it.next();
		   %>
		   <tr>
		   		<td><%=u.getRecado() %></td>
		   </tr>
		 <% 
	   }
	   %>
	   </table>
	<%
	}else
		out.println("<h1>Sem recados</h1>");	
    %>




</body>
</html>