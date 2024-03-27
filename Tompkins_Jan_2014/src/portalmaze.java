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

public class portalmaze {
	char[][] m;
	int[][] shadow;
	boolean found;
	int min ;
	Map<Character,List<int[]>> portal;
    public static void main(String[] args) throws Exception {
        new portalmaze().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("portalmaze").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String[] cor = f.nextLine().split("x");
			int r = Integer.parseInt(cor[1]), c = Integer.parseInt(cor[0]), sr = -1, sc = -1;
			m = new char[r][c];
			shadow = new int[r][c];
			found = false;
			portal = new HashMap<>();
			min = Integer.MAX_VALUE;
			for (int i = 0; i < r; i++) {
				m[i] = f.nextLine().toCharArray();
				Arrays.fill(shadow[i],Integer.MIN_VALUE);
				for (int j = 0; j < m[i].length; j++) {
					if(m[i][j]=='#'){
						sr = i;
						sc = j;
					}
					if((""+ m[i][j]).matches("[A-Z]")){
						portal.putIfAbsent(m[i][j], new ArrayList<>());
						portal.get(m[i][j]).add(new int[]{i,j});
					}
				}
			}
			Set<Character> item = new HashSet<>();
			recur(sr,sc,0,item);
			out.println(min + " seconds");
            for(Character cc : portal.keySet()){
                for(int[] i : portal.get(cc)){
                    out.println(cc + " " + i[0] + " " + i[1]);
                }
                out.println();
            }
        }
        f.close();
    }
	public void recur(int r, int c, int step, Set<Character> item){
		if(r>=0&&c>=0&&r<m.length && c<m[r].length&&m[r][c]!='*' && item.size() > shadow[r][c]){
			if(item.size() == 3){
				min = Math.min(min,step);
				found = true;
				return;
			}
			char save = m[r][c];
			m[r][c] = '*';
			shadow[r][c] = item.size();
			if (("" + save).matches("[A-Z]")) {
				for(int[] cor : portal.get(save)){
					if(!(r == cor[0] && c == cor[1])){
						recur(cor[0],cor[1],step,item);
                        break;
					}
				}
			}
			if ((""+save).matches("[0-9]")) {
				item.add(save);
			}
			recur(r-1,c,step+1,item);
			recur(r+1,c,step+1,item);
			recur(r,c-1,step+1,item);
			recur(r,c+1,step+1,item);
			m[r][c] = save;
		}
	}
}
