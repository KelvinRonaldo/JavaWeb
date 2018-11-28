<%@page import="br.senai.sp.model.Contato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.sp.dao.ContatoDAO"%>
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
		ContatoDAO dao = new ContatoDAO();
		ArrayList<Contato> contatos = new ArrayList<>();
		contatos = dao.getContatos(usuario.getCodUsuario());
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
						<p>
							Seu usuário foi criado com sucesso, a partir de agora você ja pode cadastrar seus contatos e compromissos.
						</p>
						<h6>APROVEITE!</h6>
					</div>
					<div class="card-footer">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%}%>