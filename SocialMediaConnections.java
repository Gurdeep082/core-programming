import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class UserNode {
    int userId; String name; int age; List<Integer> friends; UserNode next;
    UserNode(int id, String n, int a){ userId=id; name=n; age=a; friends=new ArrayList<>(); next=null; }
}

public class SocialMediaConnections {
    private UserNode head;

    public void addUser(UserNode u){ u.next=head; head=u; }
    public UserNode findUser(int id){ UserNode cur=head; while(cur!=null){ if(cur.userId==id) return cur; cur=cur.next;} return null; }
    public void addFriendConnection(int id1, int id2){
        UserNode u1=findUser(id1), u2=findUser(id2);
        if(u1==null || u2==null) { System.out.println("Both users must exist."); return; }
        if(!u1.friends.contains(id2)) u1.friends.add(id2);
        if(!u2.friends.contains(id1)) u2.friends.add(id1);
    }
    public void removeFriendConnection(int id1, int id2){
        UserNode u1=findUser(id1), u2=findUser(id2);
        if(u1!=null) u1.friends.remove(Integer.valueOf(id2));
        if(u2!=null) u2.friends.remove(Integer.valueOf(id1));
    }
    public void findMutualFriends(int id1, int id2){
        UserNode u1=findUser(id1), u2=findUser(id2);
        if(u1==null || u2==null){ System.out.println("Users not found."); return; }
        List<Integer> mutual = new ArrayList<>(u1.friends);
        mutual.retainAll(u2.friends);
        System.out.println("Mutual friends: " + mutual);
    }
    public void displayFriends(int id){
        UserNode u=findUser(id);
        if(u==null) { System.out.println("User not found."); return; }
        System.out.println("Friends of " + u.name + ": " + u.friends);
    }
    public UserNode searchByNameOrId(String key, boolean byName){
        UserNode cur=head; while(cur!=null){ if(byName && cur.name.equalsIgnoreCase(key)) return cur; if(!byName && Integer.toString(cur.userId).equals(key)) return cur; cur=cur.next; } return null;
    }
    public int countFriends(int id){ UserNode u=findUser(id); return u==null?0:u.friends.size(); }

    public static void main(String[] args){
        SocialMediaConnections sm = new SocialMediaConnections();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n--- Social Media Connections ---");
            System.out.println("1.Add user 2.Add friend 3.Remove friend 4.Mutual friends 5.Display friends 6.Search user 7.Count friends 8.Exit");
            System.out.print("Choice: "); int ch=sc.nextInt(); sc.nextLine();
            if(ch==8) break;
            switch(ch){
                case 1: System.out.print("User ID: "); int id=sc.nextInt(); sc.nextLine(); System.out.print("Name: "); String name=sc.nextLine(); System.out.print("Age: "); int age=sc.nextInt(); sc.nextLine(); sm.addUser(new UserNode(id,name,age)); break;
                case 2: System.out.print("User1 ID: "); int a=sc.nextInt(); System.out.print("User2 ID: "); int b=sc.nextInt(); sc.nextLine(); sm.addFriendConnection(a,b); break;
                case 3: System.out.print("User1 ID: "); int c=sc.nextInt(); System.out.print("User2 ID: "); int d=sc.nextInt(); sc.nextLine(); sm.removeFriendConnection(c,d); break;
                case 4: System.out.print("User1 ID: "); int m1=sc.nextInt(); System.out.print("User2 ID: "); int m2=sc.nextInt(); sc.nextLine(); sm.findMutualFriends(m1,m2); break;
                case 5: System.out.print("User ID: "); int uid=sc.nextInt(); sc.nextLine(); sm.displayFriends(uid); break;
                case 6: System.out.print("Search by name? (y/n): "); String yn=sc.nextLine(); if(yn.equalsIgnoreCase("y")) { System.out.print("Name: "); String nm=sc.nextLine(); UserNode u=sm.searchByNameOrId(nm,true); if(u!=null) System.out.println(u.userId + " " + u.name + " " + u.age); else System.out.println("Not found."); } else { System.out.print("User ID: "); String idstr=sc.nextLine(); UserNode u=sm.searchByNameOrId(idstr,false); if(u!=null) System.out.println(u.userId + " " + u.name + " " + u.age); else System.out.println("Not found."); } break;
                case 7: System.out.print("User ID: "); int fid=sc.nextInt(); sc.nextLine(); System.out.println("Friend count: " + sm.countFriends(fid)); break;
                default: System.out.println("Invalid.");
            }
        }
        sc.close();
    }
}