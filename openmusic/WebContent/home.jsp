<%@ include file="header.jsp" %> 
<div id="geral_conteudo">
<span id="titulo_pagina">
<div class="sombra11">Home
    <div class="texto1">Home
    </div>
</div></span><br />
<%
//declarando repositorio de amigo e usuario
AmigoRepository amigorepositorio = new AmigoRepository();
UsuarioRepository usuarioRepository =  new UsuarioRepository();

//pegar o login da sessão
int cod = Integer.parseInt(request.getAttribute("cod_usuario").toString());


//realizar seleção conforme id do usuario logado
SolicitacaoRepository solicitacaorepositorio = new SolicitacaoRepository();
List<Solicitacao> s = solicitacaorepositorio.getBySolicitacao(cod);

if(s != null){
	for(Solicitacao so : s){
		%>
		<div id="titulo_input">
		<%
		out.println(so.getIdSolicitador().getNome());
			%> solicitou sua amizade, confirma o pedido?<br />
			<a href="Amigo?resp=s&cod=<%=so.getIdSolicitador().getId() %>">sim</a> |
			<a href="Amigo?resp=n&cod=<%=so.getIdSolicitador().getId() %>">não</a>
			</div>
			<br />
			<%
	}
}
%>

<div style="float: right; border: 1px solid red; width: 250px;">
<span id="titulo_pagina">
<div class="sombra11">Lista de Amigos
    <div class="texto1">Lista de Amigos
    </div>
</div></span><br />
<div>
<%


List<Amigo> amigo = amigorepositorio.getTop10ByName(cod);
if(amigo != null){
for(Amigo a : amigo){
	%>
	<div id="titulo_input">
	<%
	if(a.getIdAmigo1().getId() != cod){
		%>
		<a href="Perfil?cod=<%=a.getIdAmigo1().getId() %>"><%=a.getIdAmigo1().getNome() %></a>
		<br />
		<%
	}else{
		%>
		<a href="Perfil?cod=<%=a.getIdAmigo2().getId() %>"><%=a.getIdAmigo2().getNome() %></a>
		<br />
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

</div>


<div id="rodape">
</div>
</body>
</html>