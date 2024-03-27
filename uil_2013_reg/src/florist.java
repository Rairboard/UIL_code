import java.util.*;
import java.io.*;
class florist {
    public static void main(String[] args) throws Exception {
        new florist().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File("florist.dat"));
        //Scanner f = new Scanner(System.in);
        int[] w = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int N = f.nextInt();
        f.nextLine();
        while(N-->0){
            int[] weight = Arrays.copyOfRange(w,0,w.length);
            int[] p = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(weight);
            Arrays.sort(p);
            int possible = 0, in = weight.length-1;
            for(int i=p.length-1;i>-1;i--){
                for(int j=in;j>-1;j--){
                    if(p[i] <= weight[j]){
                        possible++;
                        in--;
                        break;
                    }
                }
            }
            System.out.println(possible);
        }
        f.close();
    }
}
