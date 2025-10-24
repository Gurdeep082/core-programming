import java.util.Scanner;

class TicketNode {
    int ticketId; String customer, movie, seat, bookingTime; TicketNode next;
    TicketNode(int id, String c, String m, String s, String b){ ticketId=id; customer=c; movie=m; seat=s; bookingTime=b; next=null; }
}

public class TicketReservationCircular {
    private TicketNode head;

    public void addAtEnd(TicketNode node){
        if(head==null){ head=node; node.next=head; return; }
        TicketNode tail=head; while(tail.next!=head) tail=tail.next;
        tail.next=node; node.next=head;
    }
    public boolean removeById(int id){
        if(head==null) return false;
        if(head.ticketId==id){
            if(head.next==head){ head=null; return true; }
            TicketNode tail=head; while(tail.next!=head) tail=tail.next;
            head = head.next; tail.next=head; return true;
        }
        TicketNode cur=head;
        while(cur.next!=head && cur.next.ticketId!=id) cur=cur.next;
        if(cur.next==head) return false;
        cur.next = cur.next.next; return true;
    }
    public void display(){
        if(head==null){ System.out.println("No tickets."); return; }
        TicketNode cur=head; System.out.println("ID|Customer|Movie|Seat|Time");
        do{ System.out.printf("%d|%s|%s|%s|%s%n", cur.ticketId,cur.customer,cur.movie,cur.seat,cur.bookingTime); cur=cur.next; } while(cur!=head);
    }
    public void searchByCustomerOrMovie(String key, boolean byCustomer){
        if(head==null){ System.out.println("No tickets."); return; }
        TicketNode cur=head; boolean found=false;
        do{
            if((byCustomer && cur.customer.equalsIgnoreCase(key)) || (!byCustomer && cur.movie.equalsIgnoreCase(key))){
                System.out.printf("%d|%s|%s|%s|%s%n", cur.ticketId,cur.customer,cur.movie,cur.seat,cur.bookingTime); found=true;
            }
            cur=cur.next;
        } while(cur!=head);
        if(!found) System.out.println("No matches.");
    }
    public int countTickets(){ if(head==null) return 0; int c=0; TicketNode cur=head; do{ c++; cur=cur.next; } while(cur!=head); return c; }

    public static void main(String[] args){
        TicketReservationCircular sys = new TicketReservationCircular();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n--- Ticket Reservation ---");
            System.out.println("1.Add ticket 2.Remove by ID 3.Display 4.Search 5.Count 6.Exit");
            System.out.print("Choice: "); int ch=sc.nextInt(); sc.nextLine();
            if(ch==6) break;
            switch(ch){
                case 1: System.out.print("Ticket ID: "); int id=sc.nextInt(); sc.nextLine(); System.out.print("Customer: "); String c=sc.nextLine(); System.out.print("Movie: "); String m=sc.nextLine(); System.out.print("Seat: "); String s=sc.nextLine(); System.out.print("Booking time: "); String b=sc.nextLine(); sys.addAtEnd(new TicketNode(id,c,m,s,b)); break;
                case 2: System.out.print("ID to remove: "); int rid=sc.nextInt(); sc.nextLine(); System.out.println(sys.removeById(rid) ? "Removed." : "Not found."); break;
                case 3: sys.display(); break;
                case 4: System.out.print("Search by customer? (y/n): "); String yn=sc.nextLine(); if(yn.equalsIgnoreCase("y")){ System.out.print("Customer name: "); String k=sc.nextLine(); sys.searchByCustomerOrMovie(k,true);} else { System.out.print("Movie name: "); String k=sc.nextLine(); sys.searchByCustomerOrMovie(k,false);} break;
                case 5: System.out.println("Total tickets: " + sys.countTickets()); break;
                default: System.out.println("Invalid.");
            }
        }
        sc.close();
    }
}