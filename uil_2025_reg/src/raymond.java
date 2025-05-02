import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class raymond {
	public static void main(String[] args)throws Exception {
		new raymond().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("raymond.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int n = f.nextInt();
            BigInteger[] num = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                num[i] = f.nextBigInteger();
            }
            BigInteger lcm = BigInteger.ONE;
            for(BigInteger number : num){
                BigInteger GCD = lcm.gcd(number);
                lcm = lcm.multiply(number).divide(GCD);
            }
            if (lcm.equals(BigInteger.ONE)) {
                System.out.println("LCM NUMBER 1!");
            }
            else System.out.println("Lowest Common Multiple is " + lcm);
        }
        f.close();
	}
}
