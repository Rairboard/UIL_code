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

public class fernando {
    public static void main(String[] args) throws Exception {
        new fernando().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("fernando").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long a = f.nextLong(), b = f.nextLong();
            Set<Long> fact = new HashSet<>();
            for(long i = 1;i<=Math.sqrt(a);i++){
                if(a%i==0){
                    long composite = a/i;
                    fact.add(i);
                    fact.add(composite);
                }
            }
            List<Long> al = new ArrayList<>();
            for(Long ll : fact){
                if (ll.toString().contains(b + "")) {
                    continue;
                }
                al.add(ll);
            }
            if(al.size()==0){
                out.println("NONE");
            }
            else{
                Collections.sort(al);
                al.forEach(e-> out.print(e+" "));
                out.println();
            }
        }
        f.close();
    }
}
