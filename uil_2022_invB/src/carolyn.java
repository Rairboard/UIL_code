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

public class carolyn {
    public static void main(String[] args) throws Exception {
        new carolyn().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("carolyn").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine().trim();
            char a = ln.charAt(0);
            char b = ln.charAt(1);
            int cnt = 1;
            if(a-b <= 0){
                for(char c = a;c<=b;c++){
                    out.println((c+"").repeat(cnt++));
                }
            }
            else{
                for(char c = a;c>b;c--){
                    out.println((c+"").repeat(cnt++));
                }
            }
        }
        f.close();
    }
}
