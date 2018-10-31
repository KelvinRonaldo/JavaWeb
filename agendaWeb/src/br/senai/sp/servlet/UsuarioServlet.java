package br.senai.sp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("txt-nome");
		System.out.println(request.getParameter("txt-email"));
		
		
		/*
		response.getWriter().write(""
				+ "<html>"
				+ "	<head>"
				+ "		<title>"
				+ "			RESPOSTA"
				+ "		</title>"
				+ "	</head>"
				+ "	<body>"
				+ "	</body>"
				+ "		<h1>HELLO WORLD</h1>"
				+ "		<h4> Nome:" + nome + "</h4>"
				+ "</html>");
		/*response.sendRedirect("xpto.html");
		*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
