import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class ones {
    public static void main(String[] args) throws Exception {
        new ones().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ones").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int n = f.nextInt();
            if(n% 2 ==0 || n % 5 ==0){
                out.println("INVALID INPUT");
            }
            else{
                BigInteger mul = new BigInteger("1");
                BigInteger base = BigInteger.valueOf(n);
                while (true) {
                    if (mul.mod(base).equals(BigInteger.ZERO)) {
                        break;
                    }
                    mul = new BigInteger(mul + "1");
                }
                out.println(mul.toString().length());
            }
        }
        f.close();
    }
}
