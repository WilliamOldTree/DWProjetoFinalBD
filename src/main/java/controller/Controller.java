package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Container;
import model.User;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Container container = new Container();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String alterar = request.getParameter("alterar");

		if (id != null) {
			
			if (alterar.equals("0")) {
				deletar(request, response);
				
			} else if (alterar.equals("1")) {
				alterar(request, response);
			}
			
		}//end if

		request.setAttribute("usuarios", container.consultar());
		request.getRequestDispatcher("/").forward(request, response);
	}//end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("nome") != null && request.getParameter("email") != null
				&& request.getParameter("pais") != null) {
			String var1 = request.getParameter("nome");
			String var2 = request.getParameter("email");
			String var3 = request.getParameter("pais");
			String id = request.getParameter("id");

			if (id != null && !id.isEmpty()) {
				container.alterar(Integer.parseInt(id), var1, var2, var3);

			} else {
				User user = new User(0, var1, var2, var3);
				container.inserir(user);
				
			}
			
			request.setAttribute("usuarios", container.consultar());

		}

		request.getRequestDispatcher("/").forward(request, response);
	}//end doPost

	protected void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		container.deletar(Integer.parseInt(id));
	}// end deletar

	protected void alterar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		User user = container.consultar(Integer.parseInt(id));
		request.setAttribute("id",id);
		request.setAttribute("nome", user.getNome());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("pais", user.getPais());

	
		request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
		
	}// end alterar

}// end Controller
