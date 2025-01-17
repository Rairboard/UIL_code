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

public class rna {
    public static void main(String[] args) throws Exception {
        new rna().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("rna").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            String a = f.nextLine(),b = f.nextLine();
            boolean good = true;
            for (int i = 0; i < n; i++) {
                if ("TACG".contains(a.charAt(i) + "")) {
                    if(a.charAt(i)=='T' && b.charAt(i)!='A'){
                        good = false;
                        break;
                    }
                    if(a.charAt(i)=='A' && b.charAt(i)!='U'){
                        good = false;
                        break;
                    }
                    if(a.charAt(i)=='C' && b.charAt(i)!='G'){
                        good = false;
                        break;
                    }
                    if(a.charAt(i)=='G' && b.charAt(i)!='C'){
                        good = false;
                        break;
                    }
                }
                else{
                    good = false;
                }
            }
            if(good){
                out.println("GOOD");
            }
            else{
                out.println("BAD");
            }
        }
        f.close();
    }
}
