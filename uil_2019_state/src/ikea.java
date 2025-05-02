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

public class ikea {
	char[][][]m;
	int[][][] shadow;
	int[] vr = {-1,1,0,0};
	int[] vc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        new ikea().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ikea").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int level = f.nextInt(), row = f.nextInt(),col = f.nextInt(),need = f.nextInt();
			f.nextLine();
			m = new char[level][row][col];
			shadow = new int[level][row][col];
			int[][] item = new int[need+2][3];
			boolean found = true;
			for (int i = 0; i < item.length; i++) {
				Arrays.fill(item[i],-1);
			}
			for(int i =0 ;i < level;i++){
				for(int j = 0;j < row;j++){
					m[i][j] = f.nextLine().toCharArray();
					for (int k = 0; k < col; k++) {
						if(m[i][j][k] == 'S'){
							item[0] = new int[]{i,j,k};
						} else if (Character.isDigit(m[i][j][k])) {
							item[m[i][j][k] - '0' + 1] = new int[]{i,j,k};
						}
						else if(m[i][j][k] == 'E'){
							item[item.length-1] = new int[]{i,j,k};
						}
					}
				}
			}
			for (int i = 0; i < item.length; i++) {
//				out.println(Arrays.toString(item[i]));
				if(item[i][0] ==-1 &&  item[i][1] ==-1 && item[i][2] == -1){
//					out.println(Arrays.toString(item[i]));
					found = false;
					break;
				}
			}
			if(!found){
				out.println("IKEAnnot do it.");
			}
			else{
				int[][][] shadow= new int[level][row][col];
				for (int i = 0; i < level; i++) {
					for (int j = 0; j < row; j++) {
						Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
					}
				}
				Queue<Integer> q = new LinkedList<>();
				q.offer(item[0][0]);
				q.offer(item[0][1]);
				q.offer(item[0][2]);
				q.offer(0);
				while(!q.isEmpty()){
					int l = q.remove(), r = q.remove(), c = q.remove(), step = q.remove();
					if(l < 0 || r < 0 || c< 0 || l >= level || r >= row || c >= col || m[l][r][c]=='#' || step>=shadow[l][r][c] ) continue;
					shadow[l][r][c] = step;
					for (int i = 0; i < 4; i++) {
						int nr = r + vr[i];
						int nc = c + vc[i];
						q.offer(l);
						q.offer(nr);
						q.offer(nc);
						q.offer(step+1);
						if(m[l][r][c]=='Z'){
							q.offer(l-1);q.offer(r);q.offer(c);q.offer(step+1);
							q.offer(l+1);q.offer(r);q.offer(c);q.offer(step+1);
						}
					}
				}
				for (int i = 1; i < item.length; i++) {
					int l = item[i][0], r = item[i][1], c = item[i][2];
					if(shadow[l][r][c] == Integer.MAX_VALUE){
						found = false;
						break;
					}
				}
//				for (int i = 0; i < level; i++) {
//					for (int j = 0; j < row; j++) {
//						out.println(Arrays.toString(shadow[i][j]));
//					}
//					out.println();
//				}
				if(found) out.println("IKEAn do it.");
				else out.println("IKEAnnot do it.");
			}
		}
        f.close();
    }
}
