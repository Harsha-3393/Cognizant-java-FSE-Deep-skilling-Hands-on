import java.util.Scanner;

// Task class
class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskId: " + taskId +
               ", TaskName: " + taskName +
               ", Status: " + status;
    }
}

// Node class
class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

// Singly Linked List class
class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    // Add Task
    public void addTask(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    // Search Task
    public Task searchTask(int taskId) {
        Node temp = head;

        while (temp != null) {
            if (temp.task.taskId == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }

        return null;
    }

    // Traverse Tasks
    public void traverse() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Delete Task
    public void deleteTask(int taskId) {

        if (head == null) {
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null &&
               temp.next.task.taskId != taskId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
}

// Main Class
public class TaskManager {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SinglyLinkedList taskList = new SinglyLinkedList();

        System.out.print("Enter the number of tasks: ");
        int numberOfTasks = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfTasks; i++) {

            System.out.println("\nEnter details for Task " + (i + 1));

            System.out.print("Task ID: ");
            int taskId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Task Name: ");
            String taskName = scanner.nextLine();

            System.out.print("Status (Complete/Incomplete): ");
            String status = scanner.nextLine();

            taskList.addTask(new Task(taskId, taskName, status));
        }

        System.out.println("\nTasks in the List:");
        taskList.traverse();

        System.out.print("\nEnter Task ID to Search: ");
        int searchId = scanner.nextInt();

        Task foundTask = taskList.searchTask(searchId);

        if (foundTask != null) {
            System.out.println("Found Task: " + foundTask);
        } else {
            System.out.println("Task Not Found");
        }

        System.out.print("\nEnter Task ID to Delete: ");
        int deleteId = scanner.nextInt();

        taskList.deleteTask(deleteId);

        System.out.println("\nTasks After Deletion:");
        taskList.traverse();

        scanner.close();
    }
}