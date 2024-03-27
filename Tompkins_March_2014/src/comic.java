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

public class comic {
    public static void main(String[] args) throws Exception {
        new comic().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("comic").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        String w = "";
        String c = "!\"#$%&'()*+,-}/0123456789:";
        for(char cc = 'A';cc<='Z';cc++){
            w+=cc;
        }
        while(f.hasNext()){
            String ln = f.nextLine();
            for (int i = 0; i < ln.length(); i++) {
                if(ln.substring(i,i+1).matches("[A-Z]")){
                    out.print(c.charAt(w.indexOf(ln.substring(i,i+1))));
                }
                else{
                    out.print(ln.charAt(i));
                }
            }
            out.println();
        }
        f.close();
    }
}
