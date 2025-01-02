package WMSdataStructuresProject;

public class TreeNode {
    private Employee data;
    private TreeNode firstChild;
    private TreeNode nextSibling;
    public EmployeeList employees;
    public TaskStack DelegatedTasks;
    public TreeNode(Employee data) {
        this.data = data;
        this.firstChild = null;
        this.nextSibling = null;
        this.employees=null;
        DelegatedTasks=new TaskStack();
    }

    public Employee getData() {
        return data;
    }


    public void setData(Employee data) {
        this.data = data;
    }

    public TreeNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(TreeNode firstChild) {
        this.firstChild = firstChild;
    }

    public TreeNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(TreeNode nextSibling) {
        this.nextSibling = nextSibling;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
