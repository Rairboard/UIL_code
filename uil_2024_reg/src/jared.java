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

public class jared {
    public static void main(String[] args) throws Exception {
        new jared().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("jared").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().split(",");
            int cnt = 0;
            for (int i = 0; i < ln.length; i++) {
                for (int j = 0; j < ln.length; j++) {
                    if(i!=j){
                        if (ln[j].startsWith(ln[i])) {
                            cnt++;
                        }
                    }
                }
            }
            if(cnt>0) out.println("There are " + cnt + " misinputs...");
            else out.println("Democracy Prevails!");
        }
        f.close();
    }
}
