import java.util.*;
import java.io.*;

public class helicopter {
	static int[][] m;
    public static void main(String[] args) throws Exception {
        new helicopter().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("helicopter.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
			int w = f.nextInt(), l = f.nextInt(), area=0, startR = 0, startC = 0, endR = 0,endC =0, h = 0;f.nextLine();
			m = new int[l][w];
			for (int i = 0; i < l; i++) {
				m[i] = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			}
			for (int sr = 0; sr < l; sr++) {
				for (int sc = 0; sc < w; sc++) {
                    for (int er = sr; er < l; er++) {
                        for (int ec = sc; ec < w; ec++) {
                            int tmp = (er-sr+1) * (ec-sc+1);
                            if(valid(sr,sc,er,ec) && m[sr][sc] >= h && tmp >= area){
                                h = m[sr][sc];
                                startR = sr;
                                startC = sc;
                                endR = er;
                                endC = ec;
                                area = tmp;
                            }
                        }
                    }
				}
			}
            System.out.println("Area: " + area + " square blocks");
            System.out.println("Start location: " + startR + " " + startC);
            System.out.println("Width: " + (endC - startC + 1));
            System.out.println("Length: " + (endR - startR + 1));
            System.out.println();
        }
        f.close();
    }
    public boolean valid(int sr,int sc, int er, int ec){
        int e = m[sr][sc];
        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                if(m[i][j] != e){
                    return false;
                }
            }
        }
        return true;
    }
}
