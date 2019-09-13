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

public class SalaryType extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            String SNO=request.getParameter("sno");
         String SALARY_NAME=request.getParameter("salaryname");
        String SALARY_TYPE=request.getParameter("salarytype");
        String STATUS=request.getParameter("status");
        
           
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("insert into salary_type values(?,?,?,?)") ;
         ps.setString(1, SNO);
          ps.setString(2, SALARY_NAME);
         ps.setString(3, SALARY_TYPE);
         ps.setInt(4,1);
         ps.executeUpdate();
         conn.close();
        }
        catch(Exception ex)
        {
          out.print(ex);
        }
        response.sendRedirect("SalaryType.jsp");
    }
}
