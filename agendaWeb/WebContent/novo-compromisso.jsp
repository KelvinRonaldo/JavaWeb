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
					<div class="card-header bg-info text-light"><h4>Agendar Compromisso</h4></div>
					<form id="form-contato" action="AgendarCompromissoServlet" method="post">
												<!--↑@webservlet da classe servlet -->
						<div class="card-body">
							<div class="bg-light card mt-1">
								<div class="card-header">
									<div class="row align-items-center">
										<div class="col-md-2"> <img src="img/addUser64.png"></div>
										<div class="col-md-10 text-primary"><h3>ADICIONAR COMPROMISSO</h3></div>
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
												<div class="col-md-9">
													<label for="txt-titulo">Titulo:</label>
													<input class="form-control" type="text" id="txt-titulo" name="txt-titulo">
												</div>
												<div class="col-md-3">
													<label for="cb-prioridade">Prioridade:</label>
													<select class="form-control" id="cb-prioridade" name="cb-prioridade">
														<option value="1">Normal</option>
														<option value="2">Baixa</option>
														<option value="0">Alta</option>
													</select>
												</div>
											</div>
											<div class="row mt-3">
												<div class="col-md-4">
													<label for="txt-data">Data:</label>
													<input class="form-control" type="date" id="txt-data" name="txt-data">
												</div>
												<div class="col-md-2">
													<label for="txt-hora-inicio">Hora Início:</label>
													<input class="form-control" type="time" id="txt-hora-inicio" name="txt-hora-inicio">
												</div>
												<div class="col-md-2">
													<label for="txt-hora-fim">Hora Fim:</label>
													<input class="form-control" type="time" id="txt-hora-fim" name="txt-hora-fim">
												</div>
												<div class="col-md-4">
													<label for="cb-status">Status:</label>
													<select class="form-control" id="cb-status" name="cb-status">
														<option value="0">Em Andamento</option>
														<option value="1">Cancelado</option>
														<option value="2">Concluído</option>
													</select>
												</div>
											</div>
											<div class="row mt-3">
												<label for="txt-descricao">Descrção do Compromisso:</label>
												<textarea class="form-control" id="txt-descricao" name="txt-descricao" rows="4" cols="0"></textarea>
											</div>
										</fieldset>
									</div>
								</div>
							</div>						
						</div>
						<div class="card-footer">
							<button class="btn btn-success" id="btn-salvar">Salvar</button>
							<a href="compromissos.jsp" class="btn btn-danger">Cancelar</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%}%>