import java.util.Scanner;

class MovieNode {
    String title, director; int year; double rating; MovieNode prev, next;
    MovieNode(String t, String d, int y, double r){ title=t; director=d; year=y; rating=r; prev=next=null; }
}

public class MovieManagementSystem {
    private MovieNode head, tail;
    public void addAtBeginning(MovieNode node){
        if(head==null){ head=tail=node; return; }
        node.next = head; head.prev = node; head = node;
    }
    public void addAtEnd(MovieNode node){
        if(tail==null){ head=tail=node; return; }
        tail.next=node; node.prev=tail; tail=node;
    }
    public void addAtPosition(MovieNode node, int pos){
        if(pos<=1 || head==null){ addAtBeginning(node); return; }
        MovieNode cur=head; int i=1;
        while(cur.next!=null && i<pos-1){ cur=cur.next; i++; }
        if(cur.next==null){ addAtEnd(node); return; }
        node.next = cur.next; node.prev = cur; cur.next.prev = node; cur.next = node;
    }
    public boolean removeByTitle(String title){
        MovieNode cur=head;
        while(cur!=null){
            if(cur.title.equalsIgnoreCase(title)){
                if(cur.prev!=null) cur.prev.next = cur.next; else head=cur.next;
                if(cur.next!=null) cur.next.prev = cur.prev; else tail=cur.prev;
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    public void searchByDirectorOrRating(String key, double rating){
        MovieNode cur=head; boolean found=false;
        while(cur!=null){
            if((key!=null && cur.director.equalsIgnoreCase(key)) || (rating>=0 && cur.rating==rating)){
                System.out.printf("%s | %s | %d | %.1f%n", cur.title, cur.director, cur.year, cur.rating);
                found=true;
            }
            cur=cur.next;
        }
        if(!found) System.out.println("No matches.");
    }
    public boolean updateRating(String title, double newRating){
        MovieNode cur=head;
        while(cur!=null){
            if(cur.title.equalsIgnoreCase(title)){ cur.rating=newRating; return true; }
            cur=cur.next;
        }
        return false;
    }
    public void displayForward(){
        if(head==null){ System.out.println("No movies."); return; }
        MovieNode cur=head; System.out.println("Title | Director | Year | Rating");
        while(cur!=null){ System.out.printf("%s | %s | %d | %.1f%n", cur.title, cur.director, cur.year, cur.rating); cur=cur.next; }
    }
    public void displayReverse(){
        if(tail==null){ System.out.println("No movies."); return; }
        MovieNode cur=tail; System.out.println("Title | Director | Year | Rating");
        while(cur!=null){ System.out.printf("%s | %s | %d | %.1f%n", cur.title, cur.director, cur.year, cur.rating); cur=cur.prev; }
    }

    public static void main(String[] args){
        MovieManagementSystem list = new MovieManagementSystem();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n--- Movie Management ---");
            System.out.println("1.Add at beginning 2.Add at end 3.Add at position 4.Remove by title 5.Search 6.Update rating 7.Display forward 8.Display reverse 9.Exit");
            System.out.print("Choice: "); int ch=sc.nextInt(); sc.nextLine();
            if(ch==9) break;
            switch(ch){
                case 1: case 2: case 3:{
                    System.out.print("Title: "); String t=sc.nextLine();
                    System.out.print("Director: "); String d=sc.nextLine();
                    System.out.print("Year: "); int y=sc.nextInt();
                    System.out.print("Rating: "); double r=sc.nextDouble(); sc.nextLine();
                    MovieNode node=new MovieNode(t,d,y,r);
                    if(ch==1) list.addAtBeginning(node);
                    else if(ch==2) list.addAtEnd(node);
                    else { System.out.print("Position: "); int p=sc.nextInt(); sc.nextLine(); list.addAtPosition(node,p); }
                    break;
                }
                case 4: System.out.print("Title to remove: "); String title=sc.nextLine(); System.out.println(list.removeByTitle(title) ? "Removed." : "Not found."); break;
                case 5:{
                    System.out.print("Search by director (enter name or empty): "); String dir=sc.nextLine();
                    System.out.print("Or search by rating (enter -1 to skip): "); double rating=sc.nextDouble(); sc.nextLine();
                    list.searchByDirectorOrRating(dir.isEmpty()?null:dir, rating);
                    break;
                }
                case 6: System.out.print("Title: "); String tt=sc.nextLine(); System.out.print("New rating: "); double nr=sc.nextDouble(); sc.nextLine(); System.out.println(list.updateRating(tt,nr) ? "Updated." : "Not found."); break;
                case 7: list.displayForward(); break;
                case 8: list.displayReverse(); break;
                default: System.out.println("Invalid."); 
            }
        }
        sc.close();
    }
}