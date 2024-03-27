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
	boolean found;
    public static void main(String[] args) throws Exception {
        new ikea().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ikea").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int level = f.nextInt(), row = f.nextInt(),col = f.nextInt(),need = f.nextInt(), sl = -1, sr =-1, sc = -1;
			f.nextLine();
			m = new char[level][row][col];
			shadow = new int[level][row][col];
			found = false;
			for (int l = 0; l < level; l++) {
				for (int r = 0; r < row; r++) {
					String ln = f.nextLine();
					m[l][r] = ln.toCharArray();
					Arrays.fill(shadow[l][r],Integer.MIN_VALUE);
					if (ln.contains("S")) {
						sl = l;
						sr = r;
						sc = ln.indexOf("S");
					}
				}
			}
			HashSet<Character> hs = new HashSet<>();
			recur(sl,sr,sc,hs,need);
			out.println(found?"IKEAn do it.":"IKEAnnot do it");
        }
        f.close();
    }
	public void recur(int l, int r, int c, Set<Character> item, int need){
		if(l>=0&&r>=0&&c>=0&&l<m.length&&r<m[l].length&&c<m[l][r].length && m[l][r][c]!='#'&& item.size() > shadow[l][r][c]){
			char save = m[l][r][c];
			shadow[l][r][c] = item.size();
			if(m[l][r][c]=='E'){
				if(item.size()==need){
					found = true;
				}
				return;
			}
			m[l][r][c] = '#';
			if(save=='Z'){
				recur(l-1,r,c,item,need);
				recur(l+1,r,c,item,need);
			}
			else if (Character.isDigit(save)) {
				item.add(save);
				recur(l,r-1,c,item,need);
				recur(l,r+1,c,item,need);
				recur(l,r,c-1,item,need);
				recur(l,r,c+1,item,need);
			}
			recur(l,r-1,c,item,need);
			recur(l,r+1,c,item,need);
			recur(l,r,c-1,item,need);
			recur(l,r,c+1,item,need);
			m[l][r][c] = save;
		}
	}
}
