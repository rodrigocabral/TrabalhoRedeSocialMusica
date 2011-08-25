<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List" %>
    <%@ page import="domainModel.Usuario" %>
    <%@ page import="domainModel.Recado" %>
    <%@page import="java.util.Iterator"%>
    <%@ page import="domainModel.Solicitacao,domainModel.Amigo,dataAccess.UsuarioRepository,dataAccess.SolicitacaoRepository,dataAccess.AmigoRepository" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>OpenMusic</title>
<link href="css/topo.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div id="menu">
<div style="margin: auto; width: 1200px;">
<div class="item_menu">home </div> 
<div class="item_menu">gravações</div>
<div class="item_menu"> recados </div>
  <form method="post" action="/openmusic/Usuarios" name="form1" >
	Busca:
	<input type="text" class="fakeupload" name="busca"  />
	<input type="submit" id="efetuar" value="buscar" />
</form>
</div>
</div>
<div id="geral_topo">
	<div id="conteudo_topo">
        <div id="logomarca">
        	</div>
     </div>
</div>

