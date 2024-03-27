import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class susbrownie_ThanhLe {
	HashSet<Character> hs;
	int R,C;
	char[][] m, copy;
	int[][] shadow;
	int min;
	boolean solved;

	public static void main(String[] args) throws Exception {
		new susbrownie_ThanhLe().run();
	}

	public void run() throws Exception {
		Scanner f = new Scanner(new File("susbrownie.dat"));
		//Scanner f = new Scanner(System.in);
		int times = f.nextInt();
		f.nextLine();
		while (times-- > 0) {
			int r = f.nextInt(), c = f.nextInt(), sr = -1, sc = -1;
			f.nextLine();
			m = new char[r][c];
			shadow = new int[r][c];
			copy = new char[r][c];
			min = Integer.MAX_VALUE;
			solved = false;
			for (int i = 0; i < r ; i++) {
				String s= f.nextLine().trim();
				m[i] = s.toCharArray();
				copy[i] = s.toCharArray();
				Arrays.fill(shadow[i],Integer.MAX_VALUE);
				if(s.contains("K")){
					sr = i;
					sc = s.indexOf("K");
				}
				if (s.contains("S")) {
					R = i;
					C = s.indexOf("S");
				}
			}
			hs = new HashSet<>();
			recur(sr,sc,0);
			if(hs.size() == 5){
				if(solved){
					out.println("Kenny was able to bake brownies in complete secrecy!");
				}else{
					out.println("Kenny got caught by the police...");
				}
			}else{
				out.println("Kenny can't bake brownies :(");
			}
		}
		f.close();
	}
	public void recur(int r, int c, int step){
		if(solved) return;
		if(r>=0&&c>=0 && r < m.length && c < m[r].length && m[r][c] != '#' && shadow[r][c] > step && m[r][c] != 'A' && m[r][c] != 'O'){
			shadow[r][c] = step;
			if ("EFBC".contains("" + m[r][c])) {
				hs.add(m[r][c]);
			}
			if(hs.size()==4){
				hs.add('S');
				for (int i = 0; i < m.length; i++) {
					Arrays.fill(shadow[i],Integer.MAX_VALUE);
					m[i] = new String(copy[i]).toCharArray();
				}
				for (int i = 0; i < m.length; i++) {
					for (int j = 0; j < m[i].length; j++) {
						if(m[i][j] == 'A'){
							for(int nr = i-1; nr <= i+1;nr++){
								for (int nc = j-1; nc <= j+1; nc++) {
									if(nr>=0&&nc>=0&&nr<m.length&&nc<m[nr].length && m[nr][nc]!='A'){
										m[nr][nc] = '#';
									}
								}
							}
						}
					}
				}
				solved = oven(R,C,0);
				return;
			}
			char save = m[r][c];
			m[r][c] = '#';
			int[] y = {1,-1,0,0};
			int[] x = {0,0,1,-1};
			for (int i = 0; i < 4; i++) {
				recur(r+y[i],c + x[i],step+1);
			}
			m[r][c] = save;
		}
	}
	public boolean oven(int r, int c, int step){
		if(r>=0&&r<m.length&&c>=0&&c<m[r].length && m[r][c] != '#' && shadow[r][c] > step && m[r][c] != 'A'){
			shadow[r][c] = step;
			if(m[r][c] == 'O'){
				return true;
			}
			char save = m[r][c];
			m[r][c] = '#';
			int[] y = {1,-1,0,0};
			int[] x = {0,0,1,-1};
			for (int i = 0; i < 4; i++) {
				if(oven(r+y[i],c + x[i],step+1)){
					m[r][c] = save;
					return true;
				}
			}
			m[r][c] = save;
		}
		return false;
	}
}