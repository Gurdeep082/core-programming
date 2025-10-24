import java.util.Scanner;

class TextStateNode {
    String text; TextStateNode prev, next;
    TextStateNode(String t){ text=t; prev=next=null; }
}

public class UndoRedoTextEditor {
    private TextStateNode head, current; private int limit, size;
    public UndoRedoTextEditor(int limit){ this.limit=limit; size=0; head=current=null; }
    public void addState(String text){
        TextStateNode node = new TextStateNode(text);
        if(current==null){ head=current=node; size=1; return; }
        // discard forward history
        current.next = node; node.prev = current; current = node; size++;
        // enforce limit
        while(size>limit){
            // remove head
            head = head.next; head.prev = null; size--;
        }
    }
    public void undo(){
        if(current!=null && current.prev!=null) current = current.prev;
        else System.out.println("Cannot undo.");
    }
    public void redo(){
        if(current!=null && current.next!=null) current = current.next;
        else System.out.println("Cannot redo.");
    }
    public void displayCurrent(){ if(current==null) System.out.println("[empty]"); else System.out.println("Current: " + current.text); }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        UndoRedoTextEditor editor = new UndoRedoTextEditor(10);
        while(true){
            System.out.println("\n--- Text Editor ---");
            System.out.println("1.Add state 2.Undo 3.Redo 4.Display current 5.Exit");
            System.out.print("Choice: "); int ch=sc.nextInt(); sc.nextLine();
            if(ch==5) break;
            switch(ch){
                case 1: System.out.print("Enter text state: "); String t=sc.nextLine(); editor.addState(t); break;
                case 2: editor.undo(); break;
                case 3: editor.redo(); break;
                case 4: editor.displayCurrent(); break;
                default: System.out.println("Invalid.");
            }
        }
        sc.close();
    }
}