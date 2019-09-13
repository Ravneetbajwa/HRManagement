package Controller;

import com.oreilly.servlet.MultipartRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ComposeMsg extends HttpServlet {

    
        
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          String Path = "/C:/wamp/www/hrm/";
          String filename="NOT DEFINED", upload;
          HttpSession session = request.getSession();
          String SenderID = (String)session.getAttribute("SNO");
          
           MultipartRequest m = new MultipartRequest(request, Path, 9094130, "UTF-8", new MyTitleRenamePolicy());
            Enumeration files = m.getFileNames();
           
            while (files.hasMoreElements()) {
             upload = (String) files.nextElement();
             filename = m.getFilesystemName(upload);
            }
            
            System.out.println("filename = "+filename);
           
          if(filename==null||filename.equals(""))
          {
              filename="NOT DEFINED";
             
          }
          
        String Subject = m.getParameter("subject");
        String Message = m.getParameter("message");
        String receiverid = m.getParameter("receiverid");
        out.print(Subject);
        out.print(Message);
      //  GetSno gs = new GetSno();
      //  int Sno = gs.getMessageNumber();
         //   System.out.println("Sno = "+Sno);
       int Sno=0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
        PreparedStatement ps = conn.prepareStatement("insert into message values(?,?,?,?,?,?,now(),?,?,?)") ;
        ps.setInt(1,Sno);
        ps.setString(2,SenderID);
        ps.setString(3,receiverid);
        ps.setString(4,Subject);
        ps.setString(5, Message);
        ps.setString(6,"");
//        ps.setString(7, "");
        ps.setString(7, "");
        ps.setString(8,filename);
        ps.setInt(9,1);
        ps.executeUpdate();
         conn.close();
        }
        catch(Exception ex)
        {
         out.print(ex);
        }
    response.sendRedirect("EmpSentMessage.jsp");
        }
        
    


}