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

@WebServlet("/confirm")
public class SubscriptionConfirm extends HttpServlet {
		private static final long serialVersionUID = 1L;	       
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
			// gestione della RISPOSTA
			// preparo il tipo (HTML)
			QuoVadis quovadis = QuoVadisSingleton.getInstance();
			String nextPage = null;
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			Customer c = (Customer)session.getAttribute("customer");
			if(!quovadis.subscribe(c))
				request.setAttribute("SubscriptionError", "there is another user with the same credentials");
			nextPage= response.encodeURL("/indexProva.jsp");
			
			ServletContext application = getServletContext();
			RequestDispatcher rd = application.getRequestDispatcher(nextPage);
			rd.forward(request, response);
			

		    	
		}

}
