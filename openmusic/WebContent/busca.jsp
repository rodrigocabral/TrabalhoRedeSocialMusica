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
    	
		   Iterator it = usuarios.iterator();
		   while(it.hasNext()){
			   Usuario u = (Usuario)it.next();
	
		   %>
		   <div style="clear: both; margin-bottom: 5px; padding-bottom: 5px; border-bottom: 1px solid black;">
		   <div style="float: left; border: 0px solid red; margin-right: 5px;">
<a href="/openmusic/Perfil?cod=<%=u.getId() %>"><img src="fotos/<%=u.getFoto() %>" width="35" height="35"></a>
</div>
		   		<div id="lista_amigos" style="height: 45px;"><a href="/openmusic/Perfil?cod=<%=u.getId() %>"><%=u.getNome() %></a></div>
		   </div>
		 <%
	   }	
	}else
		out.println("<h1>Sem usuários</h1>");
    %>



<br /><br />





</body>
</html>