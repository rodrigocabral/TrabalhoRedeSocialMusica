<%@ include file="header_login.jsp" %> 

<% 
 %>

<div id="geral_conteudo">
<span id="titulo_pagina">
<div class="sombra11">Fa�a seu Login e Mostre o seu Talento
    <div class="texto1">Fa�a seu Login e Mostre o seu Talento
    </div></div></span><br /><br /><br />
    <div id="titulo_input">
    <% String erro = (String)request.getAttribute("erro"); 
 if(erro != null){
	 %><p>Atencao! <%=erro %></p><% 
 }
%>
</div>
<br />
<form method="post" action="/openmusic/Login">
<span id="titulo_pagina" style="float: left; width: 95px;">
<div class="sombra11">Login:</div></span>
<input type="text" value="" class="fakeupload" name="login" style="border: 0px;" /><br/>
<p></p>
<span id="titulo_pagina" style="float: left; width: 95px;">
<div class="sombra11">Senha:</div></span>
<input type="password" value="" class="fakeupload" name="senha" /><p></p>

<div id="lista_amigos" style="margin-top: -10px; margin-left: 80px;">
<a href="usuarioCadastrar.jsp">Cadastra-se</a>
</div>

<span style="margin-left: 270px; display: table;">
<input type="submit" id="efetuar" value="Entrar" />
</span>
</form>
</div>
</body>
</html>