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
import javax.servlet.http.HttpSession;

public class EditEmpProfile extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
              HttpSession session = request.getSession();
          String SNO = (String)session.getAttribute("SNO");
        String FirstName=request.getParameter("firstname");
        String LastName=request.getParameter("lastname");
        String Email=request.getParameter("email");
        String Contact=request.getParameter("contact");
        String Password=request.getParameter("password");
      
        
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("update create_emp set FIRST_NAME=?,LAST_NAME=?,EMAIL=?,PASSWORD=?,CONTACT=? where SNO=?") ;
        
         ps.setString(1, FirstName);
         ps.setString(2, LastName);
         ps.setString(3, Email);
         ps.setString(4, Password);
          ps.setString(5,Contact);
           ps.setString(6,SNO);
    
         ps.executeUpdate();
         conn.close();
         
         session.setAttribute("PASSWORD",Password);
session.setAttribute("FIRST_NAME",FirstName);
session.setAttribute("LAST_NAME",LastName);
session.setAttribute("EMAIL",Email);
session.setAttribute("CONTACT",Contact);

         
        }
        catch(Exception ex)
        {
         out.print(ex);
        }
        response.sendRedirect("EmpProfile.jsp");
           
        }
    }


