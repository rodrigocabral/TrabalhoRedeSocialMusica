<%@ include file="header.jsp" %>
<style type="text/css" >
  
label { display: block; margin-top: 10px; }
label.error { float: none; color: red; margin: 0 .5em 0 0; vertical-align: top; font-size: 10px }
p { clear: both; }
.submit { margin-top: 1em; }
em { font-weight: bold; padding-right: 1em; vertical-align: top; }
</style>

<script src="js/jquery.js" type="text/javascript"></script>
 <script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput.js" type="text/javascript"></script>

<script type="text/javascript">

  $(document).ready( function() {
	$("#data_nascimento").mask("99/99/9999");
	$("#formulario").validate({
		// Define as regras
		rules:{
			nome:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			sobrenome:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			senha:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 6
			},
			confirma_senha:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			email:{
				// campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
				required: true, email: true
			},
			data_nascimento:{
				// campoMensagem será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true
			},
			cidade:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			pais:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			}
		},
		// Define as mensagens de erro para cada regra
		messages:{
			nome:{
				required: "Digite o seu nome",
				minlength: "O seu nome deve conter, no mínimo, 2 caracteres"
			},
			sobrenome:{
				required: "Digite o seu sobrenome",
				minlength: "O seu sobrenome deve conter, no mínimo, 2 caracteres"
			},
			email:{
				required: "Digite o seu e-mail",
				email: "Digite um e-mail válido"
			},
			senha:{
				required: "Digite a sua senha",
				minlength: "A senha deve conter, no mínimo, 6 caracteres"
			},
			confirma_senha:{
				required: "Digite a confirmação da senha",
				minlength: "A confirmação de senha deve ter, no mínimo, 6 caracteres"
			},
			data_nascimento:{
				required: "Digite a sua data de nascimento"
			},
			cidade:{
				required: "Digite a sua cidade",
				minlength: "O nome da sua cidade deve conter, no mínimo, 2 caracteres"
			},
			pais:{
				required: "Digite o seu pais",
				minlength: "O nome do seu país deve conter, no mínimo, 2 caracteres"
			}
		}
	});
});
  </script>
<div id="geral_conteudo">
<span id="titulo_pagina">
<div class="sombra11">Cadastre-se em nossa rede
    <div class="texto1">Cadastre-se em nossa rede
    </div></div></span><br />
<%
Usuario u = (Usuario)request.getAttribute("usuario");

%>
<form action="Usuarios" method="post" id="formulario" >
		<table>
			<tr>
			<td id="titulo_input">Nome: </td>
			<td><input class="fakeupload" type="text" name="nome" value="<%=u.getNome() %>" /></td></tr>
			<tr>
			<td id="titulo_input">Sobrenome: </td>
			<td><input class="fakeupload" type="text" name="sobrenome" value="<%=u.getSobrenome() %>" /></td></tr>
			<tr>
			<td id="titulo_input">Email: </td>
			<td><input class="fakeupload" type="text" name="email" value="<%=u.getEmail() %>" /></td></tr>
			<tr>
			<td id="titulo_input">Senha: </td>
			<td><input class="fakeupload" type="password" name="senha" onfocus="value=''" value="<%=u.getSenha() %>" />
			<input class="fakeupload" type="hidden" name="senha_oculta" value="<%=u.getSenha() %>" />
			</td></tr>
			<tr>
			<td id="titulo_input">Confirme Senha: </td>
			<td><input class="fakeupload" type="password" name="confirma_senha" onfocus="value=''" value="<%=u.getSenha() %>" /></td></tr>
			<tr>
			<td id="titulo_input">Sexo: </td>
			<td>
			<select class="fakeupload" name="sexo" id="sexo">
			<% if(u.getSexo().equals("Masculino")){ %>
            <option>Masculino</option>
            <option>Feminino</option>
            <% }else{ %>
            <option>Feminino</option>
            <option>Masculino</option>
            <% } %>
            </select>
			</td></tr>
			<tr>
			<td id="titulo_input">Data Nascimento: </td>
			<td><input class="fakeupload" type="text" name="data_nascimento" value="<%=u.dataImpres(u.getDatanascimento()) %>" id="data_nascimento" /></td></tr>
			<tr>
			<td id="titulo_input">Cidade: </td>
			<td><input class="fakeupload" type="text" name="cidade" value="<%=u.getCidade() %>" /></td></tr>
			<tr>
			<td id="titulo_input">Estado: </td>
			<td>
			<select class="fakeupload" name="estado" id="estado">
			<option><%=u.getEstado() %></option>
			<option>--------------</option>
            <option>MG</option>
            <option>AL</option>
            <option>AM</option>
            <option>AP</option>
            <option>BA</option>
            <option>CE</option>
            <option>DF</option>
            <option>ES</option>
            <option>GO</option>
            <option>MA</option>
            <option>AC</option>
            <option>MS</option>
            <option>MT</option>
            <option>PA</option>
            <option>PB</option>
            <option>PE</option>
            <option>PI</option>
            <option>PR</option>
            <option>RJ</option>
            <option>RN</option>
            <option>RO</option>
            <option>RR</option>
            <option>RS</option>
            <option>SC</option>
            <option>SE</option>
            <option>SP</option>
            <option>TO</option>
          </select>
			</td></tr>
			<tr>
			<td id="titulo_input">Pais: </td>
			<td><input class="fakeupload" type="text" name="pais" value="<%=u.getPais() %>" /></td>
			</tr>
		</table>
		<input id="efetuar" type="submit" value="Salvar" />
	</form>

</body>
</html>