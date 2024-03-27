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

public class thirteen2 {
	char[][] m;
	int min;
    public static void main(String[] args) throws Exception {
        new thirteen2().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("thirteen").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			m = new char[10][10];
			min=Integer.MAX_VALUE;

			for (int i = 0; i < 10; i++) {
				m[i]=f.nextLine().toCharArray();
			}

			recur(0,0,0,0);
			out.println(min);
        }
        f.close();
    }
	public void recur(int r,int c,int jw,int step){
		try{
			if(m[r][c]=='#'){
				return;
			}
		}catch(Exception e){
			return;
		}
		if(m[r][c]=='E'){
			if(jw == 13){
				min = Math.min(min,step);
				return;
			}
		}
		if(m[r][c]=='*'){
			jw++;
		}
		char save = m[r][c];
		m[r][c] = '#';
		recur(r-1,c,jw,step+1);
		recur(r+1,c,jw,step+1);
		recur(r,c-1,jw,step+1);
		recur(r,c+1,jw,step+1);
		m[r][c] = save;
	}
}
