package WMSdataStructuresProject;
public class Employee {
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private  String password;
    private static int currid =1;
    private int id;
    private String name, role,department;
    private  double salary;
    public TaskQueue tasks;
    public Employee(String name,String role,String department, double salary,String pass){
        this.name=name;
        this.department=department;
        this.role=role;
        this.salary=salary;
        id=currid;
        if(pass.length()<8){
            throw new NumberFormatException("Password too short");
        }
        password=pass;
        currid++;
        tasks= new TaskQueue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }



    public String toString(){
        return "ID : "+id+"     | Name : "+name+"\n\nRole: "+role+"     |     Department: "+department+"\n\nSalary: "+salary;
    }
}
