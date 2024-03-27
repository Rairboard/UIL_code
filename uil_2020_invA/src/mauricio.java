import java.util.*;
import java.io.*;
class mauricio{
    static int[][] m;
	public static void main(String[] args) throws Exception{
		new mauricio().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("mauricio.dat"));
	   int times =f.nextInt();
	   while(times-->0){
	       int w= f.nextInt(), l = f.nextInt(), N = 1;
	       m = new int[w][l];
	       if(w > l){
	           for(int j=0;j<m[0].length;j++){
	               if(j%2==0){
	                   for(int i=0;i<m.length;i++){
	                       m[i][j] = N++;
	                   }
	               }else{
	                   for(int i=m.length-1;i>=0;i--){
	                       m[i][j] = N++;
	                   }
	               }
	           }
	       } else{
	           for(int i=0;i<m.length;i++){
	               if(i%2==0){
	                   for(int j=0;j<m[i].length;j++){
	                       m[i][j] = N++;
	                   }
	               } else{
	                   for(int j=m[i].length-1;j>=0;j--){
	                       m[i][j] = N++;
	                   }
	               }
	           }
	       }
	       String ff = "%" + (Integer.toString(w * l).length()+1) + "d";
	       for(int i=0;i<m.length;i++){
	           for(int j=0;j<m[i].length;j++){
	               System.out.printf(ff, m[i][j]);
	           }
	           System.out.println();
	       }
	       System.out.println("==========");
	   }
	}
}
