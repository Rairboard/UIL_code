import java.util.*;
import java.io.*;
 class moose{
     static char[][]m;
     int count;
	public static void main(String[] args) throws Exception{
		new moose().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("moose.dat"));
	   int N = f.nextInt();
	   f.nextLine();
	   while(N-->0){
	       m = new char[10][10];
	       int max = 0;
	       for(int i=0;i<10;i++){
	           m[i] = f.nextLine().toCharArray();
	       }
	       for(int i=0;i<10;i++){
	           for(int j=0;j<10;j++){
	               if(m[i][j] == 'M'){
	                   count = 0;
	                   recur(i,j);
	                   max = Math.max(count,max);
	               }
	           }
	       }
	       System.out.println(max);
	   }
	}
	public void recur(int r, int c){
	    if(r>=0&&r<m.length&& c>=0&&c<m[r].length&& m[r][c] == 'M'){
	        count++;
	        m[r][c] = '#';
	        recur(r-1,c);
	        recur(r+1,c);
	        recur(r,c-1);
	        recur(r,c+1);
	    }
	}
}
