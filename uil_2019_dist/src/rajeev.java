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

public class rajeev {
    public static void main(String[] args) throws Exception {
        new rajeev().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("rajeev").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String[] ln = f.nextLine().split(",");
            String file = ln[0], owner = ln[1];
            boolean flag = false;
            List<String> invalid = new ArrayList<>();
            for (int i = 2; i < ln.length; i++) {
                if (!ln[i].matches(".*@(uiltexas.org|uil.net)")) {
                    flag = true;
                    invalid.add(ln[i]);
                }
            }
            if(flag){
                out.print(file+":"+owner+":");
                for (int i = 0; i < invalid.size() ; i++){
                    out.print(invalid.get(i));
                    if(i<invalid.size()-1){
                        out.print(":");
                    }
                }
                out.println();
            }
        }
        f.close();
    }
}
