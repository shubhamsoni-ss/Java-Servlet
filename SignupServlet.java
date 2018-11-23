

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

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// T;ODO Auto-generated method stub
		response.setContentType("text/html");
		String usernm=request.getParameter("n1");
		String userid=request.getParameter("n2");
		String pass=request.getParameter("n3");
		String seckey=request.getParameter("n4");
		try
		{
			PrintWriter pw=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "root", "12345");
			PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?)");
			ps.setString(1, usernm);
			ps.setString(2, userid);
			ps.setString(3, pass);
			ps.setString(4, seckey);
			int x=0;
			x=ps.executeUpdate();
			if(x!=0)
			{
				response.sendRedirect("login.html");
//				pw.println("success");
			}
			else
			{
				response.sendRedirect("error");
//				pw.println("Not succeed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
