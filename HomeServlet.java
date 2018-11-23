

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
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession hs=request.getSession(true);
//		hs.setAttribute("key1", userid);
//		hs.setMaxInactiveInterval(20);
//		String userid=(String)hs.getAttribute("key1");
		if(hs.getAttribute("key1")!=null)
		{
			String userid=(String)hs.getAttribute("key1");
		try
		{
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "root", "12345");
			PreparedStatement ps=con.prepareStatement("select Username from user where userId=?");
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				String usernm=rs.getString(1);
				out.println("<p> Hi, "+usernm);
				out.println("<h1 style=\"text-align:center;font-size:30px;font-family:Script MT;\">"+"Welcome to Home Page"+"</h1>");
				out.println("<p style=\"text-align:right;\">"+"<a href=\"delete\">"+"Delete Account"+"</a>"+"<a href=\"logout\">"+"Logout"+"</a></p><hr>");
				out.println("<h2 style=\"text-align:center;font-size:20px;font-family:harrington;border:3px solid black;\">"+"Shop24.com provides you the better choice of online shopping sites for MENTIONED PRODUCTS"+"</h2>");
				out.println("<p align=\"center\">"+"Products available for Comparing :"+"<hr>");
				out.println("<img style=\"border:3px solid black;\" src=\"adi_hoddie.jpg\" title=\"Adidas Hoddie\">");
				out.println("<img style=\"border:3px solid black;\" src=\"mi_band.jpg\" title=\"MI Band\">");
				out.println("<img style=\"border:3px solid black;\" src=\"chair.jpg\" title=\"Cello Chair\">");
				out.println("<img style=\"border:3px solid black;\" src=\"lenovo_g50.jpg\" title=\"Lenoco G50\">");
				out.println("<img style=\"border:3px solid black;\" src=\"note9.jpg\" title=\"Samsung Galaxy Note9\">");
				out.println("</p>");
				out.println("<form action=\"show\">");
				out.println("<table align=\"center\"");
				out.println("<tr>");
				out.println("<th colspan=\"2\">");
				out.println("Select any One product:");
				out.println("</th>");
				out.println("<td style=\"text-align:center;\">");
				out.println("Choose Product Name:");
				out.println("</td>");
				out.println("<td style=\"text-align:center;\">");
				out.println("<select name=\"n1\"");
				out.println("<option value=\"\">"+"---"+"</option>");
				out.println("<option>"+"fit_Bit"+"</option>");
				out.println("<option>"+"Note 9"+"</option>");
				out.println("<option>"+"chair"+"</option>");
				out.println("<option>"+"Lenovo G50"+"</option>");
				out.println("<option>"+"Hoodie"+"</option>");
				out.println("</select>");
				out.println("</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td style=\"text-align:center;\">");
				out.println("<input type=\"submit\" name=\"Submit\"");
				out.println("</td>");
				out.println("<td style=\"text-align:center;\">");
				out.println("<input type=\"reset\" name=\"Reset\"");
				out.println("</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</form>");
			}
			else
			{
				out.println("can.t show your username");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}

}
