

import java.io.IOException;
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
 * Servlet implementation class RemwishServlet
 */
@WebServlet("/rws")
public class RemwishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String modelnm=request.getParameter("n1");
		String modelno=request.getParameter("n2");
		HttpSession hs=request.getSession();
		if(hs.getAttribute("key1")!=null)
		{
			String userid=(String)hs.getAttribute("key1");
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wishlist", "root", "12345");
				String str="delete from wishlist where userid=?";
				PreparedStatement ps=con.prepareStatement(str);
				ps.setString(1, userid);
				int x=0;
				x=ps.executeUpdate();
				if(x!=0)
				{
					response.sendRedirect("welcome.html");
				}
				else
				{
					response.sendRedirect("welcome.html");
				}
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
