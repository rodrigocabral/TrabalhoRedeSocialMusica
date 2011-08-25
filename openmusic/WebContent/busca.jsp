<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
    <%@ page import="domainModel.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
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
		   		<td><a href="/openmusic/Perfil?cod=<%=u.getId() %>"><%=u.getNome() %></a></td>
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





</body>
</html>