<%@page import="br.senai.sp.model.Compromisso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.sp.dao.CompromissoDAO"%>
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
		CompromissoDAO dao = new CompromissoDAO();
		ArrayList<Compromisso> compromissos = new ArrayList<>();
		compromissos = dao.getCompromissos(usuario.getCodUsuario(), Integer.parseInt(request.getParameter("status")));
		int status = Integer.parseInt(request.getParameter("status"));
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
					<div class="card-header bg-info text-light">
						<div class="row align-items-center">
							<div class="col-md-8">
								<h4>Meus Compromissos</h4>
							</div>
							<div class="col-md-4 text-right">
								<a class="text-white" href="novo-compromisso.jsp">
									<img src="img/plus48.png">
									Novo Compromisso
								</a>
							</div>
						</div>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-3">
								<label for="cb-status">Status:</label>
								<select class="form-control" id="cb-status" name="cb-status">
									<option value="0" <%= status == 0? "selected": "" %> >Em Andamento</option>
									<option value="1" <%= status == 1? "selected": "" %> >Cancelado</option>
									<option value="2" <%= status == 2? "selected": "" %> >Concluído</option>
								</select>
							</div>
							<div class="col-md-9">
							</div>
						</div>
						<div class="row mt-3">
							<table class="table table-hover">
								<thead>
									<th>Código</th>
									<th>Titulo</th>
									<th>Data</th>
									<th></th>
									<th></th>
								</thead>
								<tbody>
									<% for(Compromisso comp : compromissos){ %>
										<tr>
											<td><%= String.format("%06d", comp.getCod_compromisso())%></td>
											<td>
												<a href="ConsultarCompromissoServlet?codigo=<%= comp.getCod_compromisso()%>"><%= comp.getTitulo()%></a>
											</td>
											<td><%= comp.getData() %></td>
											<td>
												<a href="CancelarCompromissoServlet?status=1&codigo=<%= comp.getCod_compromisso()%>">
													<img src="img/cancel35.png">
												</a>
											</td>
											<td>
												<a href="CancelarCompromissoServlet?status=2&codigo=<%= comp.getCod_compromisso()%>">
													<img src="img/done35.png">
												</a>
											</td>									
										</tr>
									<% } %>
								</tbody>							
							</table>
						</div>
					</div>
					<div class="card-footer"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%}%>