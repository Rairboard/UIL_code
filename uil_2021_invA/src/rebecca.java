import java.util.*;
import java.io.*;
public class rebecca{
    static int rectangle;
	public static void main(String[] args)throws Exception {
		new rebecca().run();
	}
	public void run()throws Exception{
	    //Scanner f = new Scanner(System.in);
	    Scanner f = new Scanner(new File("rebecca.dat"));
	    int N=f.nextInt();
	    for(int time = 1; time <= N;time++){
	        int rows = f.nextInt(), cols = f.nextInt();
	        int[][] m = new int[rows][cols];
	        rectangle = 0;
	        f.nextLine();
	        for(int i=0;i<rows;i++){
	            m[i] = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
	        }
	        for(int r=0; r<rows;r++){
	            for(int c=0; c< cols;c++){
	                for(int row=0;row+r < rows;row++){
	                    for(int col=0; col+c<cols;col++){
	                        findRect(r, c,  row+r, col+c, m);
	                    }
	                }
	            }
	        }
	        System.out.println("Case #" + time + ": " + rectangle);
	    }
	}
	public void findRect(int r, int c, int rr, int cc, int[][] m){
	    int e = m[r][c];
	    boolean monochromatic = true;
	    outer: for(int i = r; i <= rr;i++){
	        for(int j = c; j <= cc;j++){
	            if(m[i][j] != e){
	                monochromatic = false;
	                break outer;
	            }
	        }
	    }
	    if(monochromatic){
	        rectangle++;
	    }
	}
}
