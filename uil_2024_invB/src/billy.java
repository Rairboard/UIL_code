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

public class billy {
    public static void main(String[] args) throws Exception {
        new billy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("billy").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String best = "";
        double bs = 0;
        while(f.hasNext()){
			String ln = f.nextLine();
            double w = f.nextDouble(), l = f.nextDouble();
            f.nextLine();
            double score = l==0?w : w/ l;
            if(score > bs){
                bs = score;
                best = ln;
            }
        }
        out.println(best);
        f.close();
    }
}
