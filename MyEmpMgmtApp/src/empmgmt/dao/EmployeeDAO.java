
package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.EmployeePOJO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    
//    ADD METHOD 
       
    public static boolean addNewEmp( EmployeePOJO emp)  throws SQLException {
       Connection conn = DBConnection.getConnection();      
       PreparedStatement ps = conn.prepareStatement("Insert into employee values(?,?,?,?)");
        ps.setInt(1, emp.getEmpno());
        ps.setString(2, emp.getEmpname()); 
        ps.setDouble(3, emp.getSal());
        ps.setInt(4, emp.getDeptno());
       
        int ans=ps.executeUpdate();
        return ans == 1; 
        
     
//        here all these above ps. wale  and executeUpdate ---  will throw an SQLException. but we never use try and catch in the DAO (Comapny Standard)
        
    }
//    SEARCH METHOD
    
    public static EmployeePOJO getEmmployeebyempno(int empno)  throws SQLException {
//            search methos either return the entire record or return null
       Connection conn = DBConnection.getConnection();
       PreparedStatement ps = conn.prepareStatement("select * from employee where empno=?");
       ps.setInt(1, empno);
//       being a select query returns a result set and will call the executeQuery method 
       
       ResultSet rs = ps.executeQuery();
       EmployeePOJO emp = null;
       if(rs.next()){
           emp = new EmployeePOJO();
           emp.setEmpno(rs.getInt(1));
           emp.setEmpname(rs.getString(2));
           emp.setSal(rs.getDouble(3));
           emp.setDeptno(rs.getInt(4));
           
       }
       return emp;
//       from the above few lines we are creating a employeePOJO ka obj usme (particular employee)ka pura data dalkr retun kr rhe hai obj employeePOJO ka  
              
    }
    
    public static List<EmployeePOJO> getAllEmp()  throws SQLException {
          Connection conn = DBConnection.getConnection();
          Statement st= conn.createStatement();
          ResultSet rs = st.executeQuery("select * from employee");
          List<EmployeePOJO> empList = new ArrayList<>();
          while(rs.next()){
           EmployeePOJO emp = new EmployeePOJO();
           emp.setEmpno(rs.getInt(1));
           emp.setEmpname(rs.getString(2));
           emp.setSal(rs.getDouble(3));
           emp.setDeptno(rs.getInt(4));
           
           empList.add(emp);
          }
          return empList;
    }
    public static boolean updateEmp(EmployeePOJO emp) throws SQLException{
        Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("update employee set empno=?,empname=?,sal=?,deptno=?");
         ps.setInt(1, emp.getEmpno());
         ps.setString(2, emp.getEmpname());
          ps.setDouble(3, emp.getSal());
         ps.setInt(4, emp.getDeptno());
         
         int ans=ps.executeUpdate();
         return ans == 1; 
        
    }
    public static boolean deleteEmp(int empnumb) throws SQLException {
         Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("delete from employee where empno=?");
         
         ps.setInt(1,empnumb);
         int ans= ps.executeUpdate();
        return ans ==1;
         
    }
}
