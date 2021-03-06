<%@page import="br.senai.sp.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>

<% 
	Usuario usuario = new Usuario();
	usuario = (Usuario)session.getAttribute("usuario");
				//↑ converte o ↑objeto na classe desejada, no caso a Usuario
	if(usuario == null){
		response.sendRedirect("login.html");
	}else{
%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agenda Eletrônica</title>
<body class="bg-dark">
	<%@ include file="header.html" %>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-3">
				<%@ include file="painel-usuario.jsp" %>
				<%@ include file="painel-menu.jsp" %>
			</div>
			<div class="col-md-9">
				<div class="card">
					<div class="card-header bg-info text-light"><h4>Bem-Vindo</h4></div>
					<div class="card-body">
						<form id="form-usuario" action="AtualizarUsuarioServlet" method="post">
												<!--↑@webservlet da classe servlet -->
							<div class="bg-light card mt-1">
								<div class="card-header">
									<div class="row align-items-center">
										<div class="col-md-2"> <img src="img/addUser64.png"></div>
										<div class="col-md-10 text-primary"><h3>ATUALIZAÇÃO DO USUÁRIO</h3></div>
									</div>
								</div>
								<div class="bg-white card-body">
									<div id="painelDeErros">
										<h6 id="tituloErro" class="text-danger"></h6>
										<ul id="mensagem-erros">
										</ul>
									</div>
									<div>
										<fieldset class="form-group">
											<legend class="text-info font-weight-bold">Dados Gerais:</legend>	
											<div class="row">
												<div class="col-md-6">
													<label for="txt-nome">Nome:</label>
													<input class="form-control" type="text" id="txt-nome" name="txt-nome" value="<%=usuario.getNome()%>">
												</div>
												<div class="col-md-3">
													<label for="txt-nascimento">Data de Nascimento:</label>
													<input class="form-control" type="date" id="txt-nascimento" name="txt-nascimento" value="<%=usuario.getDtNascimento()%>">
												</div>
												<div class="col-md-3">
													<label for="cb-sexo">Sexo:</label>
													<select class="form-control" id="cb-sexo" name="cb-sexo">
														<option>Selecione:</option>
														<option <%= usuario.getSexo().equals("M") ? "selected" : "" %>>Masculino</option>
														<option <%= usuario.getSexo().equals("F") ? "selected" : "" %>>Feminino</option>
													</select>
												</div>
											</div>
										</fieldset>
										<fieldset class="form-group">
											<legend class="text-info font-weight-bold">Dados de Acesso:</legend>	
											<div class="row">
												<div class="col-md-6">
													<label for="txt-email">E-mail:</label>
													<input class="form-control" type="email" id="txt-email" name="txt-email" value="<%=usuario.getEmail()%>">
												</div>
												<div class="col-md-3">
													<label for="txt-senha1">Senha:</label>
													<input class="form-control" type="password" id="txt-senha1" name="txt-senha1">
												</div>
												<div class="col-md-3">
													<label for="txt-senha2">Repetir:</label>
													<input class="form-control" type="password" id="txt-senha2" name="txt-senha2">
												</div>
											</div>
										</fieldset>
									</div>
								</div>
							</div>
						
					</div>
					<div class="card-footer">
						<button class="btn btn-success" id="btn-cadastrar">Atualizar Usuário</button>
						<a href="index.jsp" class="btn btn-danger">Cancelar</a>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="js/formulario.js"></script>
</body>
</html>
<%}%>