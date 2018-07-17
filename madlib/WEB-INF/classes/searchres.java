import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.util.*;  
import java.sql.*;
public class searchres extends HttpServlet { 
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 { 
	final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	final String DB_URL="jdbc:mysql://localhost:3306/test";
 	final String USER="root";
	final String PASS="";
	Connection conn=null;
	Statement stmt=null;
	response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	try{
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection(DB_URL,USER,PASS);
	stmt = conn.createStatement();

       String b_title = request.getParameter("sname");
	String cat=request.getParameter("catogory");
int id=0;
out.print("<html>");
out.print("<body style='background-color:lightblue;'>");
PreparedStatement pst = conn.prepareStatement("Select * from books where b_title=? and cat=?");
pst.setString(1, b_title);
            pst.setString(2, cat);

 ResultSet rs = pst.executeQuery();
while(rs.next())
{
String title=rs.getString(1);
id=rs.getInt(3);

}
		int ch=id;
		switch(ch)
{
case 100:
out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='ponni.html'>ponniyin selvan</a>");
out.print("</br>");
out.print("<img src='51ZFCmpRd4L._SY346_.jpg' width='200' height='200'>");  
break;
case 101:
out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='zero.html'>zerodegree</a>");
out.print("</br>");
out.print("<img src='3431810.jpg' width='100' height='100'>");  
  break;
case 102:
out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='batman.html'>batman</a>");
out.print("</br>");
out.print("<img src='download.jpg' width='100' height='100'>");  
  break;
case 103:
out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='x-men.html'>x-men</a>");
out.print("</br>");
out.print("<img src='2.jpg' width='100' height='100'>");  
break;
case 104:
out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='battle.html'>battle cry of freedom</a>");
out.print("</br>");
out.print("<img src='4.jpg' width='100' height='100'>");  
  break;
case 105:
out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='august.html'>guns og august</a>"); 
out.print("</br>");
out.print("<img src='3.jpg' width='100' height='100'>");  
 break;
case 106:
out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='stephen.html'>stephen king</a>");  
out.print("</br>");
out.print("<img src='5.jpg' width='100' height='100'>");  
break;
case 107:
out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='jackson.html'>jackson the haunting of hill house</a>"); 
out.print("</br>");
out.print("<img src='6.jpg' width='100' height='100'>");  
 break;
case 108:
out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='train.html'>the girl of the train</a>"); 
out.print("</br>");
out.print("<img src='7.jpg' width='100' height='100'>");  
 break;
case 109:out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='code.html'>davinci code</a>");  out.print("</br>");
out.print("<img src='8.jpg' width='100' height='100'>");  
break;
case 110:
out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='zero.html'>zero degree</a>"); 
out.print("</br>");
out.print("<img src='9.jpg' width='100' height='100'>");  
 break;
case 111:
out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='god.html'>the god of small thing</a>"); 
out.print("</br>");
out.print("<img src='10.jpg' width='100' height='100'>");  
 break;
case 112:out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='mistry.html'>A fine balance</a>");  
out.print("</br>");
out.print("<img src='11.jpg' width='100' height='100'>");  
break;
case 113:out.print("<h1>Oh Great! Book is available.</h1>");
out.print("<a href='immortal.html'>immortals of mehula</a>"); 
out.print("</br>");
out.print("<img src='12.jpg' width='100' height='100'>");  
 break;
default:
out.println("sorry book not found");
break;
} 

out.print("</body>");
out.print("</html>");
         
         rs.close();
         stmt.close();
         conn.close();
      } 
	catch(SQLException se) {
         //Handle errors for JDBC
         se.printStackTrace();
      } catch(Exception e) {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally {

         //finally block used to close resources
         try {
            if(stmt!=null)
               stmt.close();
         } catch(SQLException se2) {
         } // nothing we can do
         try {
            if(conn!=null)
            conn.close();
         } catch(SQLException se) {
            se.printStackTrace();
         } //end finally try
      } //end try
   }
} 
