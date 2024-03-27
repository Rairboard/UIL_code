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

public class word {
    public static void main(String[] args) throws Exception {
        new word().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("wordlist").toLowerCase() + ".txt"));
        Map<String,String> m = new HashMap<>();
        while(f.hasNext()){
            String s = f.next();
            char[] c = s.toCharArray();
            Arrays.sort(c);
            m.put(new String(c),s);
        }
        f = new Scanner(new File(("word").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()) {
            char[] c = f.nextLine().toCharArray();
            Arrays.sort(c);
            out.println(m.get(new String(c)));
        }
        f.close();
    }
}
