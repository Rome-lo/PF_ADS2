package web;

import dao.DAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Negocio;
import model.User;
import model.Usuario;


@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO userDAO;
	
	public void init() {
		userDAO = new DAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
                        case "/negocio":
				showForm(request, response);
				break;
                        case "/myNegocio":
				showForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
                        case "/login":
				loginUser(request, response);
				break;
                        case "/home":
				home(request, response);
				break;
			default:
				listNegocio(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listNegocio(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		/*List<Usuario> listUser = userDAO.selectAllUsuarios();
		request.setAttribute("listUser", listUser);*/
                List<Negocio> listNegocio = userDAO.selectAllNegocio();
                request.setAttribute("listNegocio", listNegocio);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
                            List<String> listaMunicipios = userDAO.selectAllDirecciones();
            request.setAttribute("listDirecciones", listaMunicipios);
		dispatcher.forward(request, response);
	}
        
        private void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("idnegocio"));
            Negocio negocio = userDAO.selectNegocio(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("negocio-form.jsp");
            request.setAttribute("negocio", negocio);
            /*List<String> listaMunicipios = userDAO.selectAllDirecciones();
            request.setAttribute("listDirecciones", listaMunicipios);*/
            dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idusuario"));
		Usuario existingUser = userDAO.selectUsuario(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String nickname = request.getParameter("nickname");
                String password = request.getParameter("password");
                String id_dir = request.getParameter("id_dir");
		Usuario newUser = new Usuario(nombre, apellido, nickname, password, Integer.parseInt(id_dir));
		userDAO.insertUsuario(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("idusuario"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String nickname = request.getParameter("nickname");
                String password = request.getParameter("password");
                String id_dir = request.getParameter("id_dir");

		Usuario book = new Usuario(id, nombre, apellido, nickname, password, Integer.parseInt(id_dir));
		userDAO.updateUsuario(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("idusuario"));
		userDAO.deleteUsuario(id);
		response.sendRedirect("list");

	}
        
        private void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		/*List<Usuario> listUser = userDAO.selectAllUsuarios();
		request.setAttribute("listUser", listUser);*/
                /*List<Negocio> listNegocio = userDAO.selectAllNegocio();
                request.setAttribute("listNegocio", listNegocio);*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_login.jsp");
		dispatcher.forward(request, response);
	}
        
        private void home(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		/*List<Usuario> listUser = userDAO.selectAllUsuarios();
		request.setAttribute("listUser", listUser);*/
                /*List<Negocio> listNegocio = userDAO.selectAllNegocio();
                request.setAttribute("listNegocio", listNegocio);*/
                String nickname = request.getParameter("nickname");
                String password = request.getParameter("password");
                System.out.println(nickname + " - " + password);
                int id_dir = userDAO.comprobarUsuario(nickname, password);
                if(id_dir>0){
                    List<Negocio> listNegocio = userDAO.selectNegocioByDir(id_dir);
                    request.setAttribute("listNegocio", listNegocio);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("user_home.jsp");
                    dispatcher.forward(request, response);
                }else{
                    RequestDispatcher dispatcher = request.getRequestDispatcher("user_login.jsp");
                    dispatcher.forward(request, response);
                }
		
	}

}
