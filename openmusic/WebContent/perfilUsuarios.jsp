<%@ include file="header.jsp" %>
<%
	AmigoRepository amigorepositorio = new AmigoRepository();
	Usuario usuario = (Usuario)request.getAttribute("usuario");
%> 
<div id="geral_conteudo">
<span id="titulo_pagina">
<div class="sombra11"><%=usuario.getNome() %>
    <div class="texto1"><%=usuario.getNome() %>
    </div>
</div></span><br />
<div style="float: left; border: 0px solid red; margin-left: 5px; color: black;">
<a href="usuarioFoto.jsp" title="Alterar foto"><img src="fotos/<%=usuario.getFoto() %>" width="145" height="186"></a>
</div>
<div id="link_recados">
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
<!-- atributo retorna confirma��o de solicita��o ou erro caso j� tenha feito solicita��o para este usu�rio -->
<input type="hidden" value="<%=usuario.getId() %>" name="cod_solicitacao">
<input id="efetuar" type="submit" value="Adicionar aos Amigos"/>
</form>
<%} %>

<div style="float: right; border: 0px solid red; min-width: 250px;">
<span id="titulo_pagina">
<div class="amigos">
    <div class="list_amigos">
    </div>
</div></span><br />
<div id="lista_amigos">
<%


List<Amigo> amigo = amigorepositorio.getTop10ByName(usuario.getId());
if(amigo != null){
for(Amigo a : amigo){
	%>
	<div id="titulo_input">
	<%
	if(a.getAmigo1().getId() != usuario.getId()){
		%>
		<p>
		<div style="border: 0px solid red; margin-bottom: 20px;">
		<a href="Perfil?cod=<%=a.getAmigo1().getId() %>">
		<div style="clear: both; margin-right: 5px; float: left;"><img src="fotos/<%=a.getAmigo1().getFoto() %>" width="25" height="25"></div>
		<div style="height: 25px;"><%=a.getAmigo1().getNome() %></div>
		</a>
		</div>
		</p>
		<%
	}else{
		%>
		<p>
		<div style="border: 0px solid red; margin-bottom: 20px;">
		<a href="Perfil?cod=<%=a.getAmigo2().getId() %>">
		<div style="clear: both; margin-right: 5px; float: left;"><img src="fotos/<%=a.getAmigo2().getFoto() %>" width="25" height="25"></div>
		<div style="height: 25px;"><%=a.getAmigo2().getNome() %></div>
		</a>
		</div>
		</p>
		<%
	}
	%>
	</div>
	<%
}
}
%>
</div>
</div>
</body>
</html> 