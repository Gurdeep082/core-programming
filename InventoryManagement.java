import java.util.Scanner;

class ItemNode {
    String name; int itemId; int qty; double price; ItemNode next;
    ItemNode(int id, String n, int q, double p){ itemId=id; name=n; qty=q; price=p; next=null; }
}

public class InventoryManagement {
    private ItemNode head;

    public void addAtBeginning(ItemNode node){ node.next=head; head=node; }
    public void addAtEnd(ItemNode node){
        if(head==null){ head=node; return; }
        ItemNode cur=head; while(cur.next!=null) cur=cur.next; cur.next=node;
    }
    public void addAtPosition(ItemNode node, int pos){
        if(pos<=1 || head==null){ addAtBeginning(node); return; }
        ItemNode cur=head; int i=1;
        while(cur.next!=null && i<pos-1){ cur=cur.next; i++; }
        node.next=cur.next; cur.next=node;
    }
    public boolean removeById(int id){
        if(head==null) return false;
        if(head.itemId==id){ head=head.next; return true; }
        ItemNode cur=head; while(cur.next!=null && cur.next.itemId!=id) cur=cur.next;
        if(cur.next==null) return false;
        cur.next=cur.next.next; return true;
    }
    public ItemNode searchById(int id){
        ItemNode cur=head; while(cur!=null){ if(cur.itemId==id) return cur; cur=cur.next; } return null;
    }
    public ItemNode searchByName(String name){
        ItemNode cur=head; while(cur!=null){ if(cur.name.equalsIgnoreCase(name)) return cur; cur=cur.next; } return null;
    }
    public void updateQuantity(int id, int newQty){ ItemNode n=searchById(id); if(n!=null) n.qty=newQty; }
    public double totalValue(){
        ItemNode cur=head; double sum=0; while(cur!=null){ sum += cur.qty * cur.price; cur=cur.next; } return sum;
    }
    // Simple merge sort by name or price
    private ItemNode mergeSort(ItemNode h, String by, boolean asc){
        if(h==null || h.next==null) return h;
        ItemNode mid = getMiddle(h); ItemNode right = mid.next; mid.next=null;
        ItemNode l = mergeSort(h,by,asc); ItemNode r = mergeSort(right,by,asc);
        return merge(l,r,by,asc);
    }
    private ItemNode merge(ItemNode a, ItemNode b, String by, boolean asc){
        ItemNode dummy=new ItemNode(0,"",0,0); ItemNode cur=dummy;
        while(a!=null && b!=null){
            int cmp=0;
            if(by.equalsIgnoreCase("price")) cmp = Double.compare(a.price, b.price);
            else cmp = a.name.compareToIgnoreCase(b.name);
            if((asc && cmp<=0) || (!asc && cmp>=0)){ cur.next=a; a=a.next; } else { cur.next=b; b=b.next; }
            cur=cur.next;
        }
        cur.next = (a!=null)?a:b;
        return dummy.next;
    }
    private ItemNode getMiddle(ItemNode h){
        if(h==null) return h;
        ItemNode slow=h, fast=h.next;
        while(fast!=null && fast.next!=null){ slow=slow.next; fast=fast.next.next; }
        return slow;
    }
    public void sort(String by, boolean asc){ head = mergeSort(head,by,asc); }

    public void display(){
        if(head==null){ System.out.println("No items."); return; }
        System.out.println("ID | Name | Qty | Price");
        ItemNode cur=head; while(cur!=null){ System.out.printf("%d | %s | %d | %.2f%n", cur.itemId, cur.name, cur.qty, cur.price); cur=cur.next; }
    }

    public static void main(String[] args){
        InventoryManagement inv = new InventoryManagement();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n--- Inventory ---");
            System.out.println("1.Add beg 2.Add end 3.Add pos 4.Remove by ID 5.Update qty 6.Search by ID 7.Search by name 8.Total value 9.Sort 10.Display 11.Exit");
            System.out.print("Choice: "); int ch=sc.nextInt(); sc.nextLine();
            if(ch==11) break;
            switch(ch){
                case 1: case 2: case 3:{
                    System.out.print("Item ID: "); int id=sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String n=sc.nextLine();
                    System.out.print("Qty: "); int q=sc.nextInt();
                    System.out.print("Price: "); double p=sc.nextDouble(); sc.nextLine();
                    ItemNode node=new ItemNode(id,n,q,p);
                    if(ch==1) inv.addAtBeginning(node);
                    else if(ch==2) inv.addAtEnd(node);
                    else { System.out.print("Position: "); int pos=sc.nextInt(); sc.nextLine(); inv.addAtPosition(node,pos); }
                    break;
                }
                case 4: System.out.print("ID to remove: "); int id=sc.nextInt(); sc.nextLine(); System.out.println(inv.removeById(id) ? "Removed." : "Not found."); break;
                case 5: System.out.print("ID: "); int idu=sc.nextInt(); System.out.print("New qty: "); int nq=sc.nextInt(); sc.nextLine(); inv.updateQuantity(idu,nq); System.out.println("Updated if existed."); break;
                case 6: System.out.print("ID to search: "); int ids=sc.nextInt(); sc.nextLine(); ItemNode it=inv.searchById(ids); if(it!=null) System.out.printf("%d %s %d %.2f%n", it.itemId,it.name,it.qty,it.price); else System.out.println("Not found."); break;
                case 7: System.out.print("Name to search: "); String ns=sc.nextLine(); ItemNode itn=inv.searchByName(ns); if(itn!=null) System.out.printf("%d %s %d %.2f%n", itn.itemId,itn.name,itn.qty,itn.price); else System.out.println("Not found."); break;
                case 8: System.out.printf("Total value: %.2f%n", inv.totalValue()); break;
                case 9: System.out.print("Sort by (name/price): "); String by=sc.nextLine(); System.out.print("Ascending? (true/false): "); boolean asc=sc.nextBoolean(); sc.nextLine(); inv.sort(by,asc); System.out.println("Sorted."); break;
                case 10: inv.display(); break;
                default: System.out.println("Invalid.");
            }
        }
        sc.close();
    }
}