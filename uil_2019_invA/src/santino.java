import java.util.*;
import java.io.*;

public class santino {
	String[][] m;
	int[][] shadow;
	int min, sr, sc,er,ec;
	boolean found;
	Map<String,int[]>dir;
    public static void main(String[] args) throws Exception {
        new santino().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("santino.dat"));
        //Scanner f = new Scanner(System.in);
		dir = new HashMap<>();
		dir.put("E",new int[]{0,1});
		dir.put("N",new int[]{-1,0});
		dir.put("S",new int[]{1,0});
		dir.put("W",new int[]{0,-1});
		dir.put("NW",new int[]{-1,-1});
		dir.put("NE",new int[]{-1,1});
		dir.put("SW",new int[]{1,-1});
		dir.put("SE",new int[]{1,1});
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf<=times;asdf++) {
			int r = f.nextInt(), c = f.nextInt();
			sr = f.nextInt();sc = f.nextInt();er = f.nextInt();ec = f.nextInt();
			f.nextLine();
			m = new String[r][c];
			shadow = new int[r][c];
			min = Integer.MAX_VALUE;
			found = false;
			for (int i = 0; i < r; i++) {
				m[i] = f.nextLine().split("\\s+");
				Arrays.fill(shadow[i],Integer.MAX_VALUE);
			}
			recur(sr,sc,0);
			System.out.println("Case #" + asdf +": "+(found?min:"Lost in the playground"));
        }
        f.close();
    }
	public void recur(int r, int c, int step){
		if(step < min && r>=0&&c>=0&&r<m.length&&c<m[r].length&&step<shadow[r][c]&&!m[r][c].equals("#")){
			if(r==er&&c==ec){
				min = step;
				found=true;
				return;
			}
				String save = m[r][c];
				m[r][c] = "#";
				shadow[r][c] =step;
				int[] d = dir.get(save);
				int row = r+d[0], col =c+d[1];
				List<int[]> leap = new ArrayList<>();
				while(row>=0&&row<m.length&&col>=0&&col<m[row].length){
					leap.add(new int[]{row,col});
					row+=d[0];
					col+=d[1];
				}
				for(int i=leap.size()-1;i>-1;i--){
					recur(leap.get(i)[0],leap.get(i)[1],step+1);
				}
				m[r][c] = save;
		}
	}
}
