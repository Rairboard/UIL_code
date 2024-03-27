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

public class dna {
    public static void main(String[] args) throws Exception {
        new dna().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dna").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String a = f.nextLine(), b = f.nextLine(),s = "";
            int max = 0;
            for (int i = 0; i < a.length(); i++) {
                for (int j=a.length();j>i;j--) {
                    if (b.contains(a.substring(i, j))) {
                        if(a.substring(i,j).length()>max){
                            max = a.substring(i,j).length();
                            s = a.substring(i,j);
                            break;
                        }
                    }
                }
            }
            out.println(s.length()<=1?1:max+" "+s);
        }
        f.close();
    }
}
