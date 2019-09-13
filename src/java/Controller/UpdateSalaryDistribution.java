
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


public class UpdateSalaryDistribution extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
        String Salary_Month = request.getParameter("salay_month");
        String employee_code[] = request.getParameterValues("employee_code");   
        int total_employee = employee_code.length;    
        GetSno gs = new GetSno();    
         
        for (int x = 0; x < total_employee; x++) {
            
          String Payment_Mode = request.getParameter("payment_mode" + employee_code[x]); 
          String Salary_Amount = request.getParameter("salary" + employee_code[x]);
          String Dispatch_Date = request.getParameter("dispatch_date" + employee_code[x]);
             try
                     {
         Class.forName("com.mysql.jdbc.Driver");
         Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement pstmt = conn.prepareStatement("update salary_distribution set SALARY_AMT=?,DISPATCH_DATE=?,PAYMENT_MODE=? where EMP_ID=? and SALARY_MONTH=?");
         pstmt.setString(1,Salary_Amount);
         pstmt.setString(2,Dispatch_Date);
         pstmt.setString(3,Payment_Mode);
         pstmt.setString(4,employee_code[x]);
         pstmt.setString(5,Salary_Month);
         pstmt.executeUpdate();
         conn.close();
                     }
             catch(Exception ex)
             {
                 out.print("exception on UpdateSalaryDispatch = "+ex);
             }
               
            }
        
       response.sendRedirect("SalaryDistribution.jsp");
        
            
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
