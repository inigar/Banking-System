import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.Random;
public class UpdateAccounData extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String user=req.getParameter("user");
	    String field=req.getParameter("txtname");
		String newvalue=req.getParameter("newvalue");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			Statement s=con.createStatement();
			s.executeQuery("update accountdata set "+field+"='"+newvalue+"' where name='"+user+"'");
			RequestDispatcher disp=req.getRequestDispatcher("userdata");
			disp.include(req,res);
			out.println("record updated<br><br>");
		}
		catch(Exception e)
		{}
	}
}