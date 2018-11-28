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
					<div class="card-header bg-info text-light"><h4>Cadastrar Contato</h4></div>
					<div class="card-body">
						<form id="form-contato" action="CadastrarContatoServlet" method="post">
												<!--↑@webservlet da classe servlet -->
							<div class="bg-light card mt-1">
								<div class="card-header">
									<div class="row align-items-center">
										<div class="col-md-2"> <img src="img/addUser64.png"></div>
										<div class="col-md-10 text-primary"><h3>ADICIONAR CONTATO</h3></div>
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
													<input class="form-control" type="text" id="txt-nome" name="txt-nome">
												</div>
												<div class="col-md-3">
													<label for="txt-nascimento">E-mail:</label>
													<input class="form-control" type="text" id="txt-email" name="txt-email">
												</div>
												<div class="col-md-3">
													<label for="txt-telefone">Telefone:</label>
													<input class="form-control" type="text" id="txt-telefone" name=txt-telefone>
												</div>
											</div>
										</fieldset>
									</div>
								</div>
							</div>
						
					</div>
					<div class="card-footer">
						<button class="btn btn-success" id="btn-cadastrar">Salvar</button>
						<a href="contatos.jsp" class="btn btn-danger">Cancelar</a>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%}%>