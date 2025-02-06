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

public class tom {
    public static void main(String[] args) throws Exception {
        new tom().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("tom").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine().trim();
            Map<Character, Integer> m = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < ln.length(); i++) {
                m.putIfAbsent(ln.charAt(i), 0);
                sum += 1 + m.get(ln.charAt(i));
                m.put(ln.charAt(i), m.get(ln.charAt(i))+1);
            }
            out.println(sum);
        }
        f.close();
    }
}
