import java.util.*;
import java.io.*;
class juana{
    int[][] m;
    public static void main(String[] args) throws FileNotFoundException {
        new juana().run();
    }
    public void run () throws FileNotFoundException {
        // Scanner f = new Scanner(System.in);
        Scanner f = new Scanner(new File("juana.dat"));
        int time = f.nextInt();
        for(int t=1;t<=time;t++){
           int row = f.nextInt(), col = f.nextInt();f.nextLine();
           m = new int[row][col];
           for(int i=0;i<row;i++){
               String[] line = f.nextLine().split("\\s+");
               m[i] = Arrays.stream(Arrays.copyOfRange(line,1,line.length)).mapToInt(Integer::parseInt).toArray();
           }
           int sr = f.nextInt()-1, sc = f.nextInt()-1, c =f.nextInt()-1, r = f.nextInt()-1;
           if(valid(sr,sc,c,r)){
               System.out.println("Test case #" + t + ":");
               for(int i=sr;i<=sr+r;i++){
                   for(int j = sc;j<=sc+c;j++){
                       System.out.printf("     %d", m[i][j]);
                   }
                   System.out.println();
               }
           }
           else{
               System.out.print("Test case #" + t + ": Unable to extracted requested size!");
           }
           System.out.println("------------------");
        }
    }
    public boolean valid(int sr,int sc, int c, int r){
        return sr <  0 || sc < 0 || sr+r>=m.length || sc+c>=m[0].length;
    }
}
