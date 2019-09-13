
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmpLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            HttpSession session = request.getSession();
        String USER_EMAIL = request.getParameter("emp_user");
        String USER_PASSWORD = request.getParameter("emp_password");
        
        
        try
                     {
                       Class.forName("com.mysql.jdbc.Driver");
                  
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("select * from create_emp where EMAIL=? and PASSWORD=? and STATUS = ?");
         ps.setString(1,USER_EMAIL);  
         ps.setString(2,USER_PASSWORD);
         ps.setString(3,"1");
         ResultSet rs = ps.executeQuery();
            if (rs.next()) {
session.setAttribute("SNO",rs.getString("SNO"));
session.setAttribute("PASSWORD",rs.getString("PASSWORD"));
session.setAttribute("FIRST_NAME",rs.getString("FIRST_NAME"));
session.setAttribute("LAST_NAME",rs.getString("LAST_NAME"));
session.setAttribute("EMAIL",rs.getString("EMAIL"));
session.setAttribute("GENDER",rs.getString("GENDER"));
session.setAttribute("DOB",rs.getString("DOB"));
session.setAttribute("CONTACT",rs.getString("CONTACT"));
session.setAttribute("EMP_TYPE",rs.getString("EMP_TYPE"));
session.setAttribute("EMP_DEPT",rs.getString("EMP_DEPT"));
session.setAttribute("EMP_DESIGNATION",rs.getString("EMP_DESIGNATION"));
session.setAttribute("QUALIFICATION",rs.getString("QUALIFICATION"));
session.setAttribute("BASIC_SALARY",rs.getString("BASIC_SALARY"));
session.setAttribute("STATUS",rs.getString("STATUS"));
out.print("done");
            }
                    else
        {
            out.print("fail");
        }

                     }
        catch(Exception ex)
        {
          out.print("exception on employee login = "+ex);  
        }
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
