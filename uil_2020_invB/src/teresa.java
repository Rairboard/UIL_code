import java.util.*;
import java.io.*;
class teresa{
	public static void main(String[] args) throws Exception{
		new teresa().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("teresa.dat"));
	   int N  = f.nextInt();
	   for(int cases = 1; cases <=N;cases++){
	       int[][] m = new int[f.nextInt()][f.nextInt()];
	       f.nextLine();
	       for(int i=0;i<m.length;i++){
	           m[i] = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
	       }
	       for(int i=0;i<m[0].length;i++){
	           int[] ar = new int[m.length];
	           for(int j=0;j<m.length;j++){
	               ar[j] = m[j][i];
	           }
	           Arrays.sort(ar);
	           for(int j=0;j<m.length;j++){
	               m[j][i] = ar[j];
	           }
	       }
	       for(int i=0;i<m.length;i++){
	           Arrays.sort(m[i]);
	       }
	       System.out.println(cases + ":");
	       for(int i=0;i<m.length;i++){
	           for(int j=0;j<m[i].length;j++){
	               System.out.print(m[i][j] + "\t");
	           }
	           System.out.println();
	       }
	       System.out.println("++++++++++++");
	   }
	}
}
