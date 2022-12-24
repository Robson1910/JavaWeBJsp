package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuditoriaDAO;
import model.EntitiesAuditoria;
import model.EntitiesLogin;
import model.EntitiesUsuario;
import model.LoginDAO;
import model.UsuarioDAO;
import utilities.Evento;
import utilities.GerarPdf;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/home", "/insert", "/main", "/deletar", "/atualizar", "/update", "/pdf" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The conectar login. */
	LoginDAO conectarLogin = new LoginDAO();
	
	/** The login. */
	EntitiesLogin login = new EntitiesLogin();
	
	/** The usuario. */
	EntitiesUsuario usuario = new EntitiesUsuario();
	
	/** The usuario DAO. */
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	/** The auditoria DAO. */
	AuditoriaDAO auditoriaDAO = new AuditoriaDAO();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();

	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getServletPath()) {
		case "/home":
			doLogin(request, response);
			break;
		case "/main":
			doHome(request, response);
			break;
		case "/insert":
			doPost(request, response);
			break;
		case "/deletar":
			DoDeleta(request, response);
			break;
		case "/atualizar":
			DoSeleciona(request, response);
			break;
		case "/update":
			DoEdita(request, response);
			break;
		case "/pdf":
			DoPdf(request, response);
			break;
		default:
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Do login.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		login.setUsuario(request.getParameter("usuario"));
		login.setSenha(request.getParameter("senha"));

		if (conectarLogin.login(login)) {
			request.setAttribute("logar", login.getUsuario());
			RequestDispatcher rd = request.getRequestDispatcher("validarAcesso.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("error.html");
		}
	}

	/**
	 * Do home.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<EntitiesUsuario> lista = usuarioDAO.ListaUsuario();

		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);

	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		usuario.setNome(request.getParameter("nome"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setEmail(request.getParameter("email"));
		usuarioDAO.insert(usuario);

		EntitiesAuditoria auditoria = new EntitiesAuditoria(Evento.CREATE, usuario, login.getLoginId());
		auditoriaDAO.insert(auditoria);

		response.sendRedirect("main");
	}

	/**
	 * Do seleciona.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void DoSeleciona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		usuario.setUsuarioId(request.getParameter("usuarioId"));
		usuarioDAO.selecionarContato(usuario);

		request.setAttribute("usuarioId", usuario.getUsuarioId());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("cpf", usuario.getCpf());
		request.setAttribute("telefone", usuario.getTelefone());
		request.setAttribute("email", usuario.getEmail());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * Do edita.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void DoEdita(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		usuario.setNome(request.getParameter("usuarioId"));
		usuario.setNome(request.getParameter("nome"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setTelefone(request.getParameter("telefone"));
		usuario.setEmail(request.getParameter("email"));
		usuarioDAO.editarContato(usuario);

		usuarioDAO.selecionarContato(usuario);
		EntitiesAuditoria auditoria = new EntitiesAuditoria(Evento.UPDATE, usuario, login.getLoginId());
		auditoriaDAO.insert(auditoria);

		response.sendRedirect("main");
	}

	/**
	 * Do deleta.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void DoDeleta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		usuario.setUsuarioId(request.getParameter("usuarioId"));

		usuarioDAO.selecionarContato(usuario);

		usuarioDAO.deleteUsuario(usuario);

		EntitiesAuditoria auditoria = new EntitiesAuditoria(Evento.DELETE, usuario, login.getLoginId());
		auditoriaDAO.insert(auditoria);

		response.sendRedirect("main");
	}
	
	/**
	 * Do pdf.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void DoPdf(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<EntitiesUsuario> lista = usuarioDAO.ListaUsuario();
		GerarPdf.pdf(lista, response);
		response.sendRedirect("main");
	}
}
