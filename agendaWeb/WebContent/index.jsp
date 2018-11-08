<%@page import="java.util.Date"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.lang.model.util.SimpleAnnotationValueVisitor6"%>
<%@page import="br.senai.sp.model.Usuario"%>
<!-- 
↓------↓ Diretiva  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	Usuario usuario = new Usuario();
	
	
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h2><%= usuario.getNome() %></h2><br>
		<%= usuario.getDtNascimento() %><br>
		<%= usuario.getSexo() %><br>
		<%= usuario.getEmail() %><br>
		<%= usuario.getSenha() %><br>
	</body>
</html>




