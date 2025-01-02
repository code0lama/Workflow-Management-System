package WMSdataStructuresProject;

public class EmployeeAccess {
    private final Employee employee;

    public EmployeeAccess(Employee employee) {
        this.employee = employee;
    }

    public String showYourTasks() {
        return employee.tasks.listAllTasks();
    }
    public String showOwn(){
        return employee.toString();
    }

    public String completeTask() {
        return "["+employee.tasks.Completed().toString()+"] is completed.";
    }
    
  public String returnName(){
      return employee.getName();
  }




}
