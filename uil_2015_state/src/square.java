import java.util.*;
import java.io.*;
public class square {
	public static void main(String[] args)throws Exception {
		new square().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("square.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            char[][] m = new char[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            long cnt = 0;
            for(int side = 1;side <= Math.min(row, col);side++){
                for(int sr = 0;sr < row - side + 1;sr++){
                    for(int sc = 0; sc< col-side+1;sc++){
                        if(valid(sr,sc,side,m)){
                            cnt++;
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
        f.close();
	}
    public boolean valid(int sr, int sc, int side, char[][] m){
        for(int r = sr;r < sr + side;r++){
            for(int c = sc;c < sc + side;c++){
                if(m[r][c]!='x') return false;
            }
        }
        return true;
    }
}
