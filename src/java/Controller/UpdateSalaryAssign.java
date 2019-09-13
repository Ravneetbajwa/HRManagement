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

public class UpdateSalaryAssign extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
             String EmpType=request.getParameter("emptype");
        String Sno=request.getParameter("sno");
        String AllowanceId=request.getParameter("allowanceid");
         String AllowanceType=request.getParameter("allowancetype");
          String AllowanceAmt=request.getParameter("allowanceamt");
         
         
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("update assign_salary set EMP_TYPE=?,  ALLOWENCE_TYPE=?, ALLOWENCE_AMT=? where SNO=?") ;
        
         ps.setString(1, EmpType);
//         ps.setString(2, AllowanceId);
         ps.setString(2, AllowanceType);
         ps.setString(3, AllowanceAmt);
         ps.setString(4, Sno);
        
         ps.executeUpdate();
         conn.close();
        }
        catch(Exception ex)
        {
         out.print(ex);
        }
        response.sendRedirect("SalaryAssign.jsp");
        }
   

}
