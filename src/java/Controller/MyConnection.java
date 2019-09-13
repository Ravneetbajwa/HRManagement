
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {

  Connection con=null;
   
public Connection start_Connection()
    {
         try
          {
           Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm", "root", "");
        }
         catch(Exception ex)
         {
             System.out.println("exception = "+ex);        
         }
    
         return con;
    }

public void stop_Connection() 
{
    try
    {
    con.close();
    }
    catch(Exception ex)
    {
        System.out.println("connection error"+ex);
    }
    
       
}
}