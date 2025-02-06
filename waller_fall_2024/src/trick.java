import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class trick {
    public static void main(String[] args) throws Exception {
        new trick().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("trick").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String line = f.nextLine().trim();
            String[] ln = line.split("\\s+AND|OR\\s+");
            String[] a = ln[0].trim().split("\\s+",2);
            String[] b = ln[1].trim().split("\\s+",2);
            String ans = "not (";
            if(a.length==1){
                ans+="not " + a[0];
            }
            else{
                ans+=a[1];
            }
            if (line.contains("AND")) {
                ans+=" OR ";
            }
            else{
                ans+=" AND ";
            }
            if(b.length==1){
                ans+="not " + b[0];
            }
            else{
                ans+=b[1];
            }
            out.println(ans + ")");
        }
        f.close();
    }
}
