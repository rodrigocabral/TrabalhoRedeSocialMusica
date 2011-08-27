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
<div id="lista_amigos">
<a href="Recado?cod=<%=usuario.getId() %>">Recados</a>
</div>
<%
if(request.getAttribute("amigo") == null && usuario.getId() != Integer.parseInt(session.getAttribute("cod_usuario").toString())){
	if(request.getAttribute("confirma") != null)
		out.println(request.getAttribute("confirma"));
	if(request.getAttribute("erro") != null)
		out.println(request.getAttribute("erro")); 
	%>
<form method="post" action="Solicitacao" name="form1">
<!-- atributo retorna confirmação de solicitação ou erro caso já tenha feito solicitação para este usuário -->
<input type="hidden" value="<%=usuario.getId() %>" name="cod_solicitacao">
<input id="efetuar" type="submit" value="Adicionar aos Amigos"/>

</form>
<%} %>


</body>
</html> 