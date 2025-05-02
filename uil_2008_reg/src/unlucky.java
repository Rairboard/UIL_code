import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class unlucky {
	public static void main(String[] args)throws Exception {

		new unlucky().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("unlucky.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String ln = f.nextLine().trim();
            BigInteger front = BigInteger.ZERO, end = BigInteger.ZERO;
            boolean a = false, b = false;
            for (int i = 0; i < ln.length(); i++) {
                front = front.add(new BigInteger(ln.substring(i,i+1)));
                end = end.add(new BigInteger(ln.substring(ln.length()-i-1,ln.length()-i)));
                if (front.equals(BigInteger.valueOf(13))) {
                    a = true;
                }
                if (end.equals(BigInteger.valueOf(13))) {
                    b = true;
                }
                if(a && b) break;
            }
            if(a && b) System.out.println("UNLUCKY");
            else System.out.println("NOT UNLUCKY");
        }
        f.close();
	}
}
