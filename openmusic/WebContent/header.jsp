<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="domainModel.Usuario"%>
<%@ page import="domainModel.Recado"%>
<%@page import="java.util.Iterator"%>
<%@ page
	import="domainModel.Solicitacao,domainModel.Amigo,dataAccess.UsuarioRepository,dataAccess.SolicitacaoRepository,dataAccess.AmigoRepository"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>OpenMusic</title>
<link href="css/topo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
 <script type="text/javascript"	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.js"></script>

<script type="text/javascript" src="js/slimScroll.js"></script>
<script src="js/jquery.limit-1.2.js" language="javascript"></script>


<style type="text/css">

.slimScrollDiv {
	border: 0px solid #ccc;
	margin: 10px;
}
</style>

</head>
<body>
	<div id="menu">
		<div style="margin: auto; width: 1200px;">
			<div class="item_menu">
				<a href="home.jsp">Página inicial</a>
			</div>
			<div class="item_menu">
				<a href="Perfil">Studio</a>
			</div>
			<div class="item_menu">
				<a href="Recado">Recados</a>
			</div>
			<div style="float: right; padding: 5px;">
				<form method="post" action="/openmusic/Usuarios" name="form1">
					Busca: <input type="text" class="fakebusca" name="busca"
						x-webkit-speech /> <input type="submit" id="efetuar_busca"
						value="buscar" />
				</form>
			</div>
		</div>
	</div>
	<!--MENU-->
	<div id="geral_topo">
		<div id="conteudo_topo">
			<div id="logomarca"></div>
		</div>
		<div id="config"
			style="float: right; margin-right: 104px; font-family: arial; font-size: 13px !important;">
			<a href="Usuarios?function=Edit">Meus Dados</a> |<a href="Login">
				Sair</a>
		</div>
	</div>
	<!--GERAL_TOPO-->