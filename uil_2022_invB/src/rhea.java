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

public class rhea {
    public static void main(String[] args) throws Exception {
        new rhea().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("rhea").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
		String order = "ROYGBIV";
        for (int asdf = 1; asdf <= times; asdf++) {
			int row = f.nextInt(), col = f.nextInt();
			f.nextLine();
			char[][] m = new char[row][col];
			int sr = -1, sc = -1;
			for (int i = 0; i < row; i++) {
				String ln = f.nextLine().trim();
				if (ln.contains("*")) {
					sr = i;
					sc = ln.indexOf("*");
				}
				m[i] = ln.toCharArray();
			}
			int[]vr = {-1,1,0,0};
			int[] vc = {0,0,-1,1};
			boolean found = false;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(sr,sc,0));
			while(!pq.isEmpty()){
				Node cur = pq.remove();
//				out.println(cur.val);
				int r = cur.r;
				int c = cur.c;
				if(m[r][c]=='!') continue;
				if(m[r][c]=='#'){
					found = true;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nr = r + vr[i];
					int nc = c + vc[i];
					if(nr>=0&&nc>=0&&nr<row&&nc<col){
						int a = indexOf(m[r][c],order);
						int b = indexOf(m[nr][nc],order);
						if(b-a==0||b-a==1){
							pq.offer(new Node(nr,nc,b));
						}
					}
				}
				m[r][c] = '!';
			}
			if(found) out.println("yes");
			else out.println("no");
        }
        f.close();
    }
	class Node implements Comparable<Node>{
		int val;
		int r,c;
		public Node(int r, int c, int v){
			this.r = r;
			this.c = c;
			this.val = v;
		}
		public int compareTo(Node o){
			return val - o.val;
		}
	}
	public int indexOf(char ch, String order){
		if(ch=='*') return 0;
		else if(ch=='#') return order.length()-1;
		return order.indexOf(ch);
	}
}
