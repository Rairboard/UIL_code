import java.util.*;
import java.io.*;

public class lucia {
	static Tree t;
    public static void main(String[] args) throws Exception {
        new lucia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("lucia.dat"));
        //Scanner f = new Scanner(System.in);
		int rv = f.nextInt();
		t = new Tree(rv);
		while(f.hasNext()){
			add(t.root,f.nextInt());
		}
		System.out.print("Preorder: ");
		preOrder(t.root);
		System.out.println();
		System.out.print("Postorder: ");
		postOrder(t.root);
		System.out.println();
        f.close();
    }
	class Node{
		int value;
		Node left,middle, right;
		public Node(int val){
			value = val;
			left = null;
			middle = null;
			right = null;
		}
	}
	class Tree{
		Node root;
		public Tree(int rv){
			root = new Node(rv);
		}
	}
	public Node add(Node cur,int val){
		if(cur==null){
			return new Node(val);
		}
		if(val < cur.value - 5){
			cur.left = add(cur.left,val);
		}
		else if(val > cur.value+5){
			cur.right = add(cur.right,val);
		}else{
			cur.middle = add(cur.middle,val);
		}
		return cur;
	}
	public void postOrder(Node cur){
		if(cur!=null) {
			postOrder(cur.left);
			postOrder(cur.middle);
			postOrder(cur.right);
			System.out.print(cur.value+" ");
		}
	}
	public void preOrder(Node cur){
		if(cur!=null){
			System.out.print(cur.value+" ");
			preOrder(cur.left);
			preOrder(cur.middle);
			preOrder(cur.right);
		}
	}
}
