<%@ include file="header.jsp" %> 
<%
Usuario usuario = (Usuario) request.getAttribute("usuario"); 
%>
<div id="geral_conteudo">
<span id="titulo_pagina">
<div class="sombra11">Recados de <%=usuario.getNome() %>
    <div class="texto1">Recados de <%=usuario.getNome() %>
    </div>
</div></span><br />
<%
if(request.getAttribute("erro") != null){
	out.println(request.getAttribute("erro").toString());
}
%>

<form method="post" action="Recado" name="form1">

<textarea name="recado" rows="10" cols="50"></textarea>

<input type="hidden" name="cod_usuario_recado" value="<%=usuario.getId() %>"/>

<input type="submit" value="enviar" />


</form>


<% 
	List recados = (List) request.getAttribute("recados");
    if(recados!= null) {
	   %>
	   <table width="400px">
	   <%
		   Iterator it = recados.iterator();
		   while(it.hasNext()){
			   Recado u = (Recado)it.next();
		   %>
		   <tr>
		   <td><%=u.getIdamigo().getNome() %> disse: </td>
		   <td></td>
		   </tr>
		   <tr>
		   		<td></td>
		   		<td align="left"><%=u.getRecado() %></td>
		   </tr>
		   <tr>
		   	<td colspan="2"><hr></td><td><hr></td>
		   </tr>
		 <% 
	   }
	   %>
	   </table>
	<%
	}else
		out.println("<h1>Sem recados</h1>");	
    %>




</body>
</html>