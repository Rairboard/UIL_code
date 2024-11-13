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

public class helena {
    public static void main(String[] args) throws Exception {
        new helena().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("helena").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int s = f.nextInt(), n = f.nextInt();
            if(f.hasNext())f.nextLine();
            while(n-->0){
                String ln = f.nextLine();
                String ret = "";
                for (int i = 0; i < ln.length(); i+= s*2) {
                    if(i+s*2<=ln.length()){
                        String front = new StringBuilder(ln.substring(i,i+s)).reverse().toString();
                        String back = new StringBuilder(ln.substring(i+s,i+s*2)).reverse().toString();
                        ret+=back+front;
                    }
                    else{
                        String rest = ln.substring(i);
                        String front = new StringBuilder(rest.substring(0,rest.length()/2+1)).reverse().toString();
                        String back = new StringBuilder(rest.substring(rest.length()/2+1)).reverse().toString();
                        ret +=back+front;
                        break;
                    }
                }
                out.println("'" + ret + "'");
            }
            out.println("=".repeat(25));
        }
        f.close();
    }
}
