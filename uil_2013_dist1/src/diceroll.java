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

public class diceroll {
    public static void main(String[] args) throws Exception {
        new diceroll().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("diceroll").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long seed = f.nextLong();
            Random r = new Random(seed);
            int r1 = r.nextInt(4)+1;
            int r2 = r.nextInt(25)+1;
            if(r1==1||r1==2){
                List<String> al = new ArrayList<>(Arrays.asList("WHITE,RED,WHITE,RED".split(",")));
                if(r1==1) Collections.rotate(al, r2);
                else Collections.rotate(al, -r2);
                out.println(al.getFirst());
            }
            else{
                List<String> al = new ArrayList<>(Arrays.asList("WHITE,BLUE,WHITE,BLUE".split(",")));
                if(r1==4) Collections.rotate(al, r2);
                else Collections.rotate(al, -r2);
                out.println(al.getFirst());
            }

        }
        f.close();
    }
}
