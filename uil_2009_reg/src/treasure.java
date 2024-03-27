import java.util.*;
import java.io.*;
class treasure{
    static char[][] m;
	public static void main(String[] args)throws Exception{
		new treasure().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("treasure.dat"));
	   int times = f.nextInt();
	   while(times-->0){
	       int step = f.nextInt();
	       int r = f.nextInt()+2, c = f.nextInt()+2, sr = 0, sc = 0;f.nextLine();
	       m = new char[r][c];
	       for(int i=0;i<r;i++){
	           m[i] = f.nextLine().toCharArray();
	           for(int j=0;j<m[i].length;j++){
	               if(m[i][j]=='*'){
	                   sr = i;
	                   sc = j;
	               }
	           }
	       }
	       int max = recur(sr,sc,step,0);
	       System.out.println(max);
	   }
	}
	public int recur(int r, int c, int step, int gold){
	    if(r < 0 || c < 0 || r == m.length || c == m[r].length){
	        return 0;
	    }
	    if(step == 0){
	        if(Character.isDigit(m[r][c])){
				return gold + m[r][c] - '0';
			}
			return gold;
	    }
	    int value = gold;
	    char save = m[r][c];
	    m[r][c] = '.';
	    if(Character.isDigit(save)){
	        value += save - '0';
	    }
	    int up = recur(r+1,c,step-1,value);
	    int down = recur(r-1,c,step-1,value);
	    int left = recur(r,c-1,step-1,value);
	    int right = recur(r,c+1,step-1,value);
	    value = Math.max(up,Math.max(down,Math.max(left,right)));
	    m[r][c] = save;
	    return value;
	}
}