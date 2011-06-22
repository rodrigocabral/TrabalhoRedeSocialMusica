<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="domainModel.Usuario,domainModel.Solicitacao,domainModel.Amigo" %>
    <%@ page import="dataAccess.UsuarioRepository,dataAccess.SolicitacaoRepository,dataAccess.AmigoRepository" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%
//declarando repositorio de amigo e usuario
AmigoRepository amigorepositorio = new AmigoRepository();
UsuarioRepository usuariorepositorio =  new UsuarioRepository();

//pegar o login da sessão
String cod_usuario = request.getAttribute("cod_usuario");

//realizar seleção conforme id do usuario logado
SolicitacaoRepository solicitacaorepositorio = new SolicitacaoRepository();
Solicitacao s = solicitacaorepositorio.getBySolicitacao(Integer.parseInt(cod_usuario));
%>
<title>Home</title>
<link href="css/topo.css" rel="stylesheet" type="text/css">
</head>

<body>
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
List<Amigo> amigo = amigorepositorio.getTop10ByName();
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