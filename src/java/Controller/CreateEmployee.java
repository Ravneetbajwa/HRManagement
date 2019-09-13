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

public class CreateEmployee extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
             String SNO=request.getParameter("sno");
             String PASSWORD=request.getParameter("password");
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
        // out.print(GENDER);
        GetSno gs = new GetSno();
           
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("insert into create_emp values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ") ;
         ps.setInt(1,gs.getEmployeeId());
         ps.setString(2,FIRST_NAME );
         ps.setString(3, LAST_NAME);
         ps.setString(4,EMAIL );
          ps.setString(5, PASSWORD);
         ps.setString(6, GENDER);
         ps.setString(7,DOB );
         ps.setString(8, CONTACT);
          ps.setString(9,EMP_TYPE );
         ps.setString(10, EMP_DEPT);
         ps.setString(11,EMP_DESIGNATION );
         ps.setString(12,QUALIFICATION);
         ps.setString(13,BASIC_SALARY);
         ps.setInt(14,1);
      
         ps.executeUpdate();
         conn.close();
        }
        catch(Exception ex)
        {
         out.print(ex);
        }
        response.sendRedirect("CreateEmployee.jsp");
    }


}

        
