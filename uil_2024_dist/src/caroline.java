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

public class caroline {
    public static void main(String[] args) throws Exception {
        new caroline().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("caroline").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long e = 0, o = 0;
            String[] ln = f.nextLine().trim().split("\\s+");
            for(int i=0;i<ln.length;i++){
                long tmp = Long.parseLong(ln[i]);
                if(tmp%2==0){
                    e+=tmp;
                }
                else{
                    o+=tmp;
                }
            }
            out.println(e==o ? "It's a tie!!!" : (e - o > 0 ?"Evens win by " + (e-o) + " point(s)" : "Odds win by " + (o-e) + " point(s)"));
        }
        f.close();
    }
}
