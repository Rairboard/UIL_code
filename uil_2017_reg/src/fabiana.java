import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class fabiana {
    public static void main(String[] args) throws Exception {
        new fabiana().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("fabiana").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String ln = f.next();
            int in = f.nextInt();
            f.nextLine();
            Node root = new Node(ln.charAt(0),0);
            for (int i = 1; i < ln.length(); i++) {
                root = add(root,ln.charAt(i),i);
            }
            out.println(recur(root,0,in));
        }
        f.close();
    }
    class Node{
        Node l, r;
        char val;
        int index;
        public Node(char c,int in){
            val = c;
            l = null;
            r = null;
            index = in;
        }
    }
    public Node add(Node cur, char val,int index){
        if(cur==null){
            return new Node(val,index);
        }
        else if(cur.val>= val){
            cur.l = add(cur.l,val,index);
        }
        else {
            cur.r = add(cur.r,val,index);
        }
        return cur;
    }
    public int recur(Node cur, int depth,int index){
        if(cur!=null){
            if(cur.index == index){
                return depth;
            }
            int left = recur(cur.l,depth+1,index);
            int right = recur(cur.r,depth+1,index);
            if(left!=-1){
                return left;
            }
            if(right!=-1){
                return right;
            }
        }
        return -1;
    }
}
