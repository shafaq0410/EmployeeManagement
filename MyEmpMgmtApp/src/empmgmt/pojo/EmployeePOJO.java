/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.pojo;

/**
 *
 * @author acer
 */
public class EmployeePOJO {
    
    private int empno;
    private String empname;
    private double sal;
    private int deptno;

    public EmployeePOJO(int empno, String empname, double sal, int deptno) {
        this.empno = empno;
        this.empname = empname;
        this.sal = sal;
        this.deptno = deptno;
    }
    
    public EmployeePOJO(){
   
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
    
    
    
}
