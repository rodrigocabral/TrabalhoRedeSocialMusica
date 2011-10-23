<%@ include file="header.jsp" %>
<div id="geral_conteudo">
<span id="titulo_pagina">
<div class="sombra11">Home
    <div class="texto1">Home
    </div>
</div></span><br />
<%

//String baseURL = request.getRequestURL().toString().replace(request.getRequestURI().substring(0), request.getContextPath());


//declarando repositorio de amigo e usuario
AmigoRepository amigorepositorio = new AmigoRepository();
UsuarioRepository usuarioRepository =  new UsuarioRepository();

//pegar o login da sessão
//int cod = Integer.parseInt(request.getAttribute("cod_usuario").toString());
int cod;
session = request.getSession();
cod = Integer.parseInt(session.getAttribute("cod_usuario").toString());
Usuario usuario = usuarioRepository.Open(cod);
//out.println("../fotos/"+usuario.getFoto());
%>
<div style="float: left; border: 0px solid red; margin-left: 5px; color: black;">
<a href="usuarioFoto.jsp" title="Alterar foto"><img src="fotos/<%=usuario.getFoto() %>" width="100" height="125"></a>
</div>
<%
//realizar seleção conforme id do usuario logado
SolicitacaoRepository solicitacaorepositorio = new SolicitacaoRepository();
List<Solicitacao> s = solicitacaorepositorio.getBySolicitacao(cod);

if(s != null){
	for(Solicitacao so : s){
		%>
		<div id="titulo_input">
		<div id="lista_amigos">
		<%
		out.println(so.getSolicitador().getNome());
			%> solicitou sua amizade, confirma o pedido?<br />
			<a href="Amigo?resp=s&cod=<%=so.getSolicitador().getId() %>">sim</a> |
			<a href="Amigo?resp=n&cod=<%=so.getSolicitador().getId() %>">não</a>
			</div>
			</div>
			<br />
			<%
	}
}
%>

<div style="float: right; border: 0px solid red; min-width: 250px;">
<span id="titulo_pagina">
<div class="sombra11">Lista de Amigos
    <div class="texto1">Lista de Amigos
    </div>
</div></span><br />
<div id="lista_amigos">
<%


List<Amigo> amigo = amigorepositorio.getTop10ByName(cod);
if(amigo != null){
for(Amigo a : amigo){
	%>
	<div id="titulo_input">
	<%
	if(a.getAmigo1().getId() != cod){
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
/*try  {  
    String senha = "123456";  
    MessageDigest md = MessageDigest.getInstance( "MD5" );  
      
    md.update( senha.getBytes() );  
    BigInteger hash = new BigInteger( 1, md.digest() );  
    String retornaSenha = hash.toString( 16 );  
    out.println(retornaSenha);  
 }  

 catch(NoSuchAlgorithmException ns)  {  
    ns.printStackTrace();  
 }*/
%>
</div>
</div>

</div>


<div id="rodape">
</div>
</body>
</html>