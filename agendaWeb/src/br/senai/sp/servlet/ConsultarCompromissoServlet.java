package br.senai.sp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.CompromissoDAO;
import br.senai.sp.model.Compromisso;

/**
 * Servlet implementation class ConsultarCompromissoServlet
 */
@WebServlet("/ConsultarCompromissoServlet")
public class ConsultarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConsultarCompromissoServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Compromisso comp = new Compromisso();
		CompromissoDAO dao = new CompromissoDAO();
		
		comp = dao.getCompromisso(codigo);
		request.getSession().setAttribute("compromisso", comp);
		response.sendRedirect("atualizar-compromisso.jsp");
	}

}
