import java.util.Scanner;

class BookNode {
    int bookId; String title, author, genre; boolean available; BookNode prev, next;
    BookNode(int id, String t, String a, String g, boolean av){ bookId=id; title=t; author=a; genre=g; available=av; prev=next=null; }
}

public class LibraryManagementDoubly {
    private BookNode head, tail;
    public void addAtBeginning(BookNode node){
        if(head==null){ head=tail=node; return; }
        node.next=head; head.prev=node; head=node;
    }
    public void addAtEnd(BookNode node){
        if(tail==null){ head=tail=node; return; }
        tail.next=node; node.prev=tail; tail=node;
    }
    public void addAtPosition(BookNode node, int pos){
        if(pos<=1 || head==null){ addAtBeginning(node); return; }
        BookNode cur=head; int i=1;
        while(cur.next!=null && i<pos-1){ cur=cur.next; i++; }
        if(cur.next==null){ addAtEnd(node); return; }
        node.next=cur.next; node.prev=cur; cur.next.prev=node; cur.next=node;
    }
    public boolean removeById(int id){
        BookNode cur=head;
        while(cur!=null){
            if(cur.bookId==id){
                if(cur.prev!=null) cur.prev.next=cur.next; else head=cur.next;
                if(cur.next!=null) cur.next.prev=cur.prev; else tail=cur.prev;
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    public void searchByTitleOrAuthor(String key){
        BookNode cur=head; boolean found=false;
        while(cur!=null){
            if(cur.title.equalsIgnoreCase(key) || cur.author.equalsIgnoreCase(key)){
                System.out.printf("%d | %s | %s | %s | %s%n", cur.bookId, cur.title, cur.author, cur.genre, cur.available?"Available":"Not");
                found=true;
            }
            cur=cur.next;
        }
        if(!found) System.out.println("No matches.");
    }
    public boolean updateAvailability(int id, boolean status){
        BookNode cur=head;
        while(cur!=null){
            if(cur.bookId==id){ cur.available=status; return true; }
            cur=cur.next;
        }
        return false;
    }
    public void displayForward(){
        if(head==null){ System.out.println("No books."); return; }
        BookNode cur=head; System.out.println("ID|Title|Author|Genre|Available");
        while(cur!=null){ System.out.printf("%d|%s|%s|%s|%s%n", cur.bookId,cur.title,cur.author,cur.genre,cur.available?"Yes":"No"); cur=cur.next; }
    }
    public void displayReverse(){
        if(tail==null){ System.out.println("No books."); return; }
        BookNode cur=tail; System.out.println("ID|Title|Author|Genre|Available");
        while(cur!=null){ System.out.printf("%d|%s|%s|%s|%s%n", cur.bookId,cur.title,cur.author,cur.genre,cur.available?"Yes":"No"); cur=cur.prev; }
    }
    public int countBooks(){ int c=0; BookNode cur=head; while(cur!=null){ c++; cur=cur.next; } return c; }

    public static void main(String[] args){
        LibraryManagementDoubly lib = new LibraryManagementDoubly();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n--- Library Management ---");
            System.out.println("1.Add beg 2.Add end 3.Add pos 4.Remove by ID 5.Search by title/author 6.Update availability 7.Display forward 8.Display reverse 9.Count books 10.Exit");
            System.out.print("Choice: "); int ch=sc.nextInt(); sc.nextLine();
            if(ch==10) break;
            switch(ch){
                case 1: case 2: case 3:{
                    System.out.print("Book ID: "); int id=sc.nextInt(); sc.nextLine();
                    System.out.print("Title: "); String t=sc.nextLine();
                    System.out.print("Author: "); String a=sc.nextLine();
                    System.out.print("Genre: "); String g=sc.nextLine();
                    System.out.print("Available (true/false): "); boolean av=sc.nextBoolean(); sc.nextLine();
                    BookNode node = new BookNode(id,t,a,g,av);
                    if(ch==1) lib.addAtBeginning(node);
                    else if(ch==2) lib.addAtEnd(node);
                    else { System.out.print("Position: "); int p=sc.nextInt(); sc.nextLine(); lib.addAtPosition(node,p); }
                    break;
                }
                case 4: System.out.print("ID to remove: "); int id=sc.nextInt(); sc.nextLine(); System.out.println(lib.removeById(id) ? "Removed." : "Not found."); break;
                case 5: System.out.print("Title or Author to search: "); String key=sc.nextLine(); lib.searchByTitleOrAuthor(key); break;
                case 6: System.out.print("Book ID: "); int idu=sc.nextInt(); System.out.print("Available (true/false): "); boolean st=sc.nextBoolean(); sc.nextLine(); System.out.println(lib.updateAvailability(idu,st) ? "Updated." : "Not found."); break;
                case 7: lib.displayForward(); break;
                case 8: lib.displayReverse(); break;
                case 9: System.out.println("Total books: " + lib.countBooks()); break;
                default: System.out.println("Invalid.");
            }
        }
        sc.close();
    }
}