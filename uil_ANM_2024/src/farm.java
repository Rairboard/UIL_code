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

public class farm {
    public static void main(String[] args) throws Exception {
        new farm().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("farm").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt(), n = f.nextInt();
        f.nextLine();
        List<String> al = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine();
            if (al.contains(ln)) {
                out.println("SHIPMENT DISAPPROVED");
            }
            else{
                int d = 1, in = 0;
                while(d * d < ln.length()){
                    d++;
                }
                char[][] m = new char[d][d];
                for(int i = d-1;i>-1;i--){
                    for (int j = 0; j < m[i].length; j++) {
                        if(in>=ln.length()){
                            m[i][j] = '*';
                        }
                        else{
                            m[i][j] = ln.charAt(in++);
                        }
                    }
                }
                for(char[] cc :m ){
                    out.println(cc);
                }
            }
            out.println();
        }
        f.close();
    }
}
