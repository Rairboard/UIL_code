import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class curry_ThanhLe {
    public static void main(String[] args) throws Exception {
        new curry_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("curry").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long n = f.nextLong(), x = f.nextLong(), y = f.nextLong();
            int seconds = 0;
            while(n>0){
                n-= Math.min(x,Math.min(n,y));
                seconds++;
            }
            out.println(seconds);
        }
        f.close();
    }
}
