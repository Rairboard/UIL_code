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
        out: for (int asdf = 1; asdf <= times; asdf++) {
			int row = f.nextInt(), col = f.nextInt();
			int sr = -1, sc = -1;
			f.nextLine();
			char[][] m = new char[row][col];
			for (int i = 0; i < row; i++) {
				String ln = f.nextLine().trim();
				m[i] = ln.toCharArray();
				if (ln.contains("*")) {
					sr = i;
					sc = ln.indexOf("*");
				}
			}
			int[] vr = {-1,1,0,0};
			int[] vc = {0,0,-1,1};
			Queue<Integer> q = new LinkedList<>();
			q.offer(sr);
			q.offer(sc);
			while(!q.isEmpty()){
				int r = q.remove(), c = q.remove();
				if(m[r][c]=='#'){
                    out.println("yes");
					continue out;
				}
                if(m[r][c]=='!') continue;
				for (int i = 0; i < 4; i++) {
					int nr = r + vr[i];
					int nc = c + vc[i];
					if(nr>=0&&nc>=0&&nr<row&&nc<col){
						int a = indexOf(m[r][c], order);
                        int b = indexOf(m[nr][nc], order);
						if(b-a == 1 || b - a == 0){
                            q.offer(nr);
                            q.offer(nc);
                        }
					}
				}
                m[r][c] = '!';
//                for(char[] cc : m){
//                    out.println(cc);
//                }
//                out.println();
			}
            out.println("no");
        }
        f.close();
    }
    public int indexOf(char ch, String order){
        if(ch=='*') return order.indexOf("R");
        if(ch=='#') return order.indexOf("V");
        return order.indexOf(ch);
    }
}
