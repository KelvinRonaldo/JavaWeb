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
					<div class="card-header bg-info text-light"><h4>Meus Contatos</h4></div>
					<div class="card-body">
						<table class="table table-hover">
							<thead>
								<th>Código</th>
								<th>Nome</th>
								<th>E-mail</th>
							</thead>
							<tbody>
								<% for(Contato c : contatos){ %>
									<tr>
										<td><%= c.getCodigo() %></td>
										<td><%= c.getNome()%></td>
										<td><%= c.getEmail() %></td>									
									</tr>
								<% } %>
							</tbody>							
						</table>
					</div>
					<div class="card-footer"><a href="#">Sair do Sistema</a></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%}%>