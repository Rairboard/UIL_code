import java.util.*;
import java.io.File;
import java.util.Arrays;

import static java.lang.System.*;

public class babydriver_ThanhLe {
	char[][] m;
	int[][] shadow;
	boolean solved;
    public static void main(String[] args) throws Exception {
        new babydriver_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("babydriver").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		int row = f.nextInt(), col = f.nextInt();
		f.nextLine();
        m = new char[row][col];
		shadow = new int[row][col];
		for (int i = 0; i < row; i++) {
			m[i] = f.nextLine().toCharArray();
		}
		while(f.hasNext()){
			for (int i = 0; i < row; i++) {
				Arrays.fill(shadow[i],Integer.MAX_VALUE);
			}
			int sr = f.nextInt(), sc =f.nextInt();
			int[] vr = {-1,1,0,0};
			int[] vc = {0,0,-1,1};
			Queue<Integer> q = new LinkedList<>();
			q.offer(sr);
			q.offer(sc);
			q.offer(0);
			solved = false;
			while(!q.isEmpty()){
				int r = q.remove(), c = q.remove(), step = q.remove();
				if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#'&&step<shadow[r][c]){
					shadow[r][c] = step;
					if(m[r][c]=='E'){
						solved = true;
						break;
					}
					for (int i = 0; i < 4; i++) {
						int nr = r + vr[i];
						int nc = c + vc[i];
						q.offer(nr);
						q.offer(nc);
						q.offer(step+1);
					}
				}
			}
			out.println(solved ? "We're gonna make it out!":"We're a little cooked.");
		}
        f.close();
    }
}
