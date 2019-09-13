package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class GetSno 
{
    MyConnection cc;
    
    public GetSno()
    {
        cc = new MyConnection();
    }
    
    
     public int getEmployeeId() {
        int EmployeeId = 0;
        try {
            Connection con = cc.start_Connection();
            PreparedStatement ps = con.prepareStatement("select MAX(SNO) from create_emp");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                EmployeeId = rs.getInt(1);
                EmployeeId++;
            } else {
                EmployeeId = 1;
            }

            rs.close();
            ps.close();
            con.close();
            cc.stop_Connection();
        } catch (Exception ex) {
            System.out.println("error in GET EmployeeId = " + ex);
        }

        return EmployeeId;
    }   
    
    
    public int getAttendanceNumber() {
         int AttendanceNumber = 0;
        try {
            Connection con = cc.start_Connection();
            PreparedStatement ps = con.prepareStatement("select MAX(SNO) from emp_attendance");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AttendanceNumber = rs.getInt("SNO");
                AttendanceNumber++;
            } else {
                AttendanceNumber = 1;
            }

            con.close();
            System.out.print("123");
        } catch (Exception ex) {
            System.out.println("error in GET message = " + ex);
        }

        return AttendanceNumber;

    }
    
    public int getMessageNumber() {
         int MessageNumber = 0;
        try {
            Connection con = cc.start_Connection();
            PreparedStatement ps = con.prepareStatement("select MAX(SNO) from message");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                MessageNumber = rs.getInt("SNO");
                MessageNumber++;
            } else {
                MessageNumber = 1;
            }

            con.close();
            System.out.print("123");
        } catch (Exception ex) {
            System.out.println("error in GET message = " + ex);
        }

        return MessageNumber;

    }
    
    
}
