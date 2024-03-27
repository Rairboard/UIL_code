import java.util.*;
import java.io.*;
class willie{
    static String[][] m;
    static int N;
	public static void main(String[] args) throws Exception{
		new willie().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("willie.dat"));
	   int cases = f.nextInt();
	   while(cases-- >0){
	       N = f.nextInt();f.nextLine();
	       m = new String[N][N];
	       f.nextLine();
	       for(int i=0;i<N;i++){
	           String[] line = f.nextLine().replaceAll("\\s+"," ").replaceAll("\\s*Q\\s*","Q").split("\\|");
	           f.nextLine();
	           m[i] = Arrays.copyOfRange(line,1,line.length);
	       }
	       System.out.println(safe() && count() == N ? "valid solution" : "incorrect attempt");
	       f.nextLine();
	   }
	}
	public int count(){
	    int q = 0;
	    for(int i=0;i<N;i++){
	        for(int j=0;j<N;j++){
	            if(m[i][j].equals("Q")){
	                q++;
	            }
	        }
	    }
	    return q;
	}
	public boolean safe(){
	    for(int i=0;i<N;i++){
	        int rowQ = 0;
	        int colQ = 0;
	        for(int j=0;j<N;j++){
	            if(m[i][j].equals("Q")){
	                rowQ++;
	            }
	            if(m[j][i].equals("Q")){
	                colQ++;
	            }
	        }
	        if(rowQ > 1 || colQ > 1){
	            return false;
	        }
	    }
	    for(int i=0;i<N;i++){
	        int r = i, c = 0;
	        int qCount = 0;
	       while(r>=0&&c<N){
	            if(m[r][c].equals("Q")){
	                qCount++;
	            }
	            r--;
	            c++;
	        }
	        if(qCount>1){
	            return false;
	        }
	    }
	    for(int i=0;i<N;i++){
	        int r= i, c = N-1, qCount = 0;
	        while(r>=0&&c>=0){
	            if(m[r][c].equals("Q")){
	                qCount++;
	            }
	            r--;
	            c--;
	        }
	        if(qCount>1){
	            return false;
	        }
	    }
	    for(int i=0;i<N;i++){
	        int r=0,c=i,qCount=0;
	        while(r<N&&c<N){
	            if(m[r][c].equals("Q")){
	                qCount++;
	            }
	            r++;
	            c++;
	        }
	        if(qCount>1){
	            return false;
	        }
	    }
	    for(int i=1;i<N;i++){
	        int r = i, c = 0,qCount=0;
	        while(r<N&&c<N){
	            if(m[r][c].equals("Q")){
	                qCount++;
	            }
	            r++;
	            c++;
	        }
	        if(qCount>1){
	            return false;
	        }
	    }
	    return true;
	}
}
