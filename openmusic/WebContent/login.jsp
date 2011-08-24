<%@ include file="header.jsp" %> 


<% String erro = (String)request.getAttribute("erro"); 
 if(erro != null){
	 %><p>Atencao! Aconteceu um erro: <%=erro %></p><% 
 }
%>
<form method="post" action="/openmusic/Login">
<label>Login: </label>
<input type="text" value="" name="login" /><br/>
<p></p>
<label>Senha: </label>
<input type="password" value="" name="senha" /><p></p>
<input type="submit" value="Entrar" />
</form>

</body>
</html>