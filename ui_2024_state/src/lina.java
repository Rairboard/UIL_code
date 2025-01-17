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

public class lina {
    public static void main(String[] args) throws Exception {
        new lina().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("lina").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String[] ln = f.nextLine().trim().split("\\s+");
			Node root = new Node(ln[0]);
			for(int i =1 ;i < ln.length;i++){
				root = add(root,ln[i]);
			}
			int left = countConnection(root.left);
			int right = countConnection(root.right);
			int diameter = left + right;
			int height = Math.max(left,right);
			int leaf = countLeaf(root);
			int width = 0;
			Queue<Node> q = new LinkedList<>();
			q.offer(root);
			while(!q.isEmpty()){
				int size = q.size();
				width = Math.max(width,size);
				for (int i = 0; i < size; i++) {
					Node cur = q.poll();
					if(cur.left!=null) q.offer(cur.left);
					if(cur.right!=null) q.offer(cur.right);
				}
			}
			out.println("TEST CASE #" +asdf + ":");
			out.println("DIAMETER OF THE TREE: " + diameter);
			out.println("WIDTH OF THE TREE: " + width);
			out.println("HEIGHT OF THE TREE: " + height);
			out.println("NUMBER OF LEAVES IN THE TREE: " + leaf);
        }
        f.close();
    }
	public int countLeaf(Node cur){
		if(cur.left==null&&cur.right==null) return 1;
        int leaf = 0;
		if(cur.left!=null) leaf+= countLeaf(cur.left);
		if(cur.right!=null) leaf += countLeaf(cur.right);
		return leaf;
	}
	public int countConnection(Node cur){
		if(cur==null) return 0;
		int[] best = {-1,-1};
		best[0] = countConnection(cur.left);
		best[1] = countConnection(cur.right);
		return 1 + Math.max(best[0],best[1]);
	}
	class Node{
		String val;
		Node left, right;
		public Node(String v){
			val = v;
		}
	}
	public Node add(Node cur, String val){
		if(cur==null) return new Node(val);
		if(val.compareTo(cur.val) <= 0){
			cur.left = add(cur.left,val);
		}
		else{
			cur.right = add(cur.right,val);
		}
		return cur;
	}
}
