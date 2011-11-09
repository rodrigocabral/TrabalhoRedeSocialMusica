<%@ include file="header.jsp"%>
<div id="geral_conteudo">

	<%
		//String baseURL = request.getRequestURL().toString().replace(request.getRequestURI().substring(0), request.getContextPath());

		//declarando repositorio de amigo e usuario
		AmigoRepository amigorepositorio = new AmigoRepository();
		UsuarioRepository usuarioRepository = new UsuarioRepository();

		//pegar o login da sessão
		//int cod = Integer.parseInt(request.getAttribute("cod_usuario").toString());
		int cod;
		session = request.getSession();
		cod = Integer.parseInt(session.getAttribute("cod_usuario")
				.toString());
		Usuario usuario = usuarioRepository.Open(cod);
		//out.println("../fotos/"+usuario.getFoto());
	%>
	<div
		style="float: left; border: 1px solid red; margin-left: 5px; color: black; width: 120px; height: 400px;">
		<a href="usuarioFoto.jsp" title="Alterar foto"><img
			src="fotos/<%=usuario.getFoto()%>" width="75" height="94"> </a><br />
		<div style="float: left;">
			<span
				style="color: #780000; font-family: arial; font-size: 17; font-weight: bold;"><%=usuario.getNome()%></span>

			<div
				style="font-family: arial; font-size: 12px; font-weight: bold; color: #333333;">

				<a style="color: #333333;" href="Recado"><span
					style="margin: 28px 0px 5px 0px; float: left;"><img
						src="imagens/ico_recado.jpg">Recados</span> </a> <span
					style="float: left;"><img src="imagens/ico_solicitacoes.jpg">Solicitações(0)</span>

			</div>

		</div>
	</div>
	<%
		//realizar seleção conforme id do usuario logado
		SolicitacaoRepository solicitacaorepositorio = new SolicitacaoRepository();
		List<Solicitacao> s = solicitacaorepositorio.getBySolicitacao(cod);

		if (s != null) {
			for (Solicitacao so : s) {
	%>
	<div id="titulo_input">
		<div id="lista_amigos">
			<%
				out.println(so.getSolicitador().getNome());
			%>
			solicitou sua amizade, confirma o pedido?<br /> <a
				href="Amigo?resp=s&cod=<%=so.getSolicitador().getId()%>">sim</a> | <a
				href="Amigo?resp=n&cod=<%=so.getSolicitador().getId()%>">não</a>
		</div>
	</div>
	<br />
	<%
		}
		}
	%>

	<div id="meio">

		<div class="load">
			<div style="width: 80px; float: left">
				<img src="imagens/foto_usuario.jpg" />
			</div>
			<div class="texto_home">João: gravou uma nova canção</div>
			<div class="texto_home">
				<img src="imagens/ico_disco.jpg" /> Vou deixar
			</div>
			<div class="texto_home_2">
				<img src="imagens/ico_aplaudir.png" /> Aplaudir(25)
			</div>
			<div class="linha"></div>
		</div>

		<div class="load">
			<div style="width: 80px; float: left">
				<img src="imagens/foto_usuario.jpg" />
			</div>
			<div class="texto_home">João: gravou uma nova canção</div>
			<div class="texto_home">
				<img src="imagens/ico_disco.jpg" /> Vou deixar
			</div>
			<div class="texto_home_2">
				<img src="imagens/ico_aplaudir.png" /> Aplaudir(25)
			</div>
			<div class="linha"></div>
		</div>

		<div class="load">
			<div style="width: 80px; float: left">
				<img src="imagens/foto_usuario.jpg" />
			</div>
			<div class="texto_home">João: gravou uma nova canção</div>
			<div class="texto_home">
				<img src="imagens/ico_disco.jpg" /> Vou deixar
			</div>
			<div class="texto_home_2">
				<img src="imagens/ico_aplaudir.png" /> Aplaudir(25)
			</div>
			<div class="linha"></div>
		</div>

		<div class="load">
			<div style="width: 80px; float: left">
				<img src="imagens/foto_usuario.jpg" />
			</div>
			<div class="texto_home">João: gravou uma nova canção</div>
			<div class="texto_home">
				<img src="imagens/ico_disco.jpg" /> Vou deixar
			</div>
			<div class="texto_home_2">
				<img src="imagens/ico_aplaudir.png" /> Aplaudir(25)
			</div>
			<div class="linha"></div>
		</div>

		<div class="load">
			<div style="width: 80px; float: left">
				<img src="imagens/foto_usuario.jpg" />
			</div>
			<div class="texto_home">João: gravou uma nova canção</div>
			<div class="texto_home">
				<img src="imagens/ico_disco.jpg" /> Vou deixar
			</div>
			<div class="texto_home_2">
				<img src="imagens/ico_aplaudir.png" /> Aplaudir(25)
			</div>
			<div class="linha"></div>
		</div>


	</div>
	<!--MEIO-->

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
			<div style="margin-bottom: 5px;">
				<a href="#" class="texto_m">5. brasileirinho</a>
			</div>
			<div style="margin-bottom: 5px;">
				<a href="#" class="texto_m">5. brasileirinho</a>
			</div>
			<div style="margin-bottom: 5px;">
				<a href="#" class="texto_m">5. brasileirinho</a>
			</div>
			<div style="margin-bottom: 5px;">
				<a href="#" class="texto_m">5. brasileirinho</a>
			</div>
			<div style="margin-bottom: 5px;">
				<a href="#" class="texto_m">5. brasileirinho</a>
			</div>
		</div>
	</div>
	<!-- LISTA DE MUSICAS  -->

	<div class="list_amigos"
		style="clear: right; border: 1px solid blue; margin-bottom: 5px;">

		<div id="lista_amigos"
			style="border: 1px solid green; width: 337px; height: 52px;"></div>
		<div class="scroll_amigos">
			<%
				List<Amigo> amigo = amigorepositorio.getTop10ByName(cod);
				if (amigo != null) {
					for (Amigo a : amigo) {
			%>

			<div id="titulo_input" class="nome_amigo">

				<%
					if (a.getAmigo1().getId() != cod) {
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
	<!--LISTA DE AMIGOS-->

</div>
<!--GERAL CONTEUDO-->


<%@ include file="footer.jsp"%>

