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

public class music {
    public static void main(String[] args) throws Exception {
        new music().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("music").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        int cd = 1;
        List<String> name = new ArrayList<>();
        int time = 0;
        for (int asdf = 1; asdf <= times; asdf++) {
          String[] ln = f.nextLine().trim().split("\\s+");
          int seconds = Integer.parseInt(ln[ln.length-2]) * 60 + Integer.parseInt(ln[ln.length-1]);
            String sn = "";
            for (int i = 0; i < ln.length-2; i++) {
                sn+=ln[i]+" ";
            }
            if (seconds + time > 1200) {
                out.println("CD #" + cd++);
                out.println(name.getFirst());
                out.println(name.getLast());
                out.printf("%d:%02d\n", time / 60, time%60);
                out.println();
                name = new ArrayList<>();
                name.add(sn.trim());
                time = seconds;
            }
            else{
                time+= seconds;
                name.add(sn.trim());
            }
        }
        if(time > 0){
            out.println("CD #" + cd);
            out.println(name.getFirst());
            out.println(name.getLast());
            out.printf("%d:%02d\n", time / 60, time%60);
            out.println();
        }
        f.close();
    }
}
