package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeactivateEmployee extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
        String Sno=request.getParameter("SNO");
         String Status=request.getParameter("STATUS");
         
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("update create_emp set STATUS=? where SNO=?") ;
        
         ps.setInt(1,Integer.parseInt(Status));
         ps.setString(2, Sno);
        
        
         ps.executeUpdate();
         conn.close();
        out.print("done");
        }
        catch(Exception ex)
        {
         out.print(ex);
        }
        
        }
   

}