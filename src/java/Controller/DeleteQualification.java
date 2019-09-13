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

public class DeleteQualification extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
          String QUALIFICATION=request.getParameter("qualification");
        String SNO=request.getParameter("sno");
         String STATUS=request.getParameter("status");
    // out.print(SNO);
     //out.print(STATUS);
     //out.print(QUALIFICATION);
         
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("delete from manage_qualification where SNO=?") ;
         ps.setString(1, SNO);
        // ps.setString(2, QUALIFICATION);
        // ps.setString(3, STATUS);
        
         ps.executeUpdate();
         conn.close();
        }
        catch(Exception ex)
        {
         out.print(ex);
        }
      response.sendRedirect("ManageQualification.jsp");
        }
        
    


}
  
        
