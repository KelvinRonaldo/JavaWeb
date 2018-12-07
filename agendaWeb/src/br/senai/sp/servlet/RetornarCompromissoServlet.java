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
 * Servlet implementation class CancelarCompromissoServlet
 */
@WebServlet("/CancelarCompromissoServlet")
public class RetornarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RetornarCompromissoServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compromisso comp = new Compromisso();
		
		comp.setStatus(Integer.parseInt(request.getParameter("status")));
		comp.setCod_compromisso(Integer.parseInt(request.getParameter("codigo")));
		
		CompromissoDAO dao = new CompromissoDAO();
		dao.setCompromisso(comp);
		
		if(dao.alterarStatus()) {
			response.sendRedirect("compromissos.jsp?status=0");
		}else {
			response.sendRedirect("compromissos.jsp?status=0");
		}
		
		
	}

}
