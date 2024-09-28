import java.util.*;
import java.io.*;

public class claudius {
    char m[][];
    int shadow[][];
    boolean solved;
    int min;

    public static void main(String[] args) throws Exception {
        new claudius().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("claudius.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int r = f.nextInt(), c = f.nextInt(), h = f.nextInt();
			f.nextLine();
            int sr = 0, sc = 0;
            min = Integer.MAX_VALUE;
            m = new char[r][c];
            shadow = new int[r][c];
            solved = false;
            for (int i = 0; i < m.length; i++) {
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
                String s = f.nextLine();
                m[i] = s.toCharArray();
                if (s.contains("S")) {
                    sr = i;
                    sc = s.indexOf("S");
                }
            }
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					if(m[i][j]=='A'){
						int[] vr = {-1,1,0,0};
						int[] vc = {0,0,-1,1};
						for (int k = 0; k < 4; k++) {
							int nr = vr[k] + i;
							int nc = vc[k] + j;
							if(nr>=0&&nc>=0&&nr<m.length&&nc<m[nr].length && m[nr][nc]!='A'){
								m[nr][nc]='R';
							}
						}
					}
					if(m[i][j]=='B'){
						int[] vr = {-2,2,0,0};
						int[] vc = {0,0,-2,2};
						for (int k = 0; k < 4; k++) {
							int nr = vr[k] + i;
							int nc = vc[k] + j;
							if(nr>=0&&nc>=0&&nr<m.length&&nc<m[nr].length && m[nr][nc]!='B'){
								m[nr][nc]='R';
							}
						}
					}
				}
			}
			for(char[]cc : m){
				System.out.println(cc);
			}
            recur(sr, sc, 0);
//			for (int i = 0; i < shadow.length; i++) {
//				System.out.println(Arrays.toString(shadow[i]));
//			}
//			System.out.println();
			System.out.println(min <= h ? "Free at last, Free at last. " + (h-min) + " hour(s) to spare.":"Smokey the Bear is en route.");
        }
        f.close();
    }

    public void recur(int r, int c, int step) {
        if ( r >= 0 && c >= 0 && r < m.length && c < m[r].length && "MTQ.SE".contains(m[r][c]+"") && step < shadow[r][c]) {
			if (m[r][c] == 'E') {
				min = step;
				return;
			}
			if(m[r][c]=='Q'){
				int[] vr = {-1,1,0,0};
				int[] vc = {0,0,-1,1};
				boolean check = false;
				for (int k = 0; k < 4; k++) {
					int nr = vr[k] + r;
					int nc = vc[k] + c;
					if(nr>=0&&nc>=0&&nr<m.length&&nc<m[nr].length && m[nr][nc]=='T'){
						check = true;
					}
				}
				if(!check) return;
			}
			shadow[r][c] = step;
			int add = 1;
			if(m[r][c]=='M' || m[r][c] == 'Q'){
				add = 3;
			}
			else if(m[r][c]=='T'){
				add = 2;
			}
			recur(r - 1, c, step + add);
			recur(r + 1, c, step + add);
			recur(r, c - 1, step + add);
			recur(r, c + 1, step + add);
        }
    }
}