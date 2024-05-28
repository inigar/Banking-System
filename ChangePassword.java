import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
public class ChangePassword extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException{
	    res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String op=req.getParameter("oldpass");
		String np=req.getParameter("newpass");
	    String cp=req.getParameter("confirmpass");
		
		try{
		    Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			Statement s=con.createStatement();
			
			if(np.equals(cp))
			{
			s.executeUpdate("update employee set password='"+np+"' where password='"+op+"'");
			RequestDispatcher disp=req.getRequestDispatcher("login.html");
			out.println("Your password updated successfully.......");
			disp.include(req,res);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"passwords do not match!!!","Alert message",JOptionPane.WARNING_MESSAGE);
				RequestDispatcher dispatcher=req.getRequestDispatcher("Changepassword.html");
				dispatcher.forward(req,res);
			}
		}
		catch(Exception e)
		{}
	}
}
	
	
	