<%@ include file="header.jsp"%>
<%
	AmigoRepository amigorepositorio = new AmigoRepository();
	Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<div id="geral_conteudo">

	<div
		style="float: left; border: 0px solid red; margin-left: 53px; color: black;">
		<a href="usuarioFoto.jsp" title="Alterar foto"><img
			src="fotos/<%=usuario.getFoto()%>" width="145" height="186"> </a>
	</div>
	<div
		style="border: 1px solid red; float: left; margin: 63px 0px 0px 26px;">
		<div id="nome_perfil">
			<span><%=usuario.getNome() + " " + usuario.getSobrenome()%></span>
		</div>
		<div id="local">
			<span><%=usuario.getPais()%></span>
		</div>
		<div id="link_recados">
			<a href="Recado?cod=<%=usuario.getId()%>"><img
				src="imagens/ico_recado.jpg">Recados</a>
		</div>
	</div>





	<%
		if (request.getAttribute("amigo") == null
				&& usuario.getId() != Integer.parseInt(session
						.getAttribute("cod_usuario").toString())) {
			if (request.getAttribute("confirma") != null)
				out.println(request.getAttribute("confirma"));
			if (request.getAttribute("erro") != null)
				out.println(request.getAttribute("erro"));
	%>
	<form method="post" action="Solicitacao" name="form1">
		<!-- atributo retorna confirmação de solicitação ou erro caso já tenha feito solicitação para este usuário -->
		<input type="hidden" value="<%=usuario.getId()%>"
			name="cod_solicitacao"> <input id="efetuar" type="submit"
			value="Adicionar aos Amigos" />
	</form>
	<%
		}
	%>



	<div class="list_musicas" style="border: 1px solid blue;">
		<div id="lista_musicas"
			style="border: 1px solid green; width: 337px; height: 46px;"></div>
		<!-- 	TITULO MUSICAS -->
		<div class="scroll_musicas">
			<div style="margin-bottom: 5px;">
				<a href="#" class="texto_m">1. brasileirinho</a>
			</div>
			<div style="margin-bottom: 5px;">
				<a href="#" class="texto_m">2. brasileirinho</a>
			</div>
			<div style="margin-bottom: 5px;">
				<a href="#" class="texto_m">3. brasileirinho</a>
			</div>
			<div style="margin-bottom: 5px;">
				<a href="#" class="texto_m">4. brasileirinho</a>
			</div>
			<div style="margin-bottom: 5px;">
				<a href="#" class="texto_m">5. brasileirinho</a>
			</div>
		</div>
	</div>
	<!-- LISTA DE MUSICAS  -->

	<div class="list_amigos"
		style="border: 1px solid blue; margin-bottom: 5px;">

		<div id="lista_amigos"
			style="border: 1px solid green; width: 337px; height: 52px;"></div>
		<div class="scroll_amigos">
			<%
				List<Amigo> amigo = amigorepositorio
						.getTop10ByName(usuario.getId());
				if (amigo != null) {
					for (Amigo a : amigo) {
			%>
			<div id="titulo_input" class="nome_amigo">
				<%
					if (a.getAmigo1().getId() != usuario.getId()) {
				%>

				<div style="margin-bottom: 20px; float: left; clear: left;">
					<a href="Perfil?cod=<%=a.getAmigo1().getId()%>">
						<div
							style="clear: both; margin-right: 5px; float: left; clear: both;">
							<img src="fotos/<%=a.getAmigo1().getFoto()%>" width="50"
								height="50">
						</div>
						<div style="height: 50px;"><%=a.getAmigo1().getNome()%></div>
				</div>

				<%
					} else {
				%>

				<div
					style="border: 0px solid red; margin-bottom: 20px; float: left; clear: left;">
					<a href="Perfil?cod=<%=a.getAmigo2().getId()%>">
						<div
							style="clear: both; margin-right: 5px; float: left; clear: left;">
							<img src="fotos/<%=a.getAmigo2().getFoto()%>" width="70"
								height="70">
						</div>
						<div
							style="height: 25px; width: 70px; float: left; margin-top: 22px;"><%=a.getAmigo2().getNome()%></div>
					</a>
				</div>

				<%
					}
				%>
			</div>
			<%
				}
				}
			%>
		</div>
	</div>
	<!-- LISTA DE AMIGOS -->

	<div id="gravador">
		<div id="titulo_gravador">
			<div style="width: 100px;">1. brasileirinho</div>
			<div
				style="font-size: 12px; width: 100px; margin-right: 58px; float: right; width: 100px; font-weight: bold; margin-top: -22px;">
				<a href="#"><img src="imagens/ico_aplaudir.png" /> Aplaudir(25)</a>
			</div>
		</div>
		<div id="rec"></div>
		<div id="stop"></div>
		<div id="save"></div>

	</div>

</div>

<%@ include file="footer.jsp"%>