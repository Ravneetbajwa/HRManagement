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

public class DeleteDepartment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
       String DepartmentName=request.getParameter("deptname");
        String Sno=request.getParameter("sno");
         String Status=request.getParameter("status");
        // out.print(Sno);
        
           Class.forName("com.mysql.jdbc.Driver");
          Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
         PreparedStatement ps = conn.prepareStatement("delete from department_name where SNO=?&& DEPT_NAME=?&& STATUS=?") ;
         ps.setString(1, Sno);
         ps.setString(2, DepartmentName);
         ps.setString(3, Status);
        
         ps.executeUpdate();
         conn.close();
        }
        catch(Exception ex)
        {
         out.print(ex);
        }
       response.sendRedirect("AdminSetting.jsp");
        }
        
    


}
