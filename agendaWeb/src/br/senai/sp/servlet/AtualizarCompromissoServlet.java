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
 * Servlet implementation class AtualizarCompromissoServlet
 */
@WebServlet("/AtualizarCompromissoServlet")
public class AtualizarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AtualizarCompromissoServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compromisso comp = new Compromisso();		
		
		comp.setCod_compromisso(Integer.parseInt(request.getParameter("txt-codigo")));
		comp.setTitulo(request.getParameter("txt-titulo"));
		comp.setData(request.getParameter("txt-data"));
		comp.setDescricao(request.getParameter("txt-descricao"));
		comp.setHora_fim(request.getParameter("txt-hora-fim"));
		comp.setHora_inicio(request.getParameter("txt-hora-inicio"));
		comp.setPrioridade(Integer.parseInt(request.getParameter("cb-prioridade")));
		comp.setStatus(Integer.parseInt(request.getParameter("cb-status")));

		CompromissoDAO dao = new CompromissoDAO();
		dao.setCompromisso(comp);
		
		if(dao.atualizar()) {
			response.sendRedirect("compromissos.jsp");
		}else {
			response.sendRedirect("atualizar-compromisso.jsp");
		}
		

	}

}
