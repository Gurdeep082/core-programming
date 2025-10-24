import java.util.Scanner;

class StudentNode {
    int rollNo; String name; int age; String grade; StudentNode next;
    StudentNode(int r, String n, int a, String g){ rollNo=r; name=n; age=a; grade=g; next=null; }
}

public class StudentRecordManagement {
    private StudentNode head;

    public void addAtBeginning(StudentNode node){
        node.next = head; head = node;
    }
    public void addAtEnd(StudentNode node){
        if(head==null){ head=node; return; }
        StudentNode cur = head;
        while(cur.next!=null) cur=cur.next;
        cur.next=node;
    }
    public void addAtPosition(StudentNode node, int pos){
        if(pos<=1 || head==null){ addAtBeginning(node); return; }
        StudentNode cur=head; int i=1;
        while(cur!=null && i<pos-1){ cur=cur.next; i++; }
        if(cur==null) addAtEnd(node);
        else { node.next = cur.next; cur.next=node; }
    }
    public boolean deleteByRoll(int roll){
        if(head==null) return false;
        if(head.rollNo==roll){ head=head.next; return true; }
        StudentNode cur=head;
        while(cur.next!=null && cur.next.rollNo!=roll) cur=cur.next;
        if(cur.next==null) return false;
        cur.next = cur.next.next; return true;
    }
    public StudentNode searchByRoll(int roll){
        StudentNode cur=head; while(cur!=null){ if(cur.rollNo==roll) return cur; cur=cur.next; }
        return null;
    }
    public void updateGrade(int roll, String newGrade){
        StudentNode s = searchByRoll(roll);
        if(s!=null) s.grade=newGrade;
    }
    public void display(){
        if(head==null){ System.out.println("No records."); return; }
        StudentNode cur=head;
        System.out.println("Roll\tName\tAge\tGrade");
        while(cur!=null){
            System.out.printf("%d\t%s\t%d\t%s%n", cur.rollNo, cur.name, cur.age, cur.grade);
            cur=cur.next;
        }
    }

    public static void main(String[] args){
        StudentRecordManagement list = new StudentRecordManagement();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n--- Student Records Menu ---");
            System.out.println("1. Add at beginning\n2. Add at end\n3. Add at position\n4. Delete by roll\n5. Search by roll\n6. Update grade\n7. Display all\n8. Exit");
            System.out.print("Choice: "); int ch=sc.nextInt();
            if(ch==8) break;
            switch(ch){
                case 1: case 2: case 3: {
                    System.out.print("Roll: "); int r=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String n=sc.nextLine();
                    System.out.print("Age: "); int a=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: "); String g=sc.nextLine();
                    StudentNode node = new StudentNode(r,n,a,g);
                    if(ch==1) list.addAtBeginning(node);
                    else if(ch==2) list.addAtEnd(node);
                    else { System.out.print("Position (1-based): "); int p=sc.nextInt(); list.addAtPosition(node,p); }
                    break;
                }
                case 4: {
                    System.out.print("Roll to delete: "); int r=sc.nextInt(); boolean ok=list.deleteByRoll(r); System.out.println(ok ? "Deleted." : "Not found."); break;
                }
                case 5: {
                    System.out.print("Roll to search: "); int r=sc.nextInt(); StudentNode s=list.searchByRoll(r); if(s!=null) System.out.printf("Found: %d %s %d %s%n", s.rollNo,s.name,s.age,s.grade); else System.out.println("Not found."); break;
                }
                case 6: {
                    System.out.print("Roll to update: "); int r=sc.nextInt(); sc.nextLine(); System.out.print("New Grade: "); String g=sc.nextLine(); list.updateGrade(r,g); System.out.println("Updated if existed."); break;
                }
                case 7: list.display(); break;
                default: System.out.println("Invalid.");
            }
        }
        sc.close();
    }
}