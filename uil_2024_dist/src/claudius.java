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
            int sr = -1, sc = -1, er = -1, ec = -1;
            min = Integer.MAX_VALUE;
            m = new char[r][c];
            shadow = new int[r][c];
            solved = false;
			List<int[]> pos = new ArrayList<>();
            for (int i = 0; i < m.length; i++) {
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
                String s = f.nextLine();
                m[i] = s.toCharArray();
                if (s.contains("S")) {
                    sr = i;
                    sc = s.indexOf("S");
                }
				if (s.contains("E")) {
					er = i;
					ec = s.indexOf("E");
				}
				for (int j = 0; j < m[i].length; j++) {
					if(m[i][j]=='A' || m[i][j]=='B'||m[i][j]=='Q'){
						pos.add(new int[]{i,j});
					}
				}
            }
			for(int[] coor : pos){
				int row = coor[0], col = coor[1];
				if(m[row][col]=='A'){
					for (int i = -1; i <= 1; i++) {
						for(int j = -1;j <= 1;j++){
							int nr = row + i;
							int nc = col + j;
							if(nr>=0&&nc>=0&&nr<m.length&&nc<m[nr].length){
								m[nr][nc] = 'R';
							}
						}
					}
				}
				else if(m[row][col]=='B'){
					for (int i = -2; i <= 2; i++) {
						for(int j = -2;j <= 2;j++){
							int nr = row + i;
							int nc = col + j;
							if(nr>=0&&nc>=0&&nr<m.length&&nc<m[nr].length){
								m[nr][nc] = 'R';
							}
						}
					}
				}
				else{
					boolean safe = false;
					for (int i = -1; i <= 1; i++) {
						for(int j = -1;j <= 1;j++){
							int nr = row + i;
							int nc = col + j;
							if(nr>=0&&nc>=0&&nr<m.length&&nc<m[nr].length && m[nr][nc]=='T'){
								safe = true;
							}
						}
					}
					if(!safe){
						m[row][col] = 'R';
					}
				}
			}
			recur(sr, sc, 0);
			System.out.println(shadow[er][ec] <= h ? "Free at last, Free at last. " + (h-shadow[er][ec]) + " hour(s) to spare.":"Smokey the Bear is en route.");
        }
        f.close();
    }

    public void recur(int r, int c, int step) {
        if ( r >= 0 && c >= 0 && r < m.length && c < m[r].length && !"RV".contains(m[r][c]+"") && step < shadow[r][c]) {
			shadow[r][c] = step;
			if (m[r][c] == 'E') {
				min = step;
				return;
			}
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