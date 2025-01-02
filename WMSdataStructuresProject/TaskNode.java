package WMSdataStructuresProject;

public class TaskNode {
    private TaskNode next;
    private Task data;

    public TaskNode(Task data) {
        this.data = data;
        next=null;
    }

    public Task getData() {
        return data;
    }

    public void setData(Task data) {
        this.data = data;
    }

    public TaskNode getNext() {
        return next;
    }

    public void setNext(TaskNode next) {
        this.next = next;
    }
}
