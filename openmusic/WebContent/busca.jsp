<%@ include file="header.jsp" %> 
<div id="geral_conteudo">
<span id="titulo_pagina">
<div class="sombra11">Resultados da Busca
    <div class="texto1">Resultados da Busca
    </div>
</div></span><br />
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
		   		<td><div id="lista_amigos"><a href="/openmusic/Perfil?cod=<%=u.getId() %>"><%=u.getNome() %></a></div></td>
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