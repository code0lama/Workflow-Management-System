package WMSdataStructuresProject;


import java.util.Calendar;
import java.util.Date;
import java.util.Queue;
import java.util.Stack;


public class Main {
 Company c =new Company();
  
    public static void main(String[] args) {
       Company c =new Company();
        c.CreateCEOAccess("John Doe","ceo_pass123");
     //   System.out.println(c.employeeAccess==null);
//        c.ceoAccess.AddEmployee("Catherine Brown",new Employee("e","e","e",2,"e"));
//        c.ceoAccess.FireEmployee("s");
//        c.ceoAccess.ShowEmployee("we");
//        c.ceoAccess.SendTaskToEmployee("e",new Task("DiEE  e",new Date(124,1,1)));
//        c.createManagerAccess("Catherine Brown","cathy_pass");
//        c.createEmployeeAccess("e","e");
//        System.out.println( c.employeeAccess.showYourTasks());
//        System.out.println( c.employeeAccess.showYourTasks());
//        System.out.println(c.employeeAccess.showYourTasks());
//        System.out.println( c.employeeAccess.showOwn());
//        System.out.println( c.employeeAccess.completeTask());
        System.out.println( c.ceoAccess.ShowCompanyHierarchy());
    }

}

