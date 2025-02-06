import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class prachi {
    public static void main(String[] args) throws Exception {
        new prachi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("prachi").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int row = f.nextInt(), col = f.nextInt(), sr = f.nextInt(), sc = f.nextInt();
			f.nextLine();
			char[][] m= new char[row][col];
			for (int i = 0; i < row; i++) {
				m[i] = f.nextLine().trim().toCharArray();
			}
			int[] vr = {-1,1,0,0};
			int[] vc = {0,0,-1,1};
			Queue<Integer> q = new LinkedList<>();
			q.offer(sr);
			q.offer(sc);
			while(!q.isEmpty()){
				int r = q.remove(), c = q.remove();
				if(r<0||c<0||r==m.length||c==m[r].length|| m[r][c]=='$'||m[r][c]=='#') continue;
				m[r][c] = '$';
				for (int i = 0; i < 4; i++) {
					q.offer(r+vr[i]);
					q.offer(c + vc[i]);
				}
			}
			for(char[] c : m){
				out.println(c);
			}
        }
        f.close();
    }
}
