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
            System.out.println(f.nextInt() == f.nextInt() ? "P2":"P1");
        }
    }

}
