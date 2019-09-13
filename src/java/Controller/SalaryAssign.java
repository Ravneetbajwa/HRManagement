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

public class SalaryAssign extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String SNO=request.getParameter("sno");
         String EMP_ID=request.getParameter("EMP_ID");
        String salaryname=request.getParameter("salaryname");
          String salarytype=request.getParameter("salarytype");
        String salaryamt=request.getParameter("salaryamt");
         
         
           
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("insert into assign_salary values(?,?,?,?,?,?)") ;
         ps.setString(1, SNO);
          ps.setString(2, EMP_ID);
         ps.setString(3, salaryname);
         ps.setString(4, salarytype);
         ps.setString(5, salaryamt);
          ps.setInt(6,1);
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
