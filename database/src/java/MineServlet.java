
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class MineServlet extends HttpServlet
{
	String empCode,empName;
	String b1,b2,b3;
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException
	{
		b1 = req.getParameter("add");
		b2 = req.getParameter("search");
		b3 = req.getParameter("delete");
		try
		{
			if(b1!=null)
			{
                                System.out.println("hello");
				empCode = req.getParameter("txtCode");
				empName = req.getParameter("txtName");
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527//sample","app","app");
				PreparedStatement stat = con.prepareStatement("Insert into test values(?,?)");
				stat.setString(1,empCode);
				stat.setString(2,empName);
				stat.executeUpdate();
				PrintWriter out = res.getWriter();
				out.println("<html><body bgcolor = #408080><br><br><br><br><br><center>");
				out.println("<font size = 4 face = arial color = purple><b><u><i>YOU ARE MOST WELCOME Mr./Mrs.</i></u></b></font>&nbsp;");
				out.println("<font size = 5 face = arial color = RED><b><u><I>"+empName+"</i></u></b></font>");
				out.println("<BR>");
				out.println("<font size = 10 face = arial color = purple><b><u>Your DATA is successfully added</u></b></font>");
				out.println("<br>");
				out.println("<font size = 4 face = arial color = purple><b><u><i>THANK YOU FOR REGISTRY</i></u></b></font>");
				out.println("</CENTER></body></html>");
				out.close();
			}			
			if(b2!=null)
			{			
				String search;				
				search = req.getParameter("txtCode");		
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527//sample","app","app");
				PreparedStatement stat = con.prepareStatement("select * from test where empCode = ?");
				stat.setString(1,search);
				ResultSet res1 = stat.executeQuery();
				PrintWriter out = res.getWriter();
				out.println("<html><body bgcolor = #408080><CENTER><table border = 6 bordercolor = blue>");
				while(res1.next())
				{
					empCode = res1.getString(1);
					empName = res1.getString(2);
					out.println("<tr>");
					out.println("<td><B>"+empCode+"</B></td>");
					out.println("<td><B>"+empName+"</B></td>");
					out.println("</tr>");
					out.close();
					out.println("</table></CENTER></body></html>");
				}
			}
			if(b3!=null)
			{				
				String del;				
				del = req.getParameter("txtName");			
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527//sample","app","app");
				PreparedStatement stat = con.prepareStatement("delete from test where empCode = ?");
				stat.setString(1,del);
				stat.executeUpdate();
				PrintWriter out = res.getWriter();
				out.println("<html><body bgcolor = #408080>");
				out.println("<font size = 4 face = arial color = purple><b><u><i>Good Bye Mr./Mrs.</i></u></b></font>&nbsp;");
				out.println("<font size = 5 face = arial color = RED><b><u><I>"+del+"</i></u></b></font>");
				out.println("<BR>");			
				out.println("<font size = 10 face = arial color = purple><b><u>Your DATA is successfully deleted..</u></b></font>");
				out.close();	
				out.println("</body></html>");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	}
}