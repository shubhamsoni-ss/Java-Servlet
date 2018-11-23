

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
//		out
		pw.println("<title>Empty list</title>");
		pw.println("<h1 style=\"text-align:center;\"><img src=\"empty1.png\" width=\"50%\"></h1>");
//		pw.println("<h1 style="+"font-family:consolas;"+">"+"<a href=signup.html>Go back to signup page</a>"+"</h1>");
	}

}
