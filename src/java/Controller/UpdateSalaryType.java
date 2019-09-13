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

public class UpdateSalaryType extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
   
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                String SalaryName=request.getParameter("salaryname");
        String Sno=request.getParameter("sno");
        String SalaryType=request.getParameter("salarytype");
         
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("update salary_type set SALARY_NAME=?, SALARY_TYPE=? where SNO=?") ;
        
         ps.setString(1, SalaryName);
         ps.setString(2, SalaryType);
         ps.setString(3, Sno);
        
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
