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

public class pick_ThanhLe {
    public static void main(String[] args) throws Exception {
        new pick_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("pick").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ans = f.nextLine().trim().split("\\s+");
            out.println("Test " + asdf);
            for (int i = 0; i < 5; i++) {
                String[] person = f.nextLine().trim().split("\\s+");
                double right = 0;
                for (int j = 1; j < person.length; j++) {
                    if (person[j].equals(ans[j - 1])) {
                        right++;
                    }
                }
                out.printf("%s %.2f %s\n", person[0], right/ans.length*100, "%");
            }
        }
        f.close();
    }
}
