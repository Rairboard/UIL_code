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

public class patterns {
    public static void main(String[] args) throws Exception {
        new patterns().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("patterns").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        out : for (int asdf = 1; asdf <= times; asdf++) {
            String a = f.next(), b = f.next();
            Map<Character, Integer> OLD = new HashMap<>();
            Map<Character, Integer> NEW = new HashMap<>();
            if(a.length() != b.length()){
                out.println("NO");
                continue;
            }
            for (int i = 0; i < a.length(); i++) {
                OLD.put(a.charAt(i), OLD.getOrDefault(a.charAt(i), 0) + 1);
                NEW.put(b.charAt(i), NEW.getOrDefault(b.charAt(i), 0) + 1);
            }
            for (int i = 0; i < a.length(); i++) {
                if (OLD.get(a.charAt(i)) != NEW.get(b.charAt(i))) {
                    out.println("NO");
                    continue out;
                }
            }
            out.println("YES");
        }
        f.close();
    }
}
