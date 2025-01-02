package WMSdataStructuresProject;

import java.util.Date;
import java.util.Objects;

public class Company {
    public EmployeeTree company;
    public FormattedTime CurrentDay;
    public CEOAccess ceoAccess;
    public ManagerAccess managerAccess;
    public EmployeeAccess employeeAccess;
    public void CreateCEOAccess(String Name,String Password){
        try {
            if (Objects.equals(company.getRoot().getData().getPassword(), Password) && Objects.equals(company.getRoot().getData().getName(), Name)) {
                ceoAccess = new CEOAccess(company);
            } else {
                ceoAccess = null;
            }
        }catch (Exception e){
            ceoAccess = null;
        }
            managerAccess = null;
            employeeAccess = null;

    }
    boolean isLoggedOut(){
        return managerAccess==null&&employeeAccess==null&&ceoAccess==null;
    }
    public void createManagerAccess(String Name,String Password){
        try {
            if (company.findNode(Name) != null && Objects.equals(company.findNode(Name).getData().getPassword(), Password)) {
                managerAccess = new ManagerAccess(company.findNode(Name));
            } else {
                managerAccess = null;
            }
        }catch (Exception e){
            managerAccess = null;
        }
            ceoAccess = null;
            employeeAccess = null;
    }
    public void createEmployeeAccess(String Name,String Password){
        try {
            if (company.findEmployee(Name) != null && Objects.equals(company.findEmployee(Name).getPassword(), Password)) {
                employeeAccess = new EmployeeAccess(company.findEmployee(Name));
            } else {
                employeeAccess = null;
            }
        }catch (Exception e){
            employeeAccess = null;
        }
        ceoAccess = null;
        managerAccess = null;
    }
    void progressADay(){
        CurrentDay.ProgressADay();
        company.getAllOverDueTasks(CurrentDay.getCurrentDay());
    }
    public Company(){
                CurrentDay=new FormattedTime();
                Employee ceo = new Employee("John Doe", "CEO", "Executive", 300000, "ceo_pass123");
                company =new EmployeeTree(ceo);
                Employee manager1 = new Employee("Alice Smith", "Manager", "Sales", 120000, "alice_pass");
                Employee manager2 = new Employee("Bob Johnson", "Manager", "IT", 130000, "bob_pass");
                Employee manager3 = new Employee("Catherine Brown", "Manager", "HR", 110000, "cathy_pass");
                company.addEmployee(ceo, manager1);
                company.addEmployee(ceo, manager2);
                company.addEmployee(ceo, manager3);
                company.addEmployeeToManager("Alice Smith",new Employee("Eve Turner", "Sales Rep", "Sales", 50000, "eve_pass"));
                company.addEmployeeToManager("Alice Smith",new Employee("Paul Walker", "Sales Rep", "Sales", 55000, "paul_pass"));
                company.addEmployeeToManager("Alice Smith",new Employee("Diana White", "Sales Rep", "Sales", 52000, "diana_pass"));
                company.addEmployeeToManager("Alice Smith",new Employee("Steve Green", "Sales Rep", "Sales", 51000, "steve_pass"));
                company.addEmployeeToManager("Alice Smith",new Employee("Laura Blue", "Sales Rep", "Sales", 53000, "laura_pass"));
                company.addEmployeeToManager("Alice Smith",new Employee("Tom Black", "Sales Rep", "Sales", 54000, "tom_pass"));
                company.addEmployeeToManager("Bob Johnson",new Employee("Gary Moore", "IT Specialist", "IT", 70000, "gary_pass"));
                company.addEmployeeToManager("Bob Johnson",new Employee("Sally Red", "IT Specialist", "IT", 75000, "sally_pass"));
                company.addEmployeeToManager("Bob Johnson",new Employee("Harry Potter", "IT Specialist", "IT", 72000, "harry_pass"));
                company.addEmployeeToManager("Bob Johnson",new Employee("Ron Weasley", "IT Specialist", "IT", 71000, "ron_pass"));
                company.addEmployeeToManager("Bob Johnson",new Employee("Hermione Granger", "IT Specialist", "IT", 73000, "hermione_pass"));
                company.addEmployeeToManager("Bob Johnson",new Employee("Draco Malfoy", "IT Specialist", "IT", 74000, "draco_pass"));
                company.addEmployeeToManager("Catherine Brown",new Employee("Anna Bell", "HR Specialist", "HR", 45000, "anna_pass"));
                company.addEmployeeToManager("Catherine Brown",new Employee("Betty Cooper", "HR Specialist", "HR", 46000, "betty_pass"));
                company.addEmployeeToManager("Catherine Brown",new Employee("Cheryl Blossom", "HR Specialist", "HR", 47000, "cheryl_pass"));
                company.addEmployeeToManager("Catherine Brown",new Employee("Toni Topaz", "HR Specialist", "HR", 44000, "toni_pass"));
                company.addEmployeeToManager("Catherine Brown",new Employee("Kevin Keller", "HR Specialist", "HR", 43000, "kevin_pass"));
                company.addEmployeeToManager("Catherine Brown",new Employee("Josie McCoy", "HR Specialist", "HR", 48000, "josie_pass"));
                TaskQueue s = new TaskQueue();
        String[] names = {
                "Eve Turner", "Paul Walker", "Diana White", "Steve Green", "Laura Blue", "Tom Black",
                "Gary Moore", "Sally Red", "Harry Potter", "Ron Weasley", "Hermione Granger", "Draco Malfoy",
                "Anna Bell", "Betty Cooper", "Cheryl Blossom", "Toni Topaz", "Kevin Keller", "Josie McCoy",
                "Alice Smith", "Bob Johnson", "Catherine Brown",
                "John Doe"
        };

        for (int i = 1; i <= 25; i++) {
            s.addTask(new Task("Task " + i, new Date(2024 , 0, 1)));
        }
        for (int i = 26; i <= 50; i++) {
            s.addTask(new Task("Task " + i, new Date(2024 , 0, 2)));
        }
        for (int i = 51; i <= 65; i++) {
            s.addTask(new Task("Task " + i, new Date(2024, 0, 3)));
        }
        for (int i = 66; i <= 84; i++) {
            s.addTask(new Task("Task " + i, new Date(2024, 0, 4)));
        }
        int curr=0;
        while (!s.hasNoTasks()){
            if(company.findNode(names[curr%names.length])!=null){
                company.addTaskToManager(names[curr%names.length],s.Completed());
            }
            else{
                company.addTaskToEmployee(names[curr%names.length],s.Completed());
            }
            curr++;
        }

    }
    
    


}
