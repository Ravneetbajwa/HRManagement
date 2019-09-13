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

public class ManageQualification extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            String Qualification=request.getParameter("qualification");
        String Sno=request.getParameter("sno");
       // out.print(Sno);
      //  out.print(Qualification);
        
        
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("insert into manage_qualification values(?,?,?) ") ;
         ps.setString(1,Sno);
         ps.setString(2, Qualification);
        ps.setInt(3,1);
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
