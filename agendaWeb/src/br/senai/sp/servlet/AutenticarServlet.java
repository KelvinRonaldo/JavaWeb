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
 * Servlet implementation class AutenticarServlet
 */
@WebServlet("/AutenticarServlet")
public class AutenticarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AutenticarServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario = dao.autenticar(request.getParameter("txt-email"), request.getParameter("txt-senha"));
		if(usuario.getCodUsuario() > 0) {
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("login.html");
		}
	}

}
