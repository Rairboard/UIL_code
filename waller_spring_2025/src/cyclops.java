import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class cyclops {
    public static void main(String[] args) throws Exception {
        new cyclops().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cyclops").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt();
            long p = f.nextLong();
            f.nextLine();
            long sum = 0;
            List<Long> al = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                String ln = f.nextLine().trim();
                for (int j = 0; j < ln.length(); j++) {
                    al.add(Long.parseLong(ln.substring(j,j+1)));
                }
            }
            Collections.sort(al);
            for (int i = 0; i < al.size() / 2; i++) {
                sum+=al.get(i);
            }
            if(al.size()%2==1) sum+=al.get(al.size()/2);
            if(sum<=p) out.println("Made it with " + (p - sum) + " power to spare.");
            else out.println("Better Call Iceman.");
        }
        f.close();
    }
}
