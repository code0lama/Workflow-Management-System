package WMSdataStructuresProject;

import java.util.*;

public class TaskQueue {

    private TaskNode front;
    private TaskNode rear;
    private int numOfTasks;

    public TaskQueue() {
        front = null;
        rear = null;
        numOfTasks = 0;
    }

    public boolean hasNoTasks() {
        return front == null;
    }

    public void addTask(Task data) {
        TaskNode n = new TaskNode(data);
        if (hasNoTasks()) {
            front = rear = n;
            numOfTasks++;
        } else {
            rear.setNext(n);
            rear = n;
            numOfTasks++;
        }
    }

    public Task Completed() {
        if (hasNoTasks()) {
            return null;
        }
        Task task = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
            numOfTasks--;
        }
        return task;
    }

    public Task checkNextTask() {
        if (hasNoTasks()) {
            System.out.println("No tasks to check");
            return null;
        }
        return front.getData();
    }

    public TaskQueue copyQueue() {
        TaskQueue temp = new TaskQueue();
        TaskQueue copy = new TaskQueue();
        while (!this.hasNoTasks()) {
            Task t = this.Completed();
            temp.addTask(t);
        }
        while (!temp.hasNoTasks()) {
            Task t = temp.Completed();
            copy.addTask(t);
            this.addTask(t);
        }
        return copy;
    }

    public int NumberOfTasks() {
        return numOfTasks;
    }

    public String listAllTasks() {
        String res = "";
        TaskQueue copy = this.copyQueue();
        while (!copy.hasNoTasks()) {
            res += copy.Completed();
            res += "\n";
        }
        return res;
    }

    TaskStack toTaskStack() {
        TaskQueue q = copyQueue();
        TaskStack tmp = new TaskStack();
        TaskStack res = new TaskStack();
        while (!q.hasNoTasks()) {
            tmp.addTask(q.Completed());
        }
        while (!tmp.isEmpty()) {
            res.addTask(tmp.endTask());
        }
        return res;
    }

    public Task getTaskByTitle(String title) {
        if (hasNoTasks()) {
            System.out.println("Employee has no tasks to display.");
            return null;
        }

        TaskNode curr = front;
        while (curr != null) {
            if (curr.getData().getTitle().equals(title)) {
                return curr.getData();
            }
            curr = curr.getNext();
        }
        System.out.println("A task with such title does not exist.");
        return null;
    }

    public TaskQueue getTasksForDate(Date targetDueDate) {
        TaskQueue tasksForDate = new TaskQueue();
        if (hasNoTasks()) {
            System.out.println("Employee has no tasks to display.");
            return tasksForDate;
        }

        TaskNode pointer = front;
        boolean found = false;
        while (pointer != null) {
            Task task = pointer.getData();
            if (task.getDueDate().equals(targetDueDate)) {
                tasksForDate.addTask(task);
                found = true;
            }
            pointer = pointer.getNext();
        }

        if (!found) {
            System.out.println("No tasks are due on " + targetDueDate + ".");
        }
        return tasksForDate;
    }

    public void swapTasks(TaskQueue t2, String title1, String title2) {
        Task task1 = this.getTaskByTitle(title1);
        Task task2 = t2.getTaskByTitle(title2);
        if (task1 == null) {
            System.out.println("Task with title \"" + title1 + "\" does not exist in the current queue.");
            return;
        }
        if (task2 == null) {
            System.out.println("Task with title \"" + title2 + "\" does not exist in the other queue.");
            return;
        }
        String tempTitle = task1.getTitle();
        Date tempDueDate = task1.getDueDate();
        boolean tempQuality = task1.isQuality();

        task1.setTitle(task2.getTitle());
        task1.setDueDate(task2.getDueDate());
        task1.setQuality(task2.isQuality());
        task2.setTitle(tempTitle);
        task2.setDueDate(tempDueDate);
        task2.setQuality(tempQuality);
        System.out. println("Tasks with titles \"" + title1 + "\" and \"" + title2 + "\" have been swapped.");
    }

    public Task getUnmetTask(Date d) {
        if (!hasNoTasks()) {
            if (front.getData().getDueDate().before(d) || !front.getData().isQuality()) {
                return this.Completed();
            }
        }
        return null;
    }

}
