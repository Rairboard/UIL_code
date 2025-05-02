import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class math {
	public static void main(String[] args)throws Exception {
		new math().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("math.dat"));
//        Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String a = f.nextLine();
            String b = f.nextLine();
            BigInteger one = new BigInteger(a);
            BigInteger two = new BigInteger(b);
            BigInteger c = one.add(two);
            System.out.println(a+"\n"+b);
            if(c.compareTo(BigInteger.ZERO)>=0) System.out.print("+");
            System.out.println(c);
            System.out.println();
        }
        f.close();
	}
}
