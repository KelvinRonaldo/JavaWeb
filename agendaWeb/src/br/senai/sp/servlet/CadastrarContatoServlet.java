package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.ContatoDAO;
import br.senai.sp.model.Contato;
import br.senai.sp.model.Usuario;

/**
 * Servlet implementation class CadastrarContatoServlet
 */
@WebServlet("/CadastrarContatoServlet")
public class CadastrarContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarContatoServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contato contato = new Contato();
		
		Usuario u = new Usuario();
		u = (Usuario)request.getSession().getAttribute("usuario");
		
		contato.setNome(request.getParameter("txt-nome"));
		contato.setEmail(request.getParameter("txt-email"));
		contato.setTelefone(request.getParameter("txt-telefone"));
		contato.setUsuario(u);
		
		ContatoDAO dao = new ContatoDAO();
		dao.setContato(contato);
		if(dao.gravar()) {
			response.sendRedirect("contatos.jsp");
		}else {
			response.sendRedirect("cadastrar-contato.jsp");
		}
	}

}
