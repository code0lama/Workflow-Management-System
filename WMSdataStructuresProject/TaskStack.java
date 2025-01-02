package WMSdataStructuresProject;

 public class TaskStack {
    private TaskNode top;
    private  int size;
    public TaskStack(){
         top=null;
        size=0;
    }
    public boolean isEmpty(){

        return top==null;
    }
    public void addTask(Task t){
        TaskNode n = new TaskNode(t);
        if(isEmpty()){
            size++;
            top=n;
            return;
        }
        n.setNext(top);
        top=n;
        size++;
    }
    public Task endTask(){
        if(isEmpty()){
            System.out.println("No Tasks");
            return null;
        }
        Task t= top.getData();
        top=top.getNext();
        size--;
        return t;
    }
    public Task checkTask(){
        if(isEmpty()){
            System.out.println("No Tasks");
            return null;
        }
        return top.getData();
    }
    public TaskStack copy(){
        TaskStack t = new TaskStack();
        TaskStack c = new TaskStack();
        while(!this.isEmpty()){
            t.addTask(this.endTask());
        }
        while(!t.isEmpty()){
            Task s = t.endTask();
            c.addTask(s);
            this.addTask(s);
        }
        return c;
    }
    public String Display(){
        String res = "";
        TaskStack copy= copy();
        while(!copy.isEmpty()){
            res+=copy.endTask();
            res+="\n";
        }
        return res;
    }
    void addTaskStack(TaskStack s){
        TaskStack tmp = new TaskStack();
        while (!s.isEmpty()){
            tmp.addTask(s.endTask());
        }
        while(!tmp.isEmpty()){
            this.addTask(tmp.endTask());
        }
    }


 }
