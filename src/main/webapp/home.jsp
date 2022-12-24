<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.EntitiesUsuario"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="icon" href="imagens/favicon.png">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
<style>
body {
	background: #74ebd5;
	background: -webkit-linear-gradient(to right, #74ebd5, #ACB6E5);
	background: linear-gradient(to right, #74ebd5, #ACB6E5);
	min-height: 100vh;
}
</style>
</head>
<body class="container">
	<br></br>
	<main style="background: #fff; padding: 2%; border: 1px solid #000;">
		<div class="row">
			<div class="col s12">
				<div class="col s6">
					<h4>Agenda</h4>
				</div>
				<div class="col s2">
					<a href="adicionar.html"> <img src="imagens/save.png"
						alt="Adicionar">
					</a>
				</div>
				<div class="col s2">
					<a href="pdf"> <img src="imagens/pdf.png" alt="pdf">
					</a>
				</div>
				<div class="col s2">
					<a href="deslogar.jsp"> <img src="imagens/exit.png" alt="exit">
					</a>
				</div>
			</div>
		</div>
		<table class="responsive-table centered striped bordered" >
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>Atualizar</th>
					<th>Apagar</th>
				</tr>
			</thead>
			<tbody>
				<%
				String logado = (String) session.getAttribute("Acesso");
				if (logado == null) {
					response.sendRedirect("index.html");
				} else {
					@SuppressWarnings("unchecked")
					ArrayList<EntitiesUsuario> lista = (ArrayList<EntitiesUsuario>) request.getAttribute("contatos");
					for (EntitiesUsuario x : lista) {
				%>
				<tr class="linhaTr">
					<td><%=x.getUsuarioId()%></td>
					<td><%=x.getNome()%></td>
					<td><%=x.getCpf()%></td>
					<td><%=x.getTelefone()%></td>
					<td><%=x.getEmail()%></td>
					<td><a href="atualizar?usuarioId=<%=x.getUsuarioId()%>"> <img
							src="imagens/update.png" alt="update"></a></td>
					<td><a href="javascript: confirmar(<%=x.getUsuarioId()%>)">
							<img src="imagens/delete.png" alt="delete">
					</a></td>
				</tr>
				<%
				}
				%>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
	<script type="text/javascript" src="scripts/confirmador.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
		
	</script>
</body>
</html>