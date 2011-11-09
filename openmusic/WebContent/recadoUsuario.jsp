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
		style="border: 1px solid red; float: left; margin: 0px 0px 0px 26px;">
		<div id="nome_perfil">
			<span><%=usuario.getNome() + " " + usuario.getSobrenome()%></span>
		</div>

		<div id="area">
			<form method="post" action="Recado" name="form1">
				<label for="box">Recado (Caracteres Restantes <span
					class="contador"></span>)</label><br />
				<textarea name="box" class="box" id="box"></textarea>

				<input type="hidden" name="cod_usuario_recado"
					value="<%=usuario.getId()%>" /> <input type="submit"
					value="enviar" />
			</form>
		</div>
	</div>
	<%
		if (request.getAttribute("erro") != null) {
			out.println(request.getAttribute("erro").toString());
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
						<div style=" margin-right: 5px; float: left; clear: left;">
							<img src="fotos/<%=a.getAmigo1().getFoto()%>" width="70"
								height="70">
						</div>
						<div style="height: 25px; width: 70px; float: left; margin-top: 22px;"><%=a.getAmigo1().getNome()%></div>
				</div>

				<%
					} else {
				%>

				<div
					style="border: 0px solid red; margin-bottom: 20px; float: left; clear: left;">
					<a href="Perfil?cod=<%=a.getAmigo2().getId()%>">
						<div style=" margin-right: 5px; float: left; clear: left;">
							<img src="fotos/<%=a.getAmigo2().getFoto()%>" width="70" height="70" />
						</div>
						<div style="height: 25px; width: 70px; float: left; margin-top: 22px;"><%=a.getAmigo2().getNome()%></div>
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


	<%
		List recados = (List) request.getAttribute("recados");
		if (recados != null) {
	%>

	<div id="lista_recados">

		<%
			Iterator it = recados.iterator();
				while (it.hasNext()) {
					Recado u = (Recado) it.next();
		%>
		<div class="area_scraps">
			<div style="border: 1px solid #333333; width: 92px; float: left;">
				<a href="Perfil?cod=<%=u.getAmigo().getId()%>"> <img
					src="fotos/<%=u.getAmigo().getFoto()%>" width="75" height="75">
				</a>
			</div>
			<div style="border: 2px solid green; width: 482px; float: left;">
				<a style="color: black;" href="Perfil?cod=<%=u.getAmigo().getId()%>"><%=u.getAmigo().getNome()%></a>
				disse:
			</div>
			<div class="recado"><%=u.getRecado()%></div>
			<%
				if (u.getAmigo().getId() == Integer.parseInt(session
								.getAttribute("cod_usuario").toString())
								|| u.getUsuario().getId() == Integer
										.parseInt(session.getAttribute(
												"cod_usuario").toString())) {
			%>
			<div class="excluir">
				<a href="Recado?cod=<%=usuario.getId()%>&rec=<%=u.getId()%>"><img
					src="imagens/delete.png" />
				</a>
			</div>
			<%
				}
			%>

		</div>

		<%
			}
		%>


		<%
			} else
				out.println("<h1>Sem recados</h1>");
		%>
	</div>

	<%@ include file="footer.jsp"%>