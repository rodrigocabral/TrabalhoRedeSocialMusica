<%@ include file="header.jsp" %> 

<%
//declarando repositorio de amigo e usuario
AmigoRepository amigorepositorio = new AmigoRepository();
UsuarioRepository usuarioRepository =  new UsuarioRepository();

//pegar o login da sessão
String cod_usuario = (String) request.getAttribute("cod_usuario");

if (cod_usuario.equals(null)){
	cod_usuario = "1";
}


int cod = Integer.parseInt(cod_usuario);

//realizar seleção conforme id do usuario logado
SolicitacaoRepository solicitacaorepositorio = new SolicitacaoRepository();
List<Solicitacao> s = solicitacaorepositorio.getBySolicitacao(cod);
%>

<body>

  <form method="post" action="/openmusic/Usuarios" name="form1" >

	<input type="text" name="busca"  />

	<input type="submit" value="buscar" />

</form>



<%
if(s != null){
	%>
	Você tem uma solicitação de amizade pendente, confirma o pedido?<br />
	<a href="openmusic/Amigo?resp=s">sim</a> |
	<a href="openmusic/Amigo?resp=n">não</a>
	<%
}
%>

<div id="menu"><img src="imagens/menu.png" style=" margin-left:50px; padding-top:7px;" />
</div>
<div id="geral_topo">
	<div id="conteudo_topo">
        <div id="logomarca">
        	</div>
     </div>
</div>

<div id="geral_conteudo">
<span id="titulo_pagina">
<div class="sombra11">Perfil
    <div class="texto1">Perfil
    </div>
</div></span><br />

<div style="float: right;">
Lista de Amigos
<div>
<%


List<Amigo> amigo = amigorepositorio.getTop10ByName(cod);
for(Amigo a : amigo){
	if(a.getIdAmigo1().getId() != Integer.parseInt(cod_usuario)){
		System.out.println(a.getIdAmigo1().getNome());
	}else{
		System.out.println(a.getIdAmigo2().getNome());
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