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
 * Servlet implementation class AtualizarContatoServlet
 */
@WebServlet("/AtualizarContatoServlet")
public class AtualizarContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AtualizarContatoServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contato contato = new Contato();
		contato.setCodigo(Integer.parseInt(request.getParameter("txt-codigo")));
		contato.setNome(request.getParameter("txt-nome"));
		contato.setEmail(request.getParameter("txt-email"));
		contato.setTelefone(request.getParameter("txt-telefone"));
		

		ContatoDAO dao = new ContatoDAO();
		dao.setContato(contato);
		
		if(dao.atualizar()) {
			response.sendRedirect("contatos.jsp");
		}else {
			response.sendRedirect("consultar-contato.jsp");
		}
		
	}

}
