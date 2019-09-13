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

public class ViewEmployee extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String SNO=request.getParameter("SNO");
             String PASSWORD=request.getParameter("password");
            String FIRST_NAME=request.getParameter("firstname");
        String LAST_NAME=request.getParameter("lastname");
         String EMAIL=request.getParameter("email");
         String GENDER=request.getParameter("gender");
         String DOB=request.getParameter("dob");
         String CONTACT=request.getParameter("contact");
         String EMP_TYPE =request.getParameter("emptype");
         String EMP_DEPT=request.getParameter("empdept");
         String EMP_DESIGNATION=request.getParameter("empdesgnation");
         String QUALIFICATION=request.getParameter("qualification");
         String BASIC_SALARY=request.getParameter("basicsalary");
         String STATUS=request.getParameter("status");
         out.print(FIRST_NAME+"<br>");
          out.print(LAST_NAME+"<br>");
           out.print(EMAIL+"<br>");
           out.print(DOB);
           
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("Select FIRST_NAME , LAST_NAME , EMAIL ,PASSWORD, GENDER , DOB , CONTACT , EMP_TYPE , EMP_DEPT , EMP_DESIGNATION , QUALIFICATION , BASIC_SALARY from create_emp where STATUS = ?") ;
         ps.setInt(1,1 );
//         ps.setString(2,FIRST_NAME );
//         ps.setString(3, LAST_NAME);
//         ps.setString(4,EMAIL );
//         ps.setString(5, GENDER);
//         ps.setString(6,DOB );
//         ps.setString(7, CONTACT);
//          ps.setString(8,EMP_TYPE );
//         ps.setString(9, EMP_DEPT);
//         ps.setString(10,EMP_DESIGNATION );
//         ps.setString(11,QUALIFICATION);
//         ps.setString(12,BASIC_SALARY);
//         ps.setInt(13,1);
      
         ps.executeQuery();
         conn.close();
        }
        catch(Exception ex)
        {
        //  out.print(ex);
        }
        
    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
              String SNO=request.getParameter("SNO");
            String FIRST_NAME=request.getParameter("firstname");
        String LAST_NAME=request.getParameter("lastname");
         String EMAIL=request.getParameter("email");
         String GENDER=request.getParameter("gender");
         String DOB=request.getParameter("dob");
         String CONTACT=request.getParameter("contact");
         String EMP_TYPE =request.getParameter("emptype");
         String EMP_DEPT=request.getParameter("empdept");
         String EMP_DESIGNATION=request.getParameter("empdesgnation");
         String QUALIFICATION=request.getParameter("qualification");
         String BASIC_SALARY=request.getParameter("basicsalary");
         String STATUS=request.getParameter("status");
         out.print(FIRST_NAME+"<br>");
          out.print(LAST_NAME+"<br>");
           out.print(EMAIL+"<br>");
           out.print(DOB);
        }
    }
}
 
        
