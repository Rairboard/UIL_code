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

public class html {
    public static void main(String[] args) throws Exception {
        new html().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("html").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String a = f.nextLine().trim();
            String b = f.nextLine().trim();
            Stack<String> A = new Stack<>();
            Stack<String> B = new Stack<>();
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i)=='<'){
                    if(a.charAt(i+1) != '/'){
                        A.push(a.substring(i+1, a.indexOf(">",i+1)));
                    }
                }
            }
            for (int i = 0; i < b.length(); i++) {
                if(b.charAt(i)=='<'){
                    if(b.charAt(i+1) != '/'){
                        B.push(b.substring(i+1, b.indexOf(">",i+1)));
                    }
                }
            }
//            out.println(A);
//            out.println(B);
            boolean same = true;
            for (int i = 0; i < A.size() && i < B.size(); i++) {
                if(!A.get(i).equals(B.get(i))){
                    same = false;
                }
            }
            if (A.size() != B.size()) {
                same = false;
            }
            if(same){
                out.println("same");
            }
            else{
                out.println("different");
            }
        }
        f.close();
    }
}
