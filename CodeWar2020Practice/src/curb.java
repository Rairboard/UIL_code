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

public class curb {
    public static void main(String[] args) throws Exception {
        new curb().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("curb").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            List<String> req = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
            List<String> a = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
            List<String> b = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
            int one = 0, two =0;
            for (int i = 0; i < a.size(); i++) {
                if (req.contains(a.get(i))) {
                    one++;
                }
            }
            for (int i = 0; i < b.size(); i++) {
                if (req.contains(b.get(i))) {
                    two++;
                }
            }
            if(one>two){
                out.println("Boudreaux");
            }
            else if(two>one){
                out.println("Thibodeaux");
            }
            else{
                out.println("Sneak one in!");
            }
        }
        f.close();
    }
}
