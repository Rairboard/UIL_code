import java.util.*;
import java.io.*;
class shirley{
    int[][] m;
    int lot_size, treeCount;
    double cluster_size;
	public static void main(String[] args) throws Exception{
		new shirley().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("shirley.dat"));
	   int N = f.nextInt();
	   for(int t=1;t<=N;t++){
	       Map<Integer,Double> tm = new TreeMap<>(Collections.reverseOrder());
	       int row = f.nextInt(), col = f.nextInt();f.nextLine();
	       m = new int[row][col];
	       lot_size = row*col;
	       for(int i=0;i<row;i++){
	           m[i] = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
	           for(int j=0;j<col;j++){
	               if(m[i][j]<250){
	                   m[i][j] = 0;
	               }
	           }
	       }
	       for(int i=0;i<m.length;i++){
	           for(int j=0;j<m[i].length;j++){
	               if(m[i][j]!=0){
	                   cluster_size = 0;
	                   treeCount = 0;
	                   countingTrees(i,j);
	                   if(cluster_size>1){
	                       tm.put(treeCount,Double.parseDouble(String.format("%.1f",(double)cluster_size/lot_size*100)));
	                   }
	               }
	           }
	       }
	       Queue<Integer> tree = new LinkedList<>(tm.keySet());
	       int none = 3 - tree.size();
	       System.out.println("Case #" + t + ":");
	       for(int i=0;i<3 && !tree.isEmpty();i++){
	           System.out.println(tree.peek() + " " + tm.get(tree.poll()));
	       }
	       for(int i=0;i<none;i++){
	           System.out.println("NONE");
	       }
	       System.out.println("^^^^^^^^^^^^");
	   }
	}
	public void countingTrees(int r, int c){
	    if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!=0){
	        cluster_size++;
	        treeCount += m[r][c];
	        m[r][c] = 0;
	        countingTrees(r+1,c);
	        countingTrees(r-1,c);
	        countingTrees(r,c+1);
	        countingTrees(r,c-1);
	    }
	}
}
