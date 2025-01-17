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

public class insertion {
    List<String> al = new ArrayList<>(Arrays.asList("2,3,4,5,6,7,8,9,T,J,Q,K,A".split(",")));
    public static void main(String[] args) throws Exception {
        new insertion().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("insertion").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln= f.nextLine().trim().split("\\s+");
            for(int i = 1;i<ln.length;i++){
                int j = i;
                String tmp = ln[j];
                while (j - 1 >= 0 && al.indexOf(ln[j - 1]) >= al.indexOf(tmp)) {
                    ln[j] = ln[j-1];
                    j--;
                }
                ln[j] = tmp;
                for(String s:  ln){
                    out.print(s + " ");
                }
                out.println();
            }
            out.println();
        }
        f.close();
    }
}
