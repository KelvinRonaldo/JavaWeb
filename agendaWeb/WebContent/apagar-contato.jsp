<%@page import="br.senai.sp.model.Contato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.sp.dao.ContatoDAO"%>
<%@page import="br.senai.sp.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>

<%  Usuario usuario = new Usuario();
	usuario = (Usuario)session.getAttribute("usuario");
	//↑ converte o ↑objeto na classe desejada, no caso a Usuario
	
	Contato contato = new Contato();
	contato = (Contato)session.getAttribute("contato");
	session.removeAttribute("contato");
	
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
					<div class="card-header bg-danger text-light">
						<h4>EXCLUIR CONTATO</h4>
					</div>
					<div class="card-body">
						<div class="row align-items-center">
							<div class="col-md-1">
								<img src="img/warning58.png">
							</div>
							<div class="col-md-11">
								<h2 class="text-danger">ATENÇÃO</h2>
							</div>
						</div>
						<h5>Tem certeza de que deseja excluir o contato abaixo?</h5>
						<h6><%= request.getParameter("nome") %> </h6>
					</div>
					<div class="card-footer">
						<a href="ApagarContatoServlet?codigo=<%= request.getParameter("codigo")%>" class="btn text-light btn-danger">Apagar Contato</a>
						<a href="contatos.jsp" class="btn btn-success">Cancelar</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%}%>