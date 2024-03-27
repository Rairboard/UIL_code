import java.util.*;
import java.io.*;
class riley{
    static double[][] m;
    static double area;
	public static void main(String[] args)throws Exception {
		new riley().run();
	}
	public void run()throws Exception{
	   // Scanner f  =new Scanner(System.in);
	   Scanner f = new Scanner(new File("riley.dat"));
	   int times = f.nextInt();
	   while(times-->0){
	       int r=f.nextInt(), c =f.nextInt();
	       double total = 0;
	       m = new double[r][c];
	       f.nextLine();
	       for(int i=0;i<m.length;i++){
	           m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
	       }
	       Set<Double> s = new TreeSet<>(Collections.reverseOrder());
	       for(int i=0;i<m.length;i++){
	           for(int j=0;j<m[i].length;j++){
	               if(m[i][j]!=0){
	                   area = 0;
	                   recur(i,j);
	                   s.add(area);
	                   total+=area;
	               }
	           }
	       }
	       System.out.printf("%.2f acres%n", total);
	       s.forEach(e -> System.out.printf("%.2f acres%n", e));
	       System.out.println("============");
	   }
	}
	public void recur(int r, int c){
	    if(r>=0 && r<m.length && c>=0 && c<m[r].length && m[r][c] !=0){
	        area += 25 * (m[r][c]/100);
	        m[r][c] = 0;
	        recur(r-1,c);
	        recur(r+1,c);
	        recur(r,c-1);
	        recur(r,c+1);
	        recur(r-1,c-1);
	        recur(r-1,c+1);
	        recur(r+1,c-1);
	        recur(r+1,c+1);
	    }
	}
}
