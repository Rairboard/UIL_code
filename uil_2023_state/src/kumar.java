import java.util.*;
import java.io.*;
import java.math.*;

public class kumar {
    public static void main(String[] args) throws Exception {
        new kumar().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("kumar.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        for (int i = 0; i < times; i++) {
			String decimal = f.next();
			String tmp = decimal.substring(decimal.indexOf(".")+1).replaceAll("\\.","");
			long numer = Long.parseLong(tmp), deno = (long)(Math.pow(10,tmp.length())), d =gcd(numer, deno);
			System.out.println(decimal +" is equivalent to " + (numer/d) + "/" + (deno/d));
        }
        f.close();
    }
    public static long gcd(long a , long b){
        if(b==0){
            return a;
        }
        return gcd(b, a % b);
    }
}
