import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class jimothy {
    public static void main(String[] args) throws Exception {
        new jimothy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("jimothy").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().split("\\s+");
            Node root = new Node(ln[0]);
            for(int i = 1 ; i < ln.length;i++){
                root = add(root,ln[i]);
            }
            out.println("TEST CASE #" + asdf + ": ");
            out.print("PRE-ORDER TRAVERSAL: ");
            pre(root);
            out.print("\nIN-ORDER TRAVERSAL: ");
            in(root);
            out.print("\nPOST-ORDER TRAVERSAL: ");
            post(root);
            out.print("\nREVERSE-ORDER TRAVERSAL: ");
            rev(root);
            out.println();
        }
        f.close();
    }
    class Node{
        String s;
        Node left, right;
        public Node(String str){
            s = str;
        }
    }
    public Node add(Node cur, String val){
        if(cur==null){
            return new Node(val);
        }
        if(cur.s.compareTo(val)<0){
            cur.right = add(cur.right,val);
        }
        else{
            cur.left = add(cur.left,val);
        }
        return cur;
    }
    public void in(Node cur){
        if(cur==null)return;
        in(cur.left);
        out.print(cur.s +" ");
        in(cur.right);
    }
    public void pre(Node cur){
        if(cur==null)return;
        out.print(cur.s +" ");
        pre(cur.left);
        pre(cur.right);
    }
    public void post(Node cur){
        if(cur==null)return;
        post(cur.left);
        post(cur.right);
        out.print(cur.s +" ");
    }
    public void rev(Node cur){
        if(cur==null)return;
        rev(cur.right);
        out.print(cur.s +" ");
        rev(cur.left);
    }
}
