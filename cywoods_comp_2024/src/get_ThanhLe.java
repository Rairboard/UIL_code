import java.util.*;
import java.io.File;
import java.util.Arrays;

import static java.lang.System.*;

public class get_ThanhLe {
	boolean solved ;
	char[][][] m;
	int[][][] shadow;
    public static void main(String[] args) throws Exception {
        new get_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("get").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		while(f.hasNext()){
			int N = f.nextInt(), sl = -1, sr = -1, sc = -1;
			f.nextLine();
			 m = new char[N][N][N];
			shadow = new int[N][N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
					String ln =f.nextLine().trim();
					if (ln.contains("S")) {
						sl = i;
						sr = j;
						sc = ln.indexOf("S");
					}
					m[i][j] = ln.toCharArray();
				}
			}
			solved = false;
			recur(sl,sr,sc,0);
			out.println(solved ? "Escape Possible":"No Escape");
		}
        f.close();
    }
	public void recur(int level, int row, int col, int step){
		if(level>=0&&level<m.length && row>=0&&row<m[level].length && col>=0 && col< m[level][row].length && m[level][row][col]!='0' && step < shadow[level][row][col]){
			if(m[level][row][col]=='E'){
				solved = true;
				return;
			}
			shadow[level][row][col] = step;
			recur(level-1,row,col,step+1);
			recur(level+1,row,col,step+1);
			recur(level,row-1,col,step+1);
			recur(level,row+1,col,step+1);
			recur(level,row,col-1,step+1);
			recur(level,row,col+1,step+1);
		}
	}
}
