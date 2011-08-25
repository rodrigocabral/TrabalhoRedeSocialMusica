<%@ include file="header.jsp" %> 
<div id="geral_conteudo">
<span id="titulo_pagina">
<div class="sombra11">Perfil
    <div class="texto1">Perfil
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
		out.println(so.getIdSolicitador().getNome());
			%> solicitou sua amizade, confirma o pedido?<br />
			<a href="Amigo?resp=s&cod=<%=so.getIdSolicitador().getId() %>">sim</a> |
			<a href="Amigo?resp=n&cod=<%=so.getIdSolicitador().getId() %>">não</a>
			<br />
			<%
	}
}
%>

<div style="float: right; border: 1px solid red;">
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
	if(a.getIdAmigo1().getId() != cod){
		out.println(a.getIdAmigo1().getNome());
	}else{
		out.println(a.getIdAmigo2().getNome());
	}
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