import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class lavanya {
    public static void main(String[] args) throws Exception {
        new lavanya().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("lavanya.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
            List<Long> al = new ArrayList<>();
            long n = f.nextLong();
            System.out.print(n + " = ");
            while(n%2==0){
                al.add((long)2);
                n/=2;
            }
            for(long i = 3;i * i<=n;i+=2){
                while(n%i==0){
                    al.add(i);
                    n/=i;
                }
            }
            if(n>1) al.add(n);
            Collections.sort(al);
            for (int i = 0; i < al.size(); i++) {
                if(i<al.size()-1) System.out.print(al.get(i) + " * ");
                else System.out.println(al.get(i));
            }
        }
        f.close();
    }
}
