import java.util.*;
import java.io.*;
public class isquare {
	public static void main(String[] args)throws Exception {
		new isquare().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("square.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        int[] vr = {-1,-1,1,1};
        int[] vc = {-1,1,-1,1};
        for(int asdf = 1;asdf <= times;asdf++){
            int p = f.nextInt();
            f.nextLine();
            char[][] m = new char[p][p];
            String[][] ROW = new String[p][p];
            String[][] COL = new String[p][p];
            for (int i = 0; i < p; i++) {
                m[i] = f.nextLine().trim().toCharArray();
            }
            for (int i = 0; i < p; i++) {
                Arrays.fill(ROW[i], "");
                Arrays.fill(COL[i], "");
            }
            for (int i = 0; i < p; i++) {
                for (int j = 0; j < p; j++) {
                    if(i>0) ROW[i][j] = ROW[i-1][j];
                    if(j>0) COL[i][j] = COL[i][j-1];
                    if (!COL[i][j].contains(m[i][j] + "")) {
                        COL[i][j]+=m[i][j];
                    }
                    if (!ROW[j][i].contains(m[j][i] + "")) {
                        ROW[j][i]+=m[j][i];
                    }
                }
            }
//            for (int i = 0; i < p; i++) {
//                System.out.println(Arrays.toString(ROW[i]));
//            }
//            System.out.println();
//            for (int i = 0; i < p; i++) {
//                System.out.println(Arrays.toString(COL[i]));
//            }
            int CASE = f.nextInt();
            f.nextLine();
            for (int i = 0; i < CASE; i++) {
                int edge = 1;
                int r =f.nextInt(), c = f.nextInt();
                for(int k = 1;k<=p/2;k++){
                    boolean good = true;
                    for (int j = 0; j < 4; j++) {
                        if(!in(r+vr[j] *k, c+vc[j]* k, p)){
                            good = false;
                            break;
                        }
                    }
                    if(!good){
                        break;
                    }
                    if (!ROW[r - k][c - k].equals(ROW[r + k][c - k]) || !ROW[r-k][c+k].equals(ROW[r+k][c+k])) {
                        break;
                    }
                    if (!COL[r - k][c - k].equals(COL[r - k][c + k]) || !COL[r + k][c - k].equals(COL[r + k][c + k])) {
                        break;
                    }
                    edge+=2;
                }
                System.out.println(r + " " + c + "  " + edge);
            }
            System.out.println();
        }
        f.close();
	}
    public boolean in(int r, int c, int p){
        return r>=0&&c>=0&&r<p&&c<p;
    }
}
