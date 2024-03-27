import java.util.*;
import java.io.*;

public class manos {
    public static void main(String[] args) throws Exception {
        new manos().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("manos.dat"));
        // Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
            int in = f.nextInt() ^ f.nextInt();
            System.out.println(in != 0 ? "P1":"P2");
        }
    }

}
