package WMSdataStructuresProject;

public class CEOAccess {
    private final EmployeeTree company;
    public CEOAccess(EmployeeTree T){
        company=T;

    }
   String showYourTasks(){
        return company.getRoot().getData().tasks.listAllTasks();
   }
  String showDelegatedTasks(){
        return company.getRoot().DelegatedTasks.Display();
  }
  void SendTaskToManager(String Name,Task t){
      company.addTaskToManager(Name,t);
    }
//    void SendTaskToEmployee(String Name,Task t){
//       company.addTaskToEmployee(Name,t);
//    }
//    void FireEmployee(String Name){
//        try {
//            TreeNode Manager = company.findParent(company.findEmployee(Name));
//            Manager.DelegatedTasks.addTaskStack(Manager.employees.search(Name).tasks.toTaskStack());
//            Manager.employees.kickEmployee(Name);
//        }catch (Exception e){
//
//        }
    //}
    String showOwn(){
        return company.getRoot().getData().toString();
    }
   void FireManager(String Name , Employee e){
        TreeNode Manager = company.findNode(Name);
        TaskQueue OldTasks = Manager.getData().tasks;
        while(!OldTasks.hasNoTasks()){
            e.tasks.addTask(OldTasks.Completed());
        }
        Manager.setData(e);
   }
  void AddManager(Employee e){
      company.AddManager(e);
  }
//  void AddEmployee(String Manager , Employee e){
//      company.addEmployeeToManager( company.findNode(Manager).getData().getName(),e);
//  }

  String ShowManagerTasks(String Manager){
        return  company.findNode(Manager).getData().tasks.listAllTasks();
  }
//  void getManagerDelegatedTask(String manager){
//      TreeNode Manager =  company.findNode(manager);
//      if(Manager!=null) {
//          company.getRoot().DelegatedTasks.addTask(Manager.DelegatedTasks.endTask());
//      }
//    }
  void getAllManagerDelegatedTasks(String manager){
        TreeNode ceo = company.getRoot();
        TreeNode Manager =  company.findNode(manager);
        if(manager!=null) {
            while (!Manager.DelegatedTasks.isEmpty()) {
                ceo.DelegatedTasks.addTask(Manager.DelegatedTasks.endTask());
            }
        }
  }
//  String showEmployeeTasks(String Name){
//        return company.findEmployee(Name).tasks.listAllTasks();
//  }
//  String ShowEmployee(String Name){
//        return company.findEmployee(Name).toString();
//  }
  String ShowManager(String Name){
        return  company.findNode(Name).getData().toString();
  }
  String ShowManagerDelegatedTasks(String Manager){
        return   company.findNode(Manager).DelegatedTasks.Display();
  }
   String ShowManagerEmployees(String Manager){
        return company.findNode(Manager).employees.display(0);
   }
    String ShowCompanyHierarchy(){
        return  company.printHierarchy();
    }
    
     public String completeTask() {
        return "["+company.getRoot().getData().tasks.Completed().toString() +"] is completed.";
    }
     
}
