import java.util.*;
import java.io.*;

public class lawn {
    static char[][]m;
    public static void main(String[] args) throws Exception {
        new lawn().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("lawn.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
            int r =f.nextInt(), c = f.nextInt();
            f.nextLine();
            m =new char[r][c];
            for (int i = 0; i < r; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            
        }
        f.close();
    }
}
