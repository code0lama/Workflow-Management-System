package WMSdataStructuresProject;


    public class ManagerAccess {
        private final TreeNode manager;
        public ManagerAccess(TreeNode manager) {
            this.manager = manager;
        }
        String ShowOwn(){
            return manager.getData().toString();
        }
        public String showYourTasks() {
            return manager.getData().tasks.listAllTasks();
        }

        public String showDelegatedTasks() {
            return manager.DelegatedTasks.Display();
        }
        public void sendTaskToEmployee(String employeeName, Task task) {
            Employee employeeNode = manager.employees.search(employeeName);
            if (employeeNode != null) {
                employeeNode.tasks.addTask(task);
            }
        }
        public void addEmployee(Employee employee) {
            manager.employees.addEmployee(employee);
        }
        public void removeEmployee(String employeeName) {
            Employee employee = manager.employees.search(employeeName);
            if (employee != null) {
                manager.DelegatedTasks.addTaskStack(employee.tasks.toTaskStack());
                manager.employees.kickEmployee(employeeName);
            }
        }
        public String showEmployeeTasks(String employeeName) {
            Employee employee = manager.employees.search(employeeName);
            if (employee != null) {
                return employee.tasks.listAllTasks();
            } else {
                throw new IllegalArgumentException("Employee not found under this manager.");
            }
        }
        public String showEmployee(String Name){
            return manager.employees.search(Name).toString();
        }
        public String showEmployees() {
            return manager.employees.display(0);
        }
        
        public String completeTask() {
        return "["+manager.getData().tasks.Completed().toString()+"] is completed.";
    }
    }

