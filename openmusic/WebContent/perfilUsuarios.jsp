<%@ include file="header.jsp" %>
<%
	Usuario usuario = (Usuario)request.getAttribute("usuario");
%> 
<div id="geral_conteudo">
<span id="titulo_pagina">
<div class="sombra11">Perfil de <%=usuario.getNome() %>
    <div class="texto1">Perfil de <%=usuario.getNome() %>
    </div>
</div></span><br />

<%
if(request.getAttribute("amigo") == null && request.getParameter("cod") != null){
%>
<form action="/openmusic/Solicitacao">
<!-- atributo retorna confirmação de solicitação ou erro caso já tenha feito solicitação para este usuário -->
<%
if(request.getAttribute("confirma") != null)
	out.println(request.getAttribute("confirma"));
if(request.getAttribute("erro") != null)
	out.println(request.getAttribute("erro")); 
%>
<input type="hidden" value="<%=usuario.getId() %>" name="cod_solicitacao">
<input id="efetuar" type="submit" value="Adicionar aos Amigos"/>

</form>
<%} %>

<a href="/openmusic/Recado?recado=new&cod=<%=usuario.getId() %>">Recados</a>

</body>
</html> 