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

public class rishi {
    public static void main(String[] args) throws Exception {
        new rishi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("rishi").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()) {
            String ln = f.nextLine();
            if(ln.substring(0,1).matches("\\d")){
                String[] num = ln.split("[^0-9]");
                ln = ln.replaceAll("[0-9]","");
                for (int i = 0; i < num.length; i++) {
                    out.print(ln.substring(i,i+1).repeat(Integer.parseInt(num[i])));
                }
            }
            else{
                for (int i = 0; i < ln.length(); i++) {
                    int j = i;
                    int cnt = 0;
                    while(j<ln.length() && ln.charAt(j)==ln.charAt(i)){
                        j++;
                        cnt++;
                    }
                    out.print(cnt+ln.substring(i,i+1));
                    i=j-1;
                }
            }
            out.println();
        }
        f.close();
    }
}
