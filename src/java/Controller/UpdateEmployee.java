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

public class UpdateEmployee extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
             String SNO=request.getParameter("sno");
            String FIRST_NAME=request.getParameter("firstname");
        String LAST_NAME=request.getParameter("lastname");
                String EMAIL=request.getParameter("email");
        String GENDER=request.getParameter("gender");
        String DOB=request.getParameter("dob");
        String CONTACT=request.getParameter("contact");
                String EMP_TYPE=request.getParameter("emptype");
        String EMP_DEPT=request.getParameter("empdept");
         String EMP_DESIGNATION=request.getParameter("empdesignation");
        String QUALIFICATION=request.getParameter("qualification");
         String BASIC_SALARY=request.getParameter("basicsalary");
          String STATUS=request.getParameter("status");
       
           
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("update create_emp set FIRST_NAME=?, LAST_NAME=?, EMAIL=?, GENDER=?, DOB=?, CONTACT=?, EMP_TYPE=?, EMP_DEPT=?, EMP_DESIGNATION=?, QUALIFICATION=?, BASIC_SALARY=? where SNO=?") ;
         
         ps.setString(1,FIRST_NAME );
         ps.setString(2, LAST_NAME);
         ps.setString(3,EMAIL );
         ps.setString(4, GENDER);
         ps.setString(5,DOB );
         ps.setString(6, CONTACT);
          ps.setString(7,EMP_TYPE );
         ps.setString(8, EMP_DEPT);
         ps.setString(9,EMP_DESIGNATION );
         ps.setString(10,QUALIFICATION);
         ps.setString(11,BASIC_SALARY);
        ps.setString(12,SNO );
      
         ps.executeUpdate();
         conn.close();
        }
        catch(Exception ex)
        {
         out.print(ex);
        }
      response.sendRedirect("UpdateEmployee.jsp");
    }


}

        
