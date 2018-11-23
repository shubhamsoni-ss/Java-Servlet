

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logoutServlet
 */
@WebServlet("/logout")
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession hs=request.getSession();
		if(hs.getAttribute("key1")!=null)
		{
			String userid=(String)hs.getAttribute("key1");
			try
			{
/*				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wishlist", "root", "12345");
				String str="delete from wishlist where userid=?";
				PreparedStatement ps=con.prepareStatement(str);	
				ps.setString(1, userid);
				int x=0;
				x=ps.executeUpdate();*/
				hs.invalidate();
				response.sendRedirect("login.html");
//				out.println("<hr><h1 style=\"text-align:center;\">"+"You are Successfully logged out"+"</h1>");
//				out.println("<a href=\"login.html\" title=\"Click to go on Login page\">"+"Go back to Login page"+"</a>");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			response.sendRedirect("welcome.html");
		}
	}

}
