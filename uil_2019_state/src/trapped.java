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

public class trapped {
    public static void main(String[] args) throws Exception {
        new trapped().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("trapped").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        o : for (int asdf = 1; asdf <= times; asdf++) {
			int row = f.nextInt(),sr = -1, sc = -1;
			f.nextLine();
			char[][] m = new char[row][row];
			for (int i = 0; i < row; i++) {
				String ln = f.nextLine();
				m[i] = ln.toCharArray();
				if (ln.contains("@")) {
					sr = i;
					sc = ln.indexOf("@");
				}
			}
			Queue<Integer> q = new LinkedList<>();
			q.offer(sr);
			q.offer(sc);
			while(!q.isEmpty()){
				int r = q.remove(), c = q.remove();
				if(r==-1||c==-1||r==row||c==row||m[r][c]=='*') continue;
				if(r==0||c==0||r==row-1||c==row-1){
					if(m[r][c]=='.'||m[r][c]=='@'){
						out.println("Exit");
						continue o;
					}
				}
				int[] vr = {-1,1,0,0};
				int[] vc = {0,0,-1,1};
				for (int i = 0; i < 4; i++) {
					q.offer(r+vr[i]);
					q.offer(c+vc[i]);
				}
				m[r][c] = '*';
			}
			out.println("No Exit");
        }
        f.close();
    }
}
