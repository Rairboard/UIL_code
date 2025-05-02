import java.util.*;
import java.io.*;
public class decisions {
	public static void main(String[] args)throws Exception {
		new decisions().run();
	}
    int[][] shadow;
    char[][]m ;
	public void run() throws Exception{
        Scanner f = new Scanner(new File("decisions.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
           m = new char[row][col];
            shadow = new int[row][col];
            for (int i = 0; i < row; i++) {
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
            }
            List<int[]> start = new ArrayList<>();
            List<int[]> al = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().toCharArray();
                for (int j = 0; j < col; j++) {
                    if(m[i][j] == 'W'){
                        al.add(new int[]{i,j});
                    }
                    if(m[i][j] == 'R'){
                        start.add(new int[]{i,j});
                    }
                }
            }
            for(int[] pair : start){
                recur(pair[0], pair[1], 0);
            }
            int min = Integer.MAX_VALUE;
            int[] coor = new int[2];
            for(int[] pair : al){
                if(shadow[pair[0]][pair[1]] < min){
                    min = shadow[pair[0]][pair[1]];
                    coor[0] = pair[0];
                    coor[1] = pair[1];
                }
            }
            if(min==Integer.MAX_VALUE){
                System.out.println("Send a helicopter");
            }
            else{
                System.out.println(coor[0] + " " + coor[1]);
            }
        }
        f.close();
	}
    public void recur(int r, int c, int step){
        if(r >=0 && c>=0 && r< m.length && c<m[r].length&& m[r][c] != '#' && step < shadow[r][c]){
            shadow[r][c] = step;
            recur(r-1,c,step+1);
            recur(r+1,c,step+1);
            recur(r,c-1,step+1);
            recur(r,c+1,step+1);
        }
    }
}
