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

public class UpdateSalaryMaster extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
         String EmpType=request.getParameter("emptype");
        String Sno=request.getParameter("sno");
        String TotalLeaves=request.getParameter("totalleaves");
        String LeavesTaken=request.getParameter("leavesallowed");
//         out.print(Sno);
//          out.print(EmpType);
//          out.print(TotalLeaves);
//          out.print(LeavesTaken);
         
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
            PreparedStatement ps = conn.prepareStatement("update salary_master set EMP_TYPE=?, TOTAL_LEAVES=?, LEAVES_ALLOWED=? where SNO=?") ;
        
         ps.setString(1, EmpType);
          ps.setString(2, TotalLeaves);
          ps.setString(3, LeavesTaken);
         ps.setString(4, Sno);
        
          
         ps.executeUpdate();
         conn.close();
        }
        catch(Exception ex)
        {
         out.print(ex);
        }
        response.sendRedirect("Salary.jsp");
        }
   

}
