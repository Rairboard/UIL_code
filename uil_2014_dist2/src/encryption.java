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

public class encryption {
    public static void main(String[] args) throws Exception {
        new encryption().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("encryption").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            long factor = 2;
            long lcm = 1;
            while (notDone(ar)) {
                boolean used = false;
                for (int i = 0; i < ar.length; i++) {
                    if(ar[i]%factor==0){
                        ar[i]/=factor;
                        used = true;
                    }
                }
                if(used){
                    lcm*=factor;
                }
                else{
                    factor++;
                }
            }
            out.println(lcm);
        }
        f.close();
    }
    public boolean notDone(long[] ar){
        for(long i : ar){
            if(i!=1){
                return true;
            }
        }
        return false;
    }
}
