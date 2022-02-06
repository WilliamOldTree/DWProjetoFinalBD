package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import model.Container;
import model.User;
import persitences.UserDAO;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static UserDAO ud;

	public Controller() throws ClassNotFoundException, SQLException {
		super();
		this.ud = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String alterar = request.getParameter("alterar");

		if (id != null) {

			if (alterar.equals("0")) {
				try {
					deletar(request, response);
				} catch (ServletException | IOException | SQLException e) {

					e.printStackTrace();
				}

			} else if (alterar.equals("1")) {
				try {
					alterar(request, response);
				} catch (ServletException | IOException | SQLException e) {

					e.printStackTrace();
				}
			}

		} // end if

		try {
			request.setAttribute("usuarios", ud.searchUsers());
		} catch (SQLException e) {

			e.printStackTrace();
		}
		request.getRequestDispatcher("/").forward(request, response);
	}// end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("nome") != null && request.getParameter("email") != null
				&& request.getParameter("pais") != null) {
			String var1 = request.getParameter("nome");
			String var2 = request.getParameter("email");
			String var3 = request.getParameter("pais");
			String id = request.getParameter("id");

			if (id != null && !id.isEmpty()) {
				try {
					ud.updateUser(null);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			} else {
				User user = new User(0, var1, var2, var3);
				try {
					ud.insertUser(user);
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}

			try {
				request.setAttribute("usuarios", ud.searchUsers());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		request.getRequestDispatcher("/").forward(request, response);
	}// end doPost

	protected void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		User user = new User();
		user.setId(Integer.parseInt(id));
		ud.deleteUser(user);
	}// end deletar

	protected void alterar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		User user = new User();
		user.setId(Integer.parseInt(id));
		user = ud.searchUser(user);
		request.setAttribute("id", id);
		request.setAttribute("nome", user.getNome());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("pais", user.getPais());

		request.getRequestDispatcher("/cadastro.jsp").forward(request, response);

	}// end alterar

}// end Controller
