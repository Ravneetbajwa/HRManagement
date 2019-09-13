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

public class SalaryMaster extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
              String SNO=request.getParameter("sno");
         String EMP_TYPE=request.getParameter("emptype");
        String TOTAL_LEAVES=request.getParameter("leavestaken");
        String LEAVES_ALLOWED=request.getParameter("leavesallowed");
         String STATUS=request.getParameter("status");
         
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("insert into salary_master values(?,?,?,?,?)") ;
         ps.setString(1, SNO);
          ps.setString(2, EMP_TYPE);
         ps.setString(3, TOTAL_LEAVES);
         ps.setString(4, LEAVES_ALLOWED);
          ps.setInt(5,1);
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
