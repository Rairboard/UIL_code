import java.util.*;
import java.io.*;

public class friendly {
    public static void main(String[] args) throws Exception {
        new friendly().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("friendly.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String time = f.next();
            String s = f.nextLine().substring(1);
            String[] t = time.split(":");
            long A = Long.parseLong(t[0]) * 9;
            long B = Long.parseLong(t[1]) * 3 + Long.parseLong(t[2]);
            System.out.print(time + " ");
            for (int i = 0; i < s.length(); i++) {
                System.out.printf("0x%02X ", i%2==0 ? s.charAt(i) ^ A:s.charAt(i) ^ B);
            }
            System.out.println();
        }
        f.close();
    }
}
