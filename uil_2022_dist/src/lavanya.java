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
			long N = f.nextLong();
            if (new BigInteger(Long.toString(N)).isProbablePrime(1)) {
                System.out.println(N + " = " + N);
            } else{
                System.out.print(N + " = ");
                String s = "";
                while (N % 2 == 0) {
                    s += 2 + " * ";
                    N /= 2;
                }
                for (int i = 3; i <= Math.sqrt(N); i += 2) {
                    while (N % i == 0) {
                        s+= i + " * ";
                        N /= i;
                    }
                }
                if (N > 2){
                    s += N;
                }
                else{
                    s = s.substring(0,s.lastIndexOf("*")-1);
                }
                System.out.println(s);
            }
        }
        f.close();
    }
}
