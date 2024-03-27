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

public class adv53 {
    public static void main(String[] args) throws Exception {
        new adv53().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("adv53").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String alp = "";
        for(char c = 'A';c<='Z';c++){
            alp+=c;
        }
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().split("\\s+");
            for (int i = 0; i < ln.length; i++) {
                ln[i] = new StringBuilder(ln[i].toUpperCase()).reverse().toString();
                char[] c = ln[i].toCharArray();
                for (int j = 0; j < c.length; j++) {
                    if ((c[j] + "").matches("[A-Z]")) {
                        int in = alp.indexOf((c[j]+""));
                        out.print(alp.charAt(alp.length()-1-in)%10);
                    }
                    else{
                        out.print(c[j]);
                    }
                }
                out.print(" ");
            }
            out.println();
        }
        f.close();
    }
}
