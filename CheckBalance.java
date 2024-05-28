import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
public class CheckBalance extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String accountno=req.getParameter("accountno");
		ss
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select balance from accountdata where accountno='"+accountno+"'");
			while(rs.next())
			{
				out.println(rs.getString(1)+"Rs.");
			}
			RequestDispatcher disp=req.getRequestDispatcher("AfterLogin.html");
			disp.include(req,res);
		}
		catch(Exception e)
		{}
	}
}
		
