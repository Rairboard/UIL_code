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

public class guowei {
    public static void main(String[] args) throws Exception {
        new guowei().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("guowei").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt(), in = 0;
            f.nextLine();
            String ln = f.nextLine();
            String out = "";
            for (int i = 0; i < n; i++) {
                if(in == ln.length()-1){
                    i++;
                }
                in = ++in%ln.length();
            }
            while(out.length()<40){
                out+=ln.charAt(in);
                if(in == ln.length()-1){
                    out+=" ";
                }
                in = ++in%ln.length();
            }
            System.out.println(out);
        }
        f.close();
    }
}
