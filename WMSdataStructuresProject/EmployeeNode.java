package WMSdataStructuresProject;
public class EmployeeNode {
    private EmployeeNode next , previous;
    private Employee data;

    public EmployeeNode(Employee e){
        this.data=e;
        next=previous=null;
    }


    public EmployeeNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeNode previous) {
        this.previous = previous;
    }

    public Employee getData() {
        return data;
    }

    public void setData(Employee data) {
        this.data = data;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }
}
