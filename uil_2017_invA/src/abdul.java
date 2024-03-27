import java.util.*;
import java.io.*;

public class abdul {
    public static void main(String[] args) throws Exception {
        new abdul().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("abdul.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
			System.out.println((int)Math.pow(f.nextInt(),2));
        }
        f.close();
    }
}
