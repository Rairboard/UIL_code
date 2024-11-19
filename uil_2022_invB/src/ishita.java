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

public class ishita {
    public static void main(String[] args) throws Exception {
        new ishita().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ishita").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            Stack<Character> st = new Stack<>();
            String ln = f.nextLine();
            int open = 0;
            int close =0;
            for (int i = 0; i < ln.length(); i++) {
                if(ln.charAt(i)=='('){
                    open++;
                }
                else if(ln.charAt(i)==')'){
                    close++;
                }
            }
            if(open==close){
                int n = open-1;
                out.println((n * (n+1))/2);
            }
            else{
                out.println(0);
            }
        }
        f.close();
    }
}
