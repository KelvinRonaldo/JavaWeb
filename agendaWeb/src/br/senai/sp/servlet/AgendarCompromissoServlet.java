package br.senai.sp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.CompromissoDAO;
import br.senai.sp.model.Compromisso;
import br.senai.sp.model.Usuario;

/**
 * Servlet implementation class AgendarCompromissoServlet
 */
@WebServlet("/AgendarCompromissoServlet")
public class AgendarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AgendarCompromissoServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		u = (Usuario)request.getSession().getAttribute("usuario");
		
		Compromisso compromisso = new Compromisso();
		compromisso.setTitulo(request.getParameter("txt-titulo"));
		compromisso.setData(request.getParameter("txt-data"));
		compromisso.setDescricao(request.getParameter("txt-descricao"));
		compromisso.setHora_fim(request.getParameter("txt-hora-fim"));
		compromisso.setHora_inicio(request.getParameter("txt-hora-inicio"));
		compromisso.setPrioridade(Integer.parseInt(request.getParameter("cb-prioridade")));
		compromisso.setStatus(Integer.parseInt(request.getParameter("cb-status")));
		compromisso.setUsuario(u);
		
		CompromissoDAO dao = new CompromissoDAO();
		dao.setCompromisso(compromisso);
		
		if(dao.gravar()) {
			response.sendRedirect("compromissos.jsp");
		}else {
			response.sendRedirect("novo-compromisso.jsp");
		}
	}

}
