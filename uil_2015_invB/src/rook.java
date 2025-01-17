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

public class rook {
    public static void main(String[] args) throws Exception {
        new rook().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("rook").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt(), rook = f.nextInt();
            f.nextLine();
			HashSet<Integer> R = new HashSet<>(), C = new HashSet<>();
            for (int i = 0; i < rook; i++) {
                R.add(f.nextInt());
                C.add(f.nextInt());
            }
            int good = 0;
            for (int i = 0; i < row; i++) {
                if(R.contains(i)) continue;
                for (int j = 0; j < col; j++) {
                    if(C.contains(j)) continue;
                    good++;
                }
            }
            out.println(good);
        }
        f.close();
    }
}
