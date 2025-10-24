import java.util.Scanner;

class TaskNode {
    int taskId; String name; int priority; String dueDate; TaskNode next;
    TaskNode(int id, String n, int p, String d){ taskId=id; name=n; priority=p; dueDate=d; next=null; }
}

public class TaskSchedulerCircular {
    private TaskNode head;

    public void addAtBeginning(TaskNode node){
        if(head==null){ head=node; node.next=head; return; }
        TaskNode tail = head;
        while(tail.next!=head) tail=tail.next;
        node.next=head; head=node; tail.next=head;
    }
    public void addAtEnd(TaskNode node){
        if(head==null){ head=node; node.next=head; return; }
        TaskNode tail=head;
        while(tail.next!=head) tail=tail.next;
        tail.next=node; node.next=head;
    }
    public void addAtPosition(TaskNode node, int pos){
        if(head==null || pos<=1){ addAtBeginning(node); return; }
        TaskNode cur=head; int i=1;
        while(cur.next!=head && i<pos-1){ cur=cur.next; i++; }
        node.next = cur.next; cur.next = node;
    }
    public boolean removeById(int id){
        if(head==null) return false;
        if(head.taskId==id){
            if(head.next==head){ head=null; return true; }
            TaskNode tail=head; while(tail.next!=head) tail=tail.next;
            head = head.next; tail.next = head; return true;
        }
        TaskNode cur=head;
        while(cur.next!=head && cur.next.taskId!=id) cur=cur.next;
        if(cur.next==head) return false;
        cur.next = cur.next.next; return true;
    }
    public TaskNode viewCurrent(){ return head; }
    public void moveToNext(){ if(head!=null) head = head.next; }
    public void displayAll(){
        if(head==null){ System.out.println("No tasks."); return; }
        TaskNode cur=head;
        System.out.println("ID | Name | Priority | Due");
        do{
            System.out.printf("%d | %s | %d | %s%n", cur.taskId, cur.name, cur.priority, cur.dueDate);
            cur=cur.next;
        }while(cur!=head);
    }
    public void searchByPriority(int p){
        if(head==null){ System.out.println("No tasks."); return; }
        TaskNode cur=head; boolean found=false;
        do{
            if(cur.priority==p){ System.out.printf("%d | %s | %d | %s%n", cur.taskId, cur.name, cur.priority, cur.dueDate); found=true; }
            cur=cur.next;
        }while(cur!=head);
        if(!found) System.out.println("No tasks with that priority.");
    }

    public static void main(String[] args){
        TaskSchedulerCircular ts = new TaskSchedulerCircular();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1.Add at beginning 2.Add at end 3.Add at position 4.Remove by ID 5.View current 6.Move to next 7.Display all 8.Search by priority 9.Exit");
            System.out.print("Choice: "); int ch=sc.nextInt(); sc.nextLine();
            if(ch==9) break;
            switch(ch){
                case 1: case 2: case 3:{
                    System.out.print("Task ID: "); int id=sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String n=sc.nextLine();
                    System.out.print("Priority: "); int pr=sc.nextInt(); sc.nextLine();
                    System.out.print("Due Date: "); String d=sc.nextLine();
                    TaskNode node=new TaskNode(id,n,pr,d);
                    if(ch==1) ts.addAtBeginning(node);
                    else if(ch==2) ts.addAtEnd(node);
                    else { System.out.print("Position: "); int p=sc.nextInt(); sc.nextLine(); ts.addAtPosition(node,p); }
                    break;
                }
                case 4: System.out.print("ID to remove: "); int id=sc.nextInt(); sc.nextLine(); System.out.println(ts.removeById(id) ? "Removed." : "Not found."); break;
                case 5: TaskNode cur=ts.viewCurrent(); if(cur!=null) System.out.printf("Current: %d %s %d %s%n", cur.taskId,cur.name,cur.priority,cur.dueDate); else System.out.println("No current task."); break;
                case 6: ts.moveToNext(); System.out.println("Moved to next."); break;
                case 7: ts.displayAll(); break;
                case 8: System.out.print("Priority to search: "); int p=sc.nextInt(); sc.nextLine(); ts.searchByPriority(p); break;
                default: System.out.println("Invalid.");
            }
        }
        sc.close();
    }
}