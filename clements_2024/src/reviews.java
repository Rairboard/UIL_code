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

public class reviews {
    List<String> good = new ArrayList<>(Arrays.asList("groundbreaking, wonderful, wonderfully, entertaining, one-of-a-kind, incredible, unforgettable, unforgettably, interesting, exceptional, masterful, brilliant, brilliantly, enjoyable, masterpiece, entertained".split(",\\s+")));
    List<String> bad = new ArrayList<>(Arrays.asList("boring, poorly, lackluster, forgettable, messy, disappointing, uninspired, messily, disappointingly, ridiculous, trash, monotonous, flawed, confused, far-fetched, confusing".split(",\\s+")));
    public static void main(String[] args) throws Exception {
        new reviews().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("reviews").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int g = 0, b = 0;
            while (f.hasNext()) {
                String ln = f.nextLine().trim();
                if (ln.matches("-{20,}")) {
                    break;
                }
                else{
                    String[] word = ln.split("[ ?,.!]+");
                    for (int i = 0; i < word.length; i++) {
                        if(word[i].isEmpty()) continue;
                        if (good.contains(word[i].toLowerCase())) {
                            g++;
                        } else if (bad.contains(word[i].toLowerCase())) {
                            b++;
                        }
                    }
                }
            }
            out.println(g == b ? "Make up your mind.": (g > b ? "This is one for the books.":"You lack vision."));
        }
        f.close();
    }
}
