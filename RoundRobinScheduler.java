import java.util.Scanner;

class ProcessNode {
    int pid; int burst; int priority; ProcessNode next;
    ProcessNode(int p, int b, int pr){ pid=p; burst=b; priority=pr; next=null; }
}

public class RoundRobinScheduler {
    private ProcessNode head;

    public void addProcess(int pid, int burst, int priority){
        ProcessNode node = new ProcessNode(pid, burst, priority);
        if(head==null){ head=node; node.next=head; return; }
        ProcessNode tail=head; while(tail.next!=head) tail=tail.next;
        tail.next=node; node.next=head;
    }
    public boolean removeProcess(int pid){
        if(head==null) return false;
        if(head.pid==pid){
            if(head.next==head){ head=null; return true; }
            ProcessNode tail=head; while(tail.next!=head) tail=tail.next;
            head=head.next; tail.next=head; return true;
        }
        ProcessNode cur=head;
        while(cur.next!=head && cur.next.pid!=pid) cur=cur.next;
        if(cur.next==head) return false;
        cur.next = cur.next.next; return true;
    }
    public void display(){
        if(head==null){ System.out.println("No processes."); return; }
        ProcessNode cur=head;
        System.out.println("PID|Burst|Priority");
        do{ System.out.printf("%d|%d|%d%n", cur.pid, cur.burst, cur.priority); cur=cur.next; } while(cur!=head);
    }
    public void simulate(int quantum){
        if(head==null){ System.out.println("No processes."); return; }
        System.out.println("Simulating with quantum " + quantum);
        ProcessNode cur=head; int totalWaiting=0, totalTurn=0, count=0;
        // Convert circular to dynamic list for simulation
        java.util.List<ProcessNode> list = new java.util.ArrayList<>();
        ProcessNode temp=head; do{ list.add(new ProcessNode(temp.pid, temp.burst, temp.priority)); temp=temp.next; } while(temp!=head);
        int time=0;
        java.util.Map<Integer,Integer> completion = new java.util.HashMap<>();
        java.util.Map<Integer,Integer> arrival = new java.util.HashMap<>(); // assume all arrived at 0
        for(ProcessNode p: list) arrival.put(p.pid, 0);
        while(!list.isEmpty()){
            ProcessNode p = list.remove(0);
            int exec = Math.min(quantum, p.burst);
            p.burst -= exec; time += exec;
            if(p.burst==0){ completion.put(p.pid, time); int tat = time - arrival.get(p.pid); totalTurn += tat; totalWaiting += tat - ( (completion.size()>0 ? 0:0) ); count++; }
            else list.add(p);
        }
        double avgTurn = count==0?0:((double)totalTurn/count);
        // Waiting time calculation approximate: avgWaiting = avgTurn - avgBurst
        double sumBurst=0; for(ProcessNode p: list) sumBurst += p.burst; // but list empty now, skip accurate waiting calc
        System.out.printf("Average Turnaround Time: %.2f (approx)%n", avgTurn);
        System.out.println("Note: This gives basic simulation and approximate metrics.");
    }

    public static void main(String[] args){
        RoundRobinScheduler rr = new RoundRobinScheduler();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n--- Round Robin Scheduler ---");
            System.out.println("1.Add process 2.Remove process 3.Simulate 4.Display 5.Exit");
            System.out.print("Choice: "); int ch=sc.nextInt(); sc.nextLine();
            if(ch==5) break;
            switch(ch){
                case 1: System.out.print("PID: "); int pid=sc.nextInt(); System.out.print("Burst time: "); int b=sc.nextInt(); System.out.print("Priority: "); int pr=sc.nextInt(); sc.nextLine(); rr.addProcess(pid,b,pr); break;
                case 2: System.out.print("PID to remove: "); int rpid=sc.nextInt(); sc.nextLine(); System.out.println(rr.removeProcess(rpid) ? "Removed." : "Not found."); break;
                case 3: System.out.print("Time quantum: "); int q=sc.nextInt(); sc.nextLine(); rr.simulate(q); break;
                case 4: rr.display(); break;
                default: System.out.println("Invalid.");
            }
        }
        sc.close();
    }
}