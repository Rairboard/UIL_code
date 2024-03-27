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

public class joan {
    public static void main(String[] args) throws Exception {
        new joan().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("joan").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int w = 0;
        double total = 0;
        while(f.hasNext()){
            w++;
            total+=f.next().length();
        }
        out.println(w + " words with an average length of " + Math.round(total/w) + " letters");
        f.close();
    }
}
