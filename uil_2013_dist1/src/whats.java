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

public class whats {
    public static void main(String[] args) throws Exception {
        new whats().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("whats").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            List<int[]> al = new ArrayList<>();
            for(int i = 1;i < ar.length;i++){
                al.add(new int[]{ar[i] - ar[i-1], i});
            }
            Collections.sort(al, (a,b) -> a[0] - b[0]);
            for(int i = 0;i <4 && i < al.size();i++){
                out.println(al.get(i)[0] +" " + al.get(i)[1]);
            }
            out.println();
        }
        f.close();
    }
}
