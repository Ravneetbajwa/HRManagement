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

public class UpdateEmpType extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            
        String EmployeeType=request.getParameter("emptype");
        String Sno=request.getParameter("sno");
        
         
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("update manage_emptype set EMP_TYPE=? where SNO=?") ;
        
         ps.setString(1, EmployeeType);
         ps.setString(2, Sno);
        
         ps.executeUpdate();
         conn.close();
        }
        catch(Exception ex)
        {
         out.print(ex);
        }
        response.sendRedirect("ManageEmployeeType.jsp");
        }
   

}

