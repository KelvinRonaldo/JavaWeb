package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.UsuarioDAO;
import br.senai.sp.model.Usuario;

/**
 * Servlet implementation class AtualizarUsuarioServlet
 */
@WebServlet("/AtualizarUsuarioServlet")
public class AtualizarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AtualizarUsuarioServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario = (Usuario)  (request.getSession().getAttribute("usuario"));
		usuario.setNome(request.getParameter("txt-nome"));
		usuario.setEmail(request.getParameter("txt-email"));
		usuario.setDtNascimento(request.getParameter("txt-nascimento"));
		usuario.setSexo(request.getParameter("cb-sexo").substring(0, 1));
		usuario.setSenha(request.getParameter("txt-senha1"));
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.setUsuario(usuario);
		
		
		if(dao.atualizar()) {
			response.sendRedirect("sucesso-atualizar.jsp");
		}else {
			response.sendRedirect("atualizar-usuario.jsp");
		}
	}

}
