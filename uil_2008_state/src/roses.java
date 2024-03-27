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

public class roses {
    public static void main(String[] args) throws Exception {
        new roses().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("roses").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            List<String> al = new ArrayList<>(Arrays.asList(f.nextLine().split(",\\s+")));
            int i = 0;
            int[] val = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < val.length; j++) {
                int idx = (i + (val[j]-1)+al.size())%al.size();
                i = idx;
                out.println("LOSER " + al.remove(idx));
            }
            out.println("WINNER " + al.getFirst());
            out.println();
        }
        f.close();
    }
}
