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

public class armstrong {
    public static void main(String[] args) throws Exception {
        new armstrong().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("armstrong").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long n = f.nextLong();
            String ln = Long.toString(n);
            long sum = 0;
            for(int i = 0;i < ln.length();i++){
                sum+=(long)Math.pow(Integer.parseInt(ln.substring(i,i+1)), ln.length());
            }
            if(sum==n){
                out.println("ARMSTRONG");
            }
            else{
                out.println("NOT AN ARMSTRONG");
            }
        }
        f.close();
    }
}
