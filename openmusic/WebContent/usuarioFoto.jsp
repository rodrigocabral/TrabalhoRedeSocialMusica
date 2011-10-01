<%@ include file="header_login.jsp" %>
<div id="geral_conteudo">
<span id="titulo_pagina">
<div class="sombra11">Cadastre-se em nossa rede
    <div class="texto1">Cadastre-se em nossa rede
    </div></div></span><br />

<form  enctype="multipart/form-data" action="Usuarios"  method="post" id="formulario" >
		<table>
			<tr>
			<input type="hidden" id="tipoForm" name="tipoForm" value="imagem">
			<td id="titulo_input" align="right">Foto: </td>
			<td><input class="fakeupload" name="foto" type="file" id="imagem" ></td></tr>
			<tr>
			<td></td>
			<td><input id="efetuar" type="submit" value="Enviar" /></td>
			</tr>
		</table>
</form>

</body>
</html>