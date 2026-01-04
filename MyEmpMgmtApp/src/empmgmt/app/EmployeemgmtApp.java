
package empmgmt.app;

import empmgmt.dao.EmployeeDAO;
import empmgmt.pojo.EmployeePOJO;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class EmployeemgmtApp {
      static Scanner kb;
    public static void main(String [] args){
        kb= new Scanner(System.in);
        int choice;
        do{
            System.out.println("Select an operation :");
             System.out.println("1.Add New Emp\n2.Search Employee\n3.Show All Emp\n4.Update Emp\n5.Delete EMp\n6.Quit");
            choice = kb.nextInt();
                    
            switch(choice){
            
                case 1:
                      addNewEmp();
                      break;
               
                 case 2:
                      searchEmp();
                      break;
                      
                 case 3:
                     showAllEmp();
                     break;
                     
                 case 4:
                     updateEmp();
                     break;
                     
                 case 5:
                     deleteEmp();
                     break;
                     
                 case 6:
                     System.out.println("Thank you, for using the app !");
                     break;
                     
                 default:
                      System.out.println("Wrong Choice ! Try again");
            
        }
        }while(choice!=6);
    }
    public static void addNewEmp(){
        try{
            System.out.println("Enter empno:");
            int eno = kb.nextInt();
            
            
            System.out.println("Enter employee name:");
            kb.nextLine();
            String ename =kb.nextLine();
            
            System.out.println("Enter salary:");
            double sal = kb.nextDouble();
            
            System.out.println("Enter department number:");
            int dno = kb.nextInt();
            
            
            EmployeePOJO emp = new EmployeePOJO(eno,ename,sal,dno);
            boolean result = EmployeeDAO.addNewEmp(emp);
            System.out.println(result== true? "Record inserted " : "Record not inserted ");
            System.out.println();
            
        }catch(SQLException ex){
        System.out.println("Exception occured in adding the employeee "+ ex.getMessage());
    }
    }
    public static void searchEmp(){
        try{
            System.out.println("Enter empno for searching:");
            int eno = kb.nextInt();
            EmployeePOJO emp = EmployeeDAO.getEmmployeebyempno(eno);
            if(emp == null)
                System.out.println("no rec of employee no: "+eno+" found in the data base ");
            else{
                System.out.println("Empno "+emp.getEmpno());
                System.out.println("Empname "+emp.getEmpname());
                System.out.println("EmpSal "+emp.getSal());
                System.out.println("Deptno "+emp.getDeptno());
                 System.out.println();
              
            }
      
        }
        catch(SQLException ex){
              System.out.println("Exception occured in searching of the employeee "+ ex.getMessage());
       }
    }
     public static void  showAllEmp(){
            try{
                List<EmployeePOJO> empList = EmployeeDAO.getAllEmp();
                if(empList.size() == 0)
                    System.out.println("Sorry ! No reocrds in the Data base ");
                else{
                    for(EmployeePOJO emp : empList){
                          System.out.print(" Empno: "+emp.getEmpno());
                          System.out.print(" \nEmpname: "+emp.getEmpname());
                          System.out.print(" \nEmpSal: "+emp.getSal());
                          System.out.println(" \nDeptno: "+emp.getDeptno());
                          System.out.println("================================================");
                          System.out.println();
           
                    }
                }
                
            }catch(SQLException ex){
        System.out.println("Exception occured in searching of the employeee "+ ex.getMessage());
        }
   }
     
   public static void updateEmp(){
        try{
            System.out.println("Enter empno whose rec is to be updated :");
            int eno = kb.nextInt();
            
            
            System.out.println("Enter new employee name:");
            kb.nextLine();
            String ename =kb.nextLine();
            
            System.out.println("Enter new salary:");
            double sal = kb.nextDouble();
            
            System.out.println("Enter new department number:");
            int dno = kb.nextInt();
            
            
            EmployeePOJO emp = new EmployeePOJO(eno,ename,sal,dno);
            boolean result = EmployeeDAO.updateEmp(emp);
            System.out.println(result == true? "Record updated " : "Record not found  ");
             System.out.println();
           
             
   }catch(SQLException ex){
        System.out.println("Exception occured in updating  the employeee "+ ex.getMessage());
        
     }
        
   }
        
   public static void deleteEmp(){
       try{
            System.out.println("Enter empno whose rec is to be deleted :");
            int eno = kb.nextInt();
            boolean result = EmployeeDAO.deleteEmp(eno);
            System.out.println(result == true? "Record deleted " : "Record not found  ");
             System.out.println();
           
            
   }catch(SQLException ex){
        System.out.println("Exception occured in deleting the employeee "+ ex.getMessage());
    }
  }
}
