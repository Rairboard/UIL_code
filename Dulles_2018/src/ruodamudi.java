import java.sql.Array;
import java.util.*;
import java.io.File;

public class ruodamudi {
    long max;
    public static void main(String[] args) throws Exception {
        new ruodamudi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("ruodamudi.dat"));
        //Scanner f = new Scanner(System.in)
        long n = f.nextLong(), k = f.nextLong();
        List<Long> N = new ArrayList<>();
        List<Long> al = new ArrayList<>();
        max = Long.MIN_VALUE;
        for(long i = 1; i<=n;i++){
            N.add(i);
        }
        recur(0,N,al,k);
        System.out.println(max);
        f.close();
    }
    public void recur(int i,List<Long> N, List<Long> al,long k){
        if(al.size()==k){
            long n = al.get(0);
            for (int j = 1;j<al.size(); j++) {
                n^=al.get(i);
            }
            max = Math.max(max,n);
        }else{
            for (int j = i+1; j < N.size(); j++) {
                al.add(N.get(j));
                recur(j,N,al,k);
                al.remove(N.get(j));
            }
        }
    }
}
// n = 4, k = 3
// ar = 1 2 3 4
// 1 - 2 3 4
// 2 - 1 3 4
// 3 - 1 2 4
// 4 - 1 2 3
