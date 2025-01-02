package WMSdataStructuresProject;
import java.util.Date;
import java.util.Objects;

public class EmployeeList {
    private EmployeeNode head, tail;
    private int size;
    public EmployeeList(){
        head=tail=null;
        size=0;
    }
    public boolean isEmpty(){
        return  head==null;
    }
    public void addEmployeeWithPriority(Employee e){
        EmployeeNode n = new EmployeeNode(e);
        if(isEmpty()){
            size++;
            head=tail=n;
            return;
        }
        head.setPrevious(n);
        n.setNext(head);
        head=n;
        size++;
    }
    public void addEmployee(Employee e){
        EmployeeNode n = new EmployeeNode(e);
        if(isEmpty()){
            size++;
            head=tail=n;
            return;
        }
        tail.setNext(n);
        n.setPrevious(tail);
        tail=n;
        size++;
    }
    public void kickFromFront(){
        if(this.isEmpty()){
            System.out.println("No Employees");
            return;
        }
        head=head.getNext();
        if(head!=null) {
            head.setPrevious(null);
        }else{
            tail=null;
        }
        size--;
    }
    public void kickFromBack(){
        if(isEmpty()){
            System.out.println("No Employees");
            return;
        }
        tail=tail.getPrevious();
        if(tail!=null) {
            tail.setNext(null);
        }else{
            head=null;
        }
        size--;
    }
    public Employee search(String Name){
        EmployeeNode curr=head;
        while(curr!=null){
            if(Objects.equals(curr.getData().getName(), Name)){
                break;
            }
            curr=curr.getNext();
        }
        if (curr==null){
            return null;// to prevent NullPointerException
        }else{
            return curr.getData();
        }
    }

    public void kickEmployee(String Name){
        if (isEmpty()){
            System.out.println("No Employees");
            return;
        }
        if(search(Name)==null){
            System.out.println("Employee Does Not Exist");
        }
        if (Objects.equals(head.getData().getName(), Name)){
            kickFromFront();
            return;
        }
        EmployeeNode curr=head;
        while(curr.getNext()!=null){
            if(Objects.equals(curr.getData().getName(), Name)){
                curr.getNext().setPrevious(curr.getPrevious());
                curr.getPrevious().setNext(curr.getNext());
                size--;
                return;
            }
            curr=curr.getNext();
        }
        if(Objects.equals(curr.getData().getName(), Name)){
            kickFromBack();
        }
    }
    public void modifySalary(String Name,double percentage){
        if(percentage<-100){
            System.out.println("Invalid Percentage");
            return;
        }

        if(search(Name)==null){
            System.out.println("Employee Does Not Exist");
        }
        percentage=percentage/100;
        EmployeeNode curr=head;
        while(curr!=null){
            if(Objects.equals(curr.getData().getName(), Name)){
                curr.getData().setSalary(curr.getData().getSalary()+curr.getData().getSalary()*percentage);
                return;
            }
        }

    }
    public EmployeeList copy(){
        EmployeeList e = new EmployeeList();
        EmployeeNode curr=head;
        while (curr!=null){
            e.addEmployee(curr.getData());
            curr=curr.getNext();
        }
        return e;
    }
    public EmployeeList sortEmployeesBySalary(){
        if(isEmpty()){
            System.out.println("No Employees");
        }
        EmployeeList e = new EmployeeList();
        EmployeeList copy =this.copy();
        int count=0;
        while(count<size){
            e.addEmployee(copy.getMaxSalaried());
            copy.kickEmployee(copy.getMaxSalaried().getName());
            count++;
        }
        return e;
    }
    public Employee getMaxSalaried(){
        if(isEmpty()){
            System.out.println("No Employees");
            return null;
        }
        double max = Integer.MIN_VALUE;
        EmployeeNode curr=head;
        while(curr!=null){
            if(curr.getData().getSalary()>max){
                max=curr.getData().getSalary();
            }
            curr=curr.getNext();
        }
        curr=head;
        while(curr!=null){
            if(curr.getData().getSalary()==max){
                break;
            }
            curr=curr.getNext();
        }
        return curr.getData();
    }
    public String display(int indent) {

        String res = "";
        String ind =" ".repeat(indent);
        EmployeeNode curr=head;
        while(curr!=null){
            res+=ind+curr.getData().toString();
            res+="\n";
            curr =curr.getNext();
        }
        return  res;
    }
    TaskStack getAllUnmetTasks(Date d){
        TaskStack s = new TaskStack();
        EmployeeNode curr = head ;
        while(curr!=null){
            Task t = curr.getData().tasks.getUnmetTask(d);
            if(t!=null){
                s.addTask(t);
            }
            curr=curr.getNext();
        }
        return s;
    }
}
