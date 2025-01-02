package WMSdataStructuresProject;

import java.util.Date;
import java.util.Objects;

public class EmployeeTree {
    private TreeNode root;

    public EmployeeTree(Employee ceo) {
        root = new TreeNode(ceo);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void AddManager(Employee e){
        TreeNode curr=root.getFirstChild();
        if(curr==null){
            return;
        }
        while(curr.getNextSibling()!=null){
            curr=curr.getNextSibling();
        }
        curr.setNextSibling(new TreeNode(e));
    }
    public void addEmployee(Employee manager, Employee employee) {
        TreeNode managerNode = findNode(root, manager);
        if (managerNode != null) {
            TreeNode newEmployeeNode = new TreeNode(employee);
            if (managerNode.getFirstChild() == null) {
                managerNode.setFirstChild(newEmployeeNode);
            } else {
                TreeNode lastChild = managerNode.getFirstChild();
                while (lastChild.getNextSibling() != null) {
                    lastChild = lastChild.getNextSibling();
                }
                lastChild.setNextSibling(newEmployeeNode);
            }
        } else {
            System.out.println("Manager not found!");
        }
    }

    public void removeEmployee(Employee employee) {
        removeNode(root, employee);
    }
    public TreeNode findNode( String Name){
        return findNode(root,Name);
    }

   public void addEmployeeToManager(String Manager, Employee e){
        TreeNode result = findNode(Manager);
        if(result==root||result==null){
            return;
        }
        if(result.employees==null){
            result.employees= new EmployeeList();
        }
        result.employees.addEmployee(e);

   }

    private TreeNode findNode(TreeNode node, String Name) {
        if (node == null)
            return null;
        if (Objects.equals(node.getData().getName(), Name))
            return node;

        TreeNode child = node.getFirstChild();
        while (child != null) {
            TreeNode result = findNode(child, Name);
            if (result != null)
                return result;
            child = child.getNextSibling();
        }
        return null;
    }
    public void addTaskToEmployee(String Name, Task t){
        Employee e=  findEmployee(Name);
        e.tasks.addTask(t);
    }
    public void addTaskToManager(String Name,Task t){
        TreeNode n = findNode(Name);
        n.getData().tasks.addTask(t);
    }
    public  Employee findEmployee( String Name){
        return findEmployee(root,Name);
    }
    private Employee findEmployee(TreeNode node, String Name){
        if (node == null)
            return null;

        TreeNode child = node.getFirstChild();
        while (child != null) {
            Employee E = child.employees.search(Name);
            if ( E != null)
                return E;
            child = child.getNextSibling();
        }
        return null;

    }


    private TreeNode findNode(TreeNode node, Employee employee) {
        if (node == null)
            return null;
        if (node.getData().getId() == employee.getId())
            return node;

        TreeNode child = node.getFirstChild();
        while (child != null) {
            TreeNode result = findNode(child, employee);
            if (result != null)
                return result;
            child = child.getNextSibling();
        }
        return null;
    }

    private void removeNode(TreeNode node, Employee employee) {
        if (node == null)
            return;
        if (node.getFirstChild() != null && node.getFirstChild().getData().getId() == employee.getId()) {
            node.setFirstChild(node.getFirstChild().getNextSibling());
            return;
        }
        TreeNode child = node.getFirstChild();
        while (child != null && child.getNextSibling() != null) {
            if (child.getNextSibling().getData().getId() == employee.getId()) {
                child.setNextSibling(child.getNextSibling().getNextSibling());
                return;
            }
            child = child.getNextSibling();
        }
    }

    public String printHierarchy() {
        return printHierarchyRecursive(root, 0);
    }

    private String printHierarchyRecursive(TreeNode node, int level) {
        if (node == null) {
            return "";
        }
        String s ="";
        String indent = " ".repeat(level * 5);
        s+=indent + node.getData().toString();
        TreeNode child = node.getFirstChild();
        s+="\n";
        while (child != null) {
            s+=printHierarchyRecursive(child, level + 1);
            child = child.getNextSibling();
        }
        if(node.employees!=null){
            s+=node.employees.display(level*5+5);
        }
        return s;
    }
    void getAllOverDueTasks(Date d){
        TreeNode child=root.getFirstChild();
        while(child!=null){
            child.DelegatedTasks.addTaskStack(child.employees.getAllUnmetTasks(d));
            Task t= child.getData().tasks.getUnmetTask(d);
            if(t!=null){
                root.DelegatedTasks.addTask(t);
            }
            child=child.getNextSibling();
        }
    }

    public TreeNode findParent(Employee employee) {
        return findParentRecursive(root, employee);
    }

    private TreeNode findParentRecursive(TreeNode node, Employee employee) {
        if (node == null)
            return null;
        TreeNode child = node.getFirstChild();
        while (child != null) {
            if (child.employees.search(employee.getName())!=null) {
                return child;
            }
            child = child.getNextSibling();
        }

        child = node.getFirstChild();
        while (child != null) {
            TreeNode result = findParentRecursive(child, employee);
            if (result != null) {
                return result;
            }
            child = child.getNextSibling();
        }

        return null;
    }

}