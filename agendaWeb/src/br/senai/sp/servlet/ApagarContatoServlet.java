package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.ContatoDAO;
import br.senai.sp.model.Contato;

/**
 * Servlet implementation class ApagarContatoServlet
 */
@WebServlet("/ApagarContatoServlet")
public class ApagarContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApagarContatoServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Contato contato = new Contato();
		contato.setCodigo(codigo);		
		
		ContatoDAO dao = new ContatoDAO();
		dao.setContato(contato);
		
		if(dao.apagar()) {
			response.sendRedirect("contatos.jsp");
		}else {
			response.sendRedirect("apagar-contato.jsp");
		}
	}

}
