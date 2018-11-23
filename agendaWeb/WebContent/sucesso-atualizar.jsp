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
						<div class="card-header bg-info text-light"><h4>SUCESSO</h4></div>
						<div class="card-body">
							<h5>Seus dados foram atualizados com sucesso.</h5>
						</div>
						<div class="card-footer"><a href="#">Sair do Sistema</a></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%}%>