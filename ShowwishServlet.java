

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowwishServlet
 */
@WebServlet("/sws")
public class ShowwishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs=request.getSession();
		if(hs.getAttribute("key1")!=null)
		{
			String userid=(String)hs.getAttribute("key1");
			try
			{
				String s1,s2;
				PrintWriter out=response.getWriter();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wishlist", "root", "12345");
				PreparedStatement ps=con.prepareStatement("select* from wishlist where userid=?");
				ps.setString(1, userid);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
				out.println("<title>WishList</title>");
				out.println("<body bgcolor=\"#ffe0bd\">");
				out.println("<h1 style=\"text-align:center;font-family:harrington;font-size:50px;\">WishList</h1><hr>");
				out.println("<table align=\"center\" border=\"l\">");
				out.println("<tr>");
				out.println("<th style=\"font-size:40px;\">..</th>");
				out.println("<th style=\"font-size:40px;\">modelname</th>");
				out.println("<th style=\"font-size:40px;\">modelno</th>");
				out.println("</tr>");
					do
					{
						s1=rs.getString(2);
						s2=rs.getString(3);
						out.println("<tr>");
						out.println("<td style=\"font-size:30px;background-color:#708090;\">");
						out.println("->");
						out.println("</td>");
						out.println("<td style=\"font-size:30px;\">");
						out.println(s1);
						out.println("</td>");
						out.println("<td style=\"font-size:30px;\">");
						out.println(s2);
						out.println("</td>");
						out.println("</tr>");
					}while(rs.next());
					out.println("</body>");
					out.println("</table");
				}
				else
				{
					response.sendRedirect("error");
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
