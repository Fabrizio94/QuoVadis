package quovadis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quovadis.model.Customer;
import quovadis.model.QuoVadis;
import quovadis.model.QuoVadisSingleton;

@WebServlet("/subscribe")
public class Subscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// gestione della RICHIESTA
	
		// leggo i parametri per controllarli
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		//controllo se i valori inseriti non sono nulli
		
		boolean ciSonoErrori= false;
		String nextPage = null;
		
		if(name.equals("")){
			ciSonoErrori = true;
			request.setAttribute("nomeError", "name required");
		}
		if(surname.equals("")){
			ciSonoErrori = true;
			request.setAttribute("surnameError", "surname required");
		}
		if(username.equals("")){
			ciSonoErrori = true;
			request.setAttribute("usernameError", "username required");
		}
		if(password1.equals("")){
			ciSonoErrori = true;
			request.setAttribute("password1Error", "password required");
		}
		if(password2.equals("")){
			ciSonoErrori = true;
			request.setAttribute("password2Error", "confirm required");
		}
		if(email.equals("")){
			ciSonoErrori = true;
			request.setAttribute("emailError", "email address required");
		}
		if(!password1.equals(password2)){
			ciSonoErrori = true;
			request.setAttribute("passwordError", "password inserted are not equal");
		}
		if(ciSonoErrori)
			nextPage = "/indexProva.jsp";
		else {
		Customer c = new Customer(name,surname,username,password1, email);		
		HttpSession session = request.getSession();
		session.setAttribute("customer", c);
		nextPage = "/confirmSubscription.jsp";
		}
		nextPage = response.encodeURL(nextPage);//se il client non acettea i cookie le nformazioni vengono appiccicate direttamnte nell'uri che stiamo sgenerando
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 

		}


	}
