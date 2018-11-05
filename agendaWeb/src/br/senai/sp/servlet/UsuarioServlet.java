package br.senai.sp.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.Conexao;
import br.senai.sp.dao.UsuarioDAO;
import br.senai.sp.model.Usuario;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("txt-nome");
		System.out.println(request.getParameter("txt-email"));
		
		
		//↓ mostrar resposta na tela para o usuario
		response.getWriter().write(
				  "<html>"
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
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("txt-nome"));
		usuario.setDtNascimento(request.getParameter("txt-nascimento"));
		usuario.setSexo(request.getParameter("cb-sexo"));
		usuario.setEmail(request.getParameter("txt-email"));
		usuario.setSenha(request.getParameter("txt-senha1"));
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.setUsuario(usuario);
		if(dao.gravar()){
			response.sendRedirect("sucesso.html");
		}else {
			response.sendRedirect("novo-usuario.html");
		}
		
		Conexao.getConexao();
	}

}
