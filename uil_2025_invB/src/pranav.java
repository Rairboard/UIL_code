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

public class pranav {
    public static void main(String[] args) throws Exception {
        new pranav().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("pranav").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long[] pots = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            Arrays.sort(pots);
            long you = 0, other = 0;
            for(int i = pots.length-1;i>=1;i-=2){
                you+=pots[i];
                other+=pots[i-1];
            }
            if(you>other) out.println("Winner " + you);
            else if(you==other) out.println("Tie " + you);
            else out.println("Loser "+ other);
        }
        f.close();
    }
}
