<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	String nome = request.getParameter("xpto");
	
	int resposta = Integer.parseInt(email) + Integer.parseInt(senha);
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%= email %>
		<%= senha %>
		<h3><%= "Resultado " + resposta %></h3><br>
		<%= nome %>
		<h1>EU SOU UM HTML</h1>
	</body>
</html>