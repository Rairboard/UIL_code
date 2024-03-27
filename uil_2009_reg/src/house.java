import java.util.*;
import java.io.*;

public class house {
    public static void main(String[] args) throws Exception {
        new house().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("house.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
            int zero = f.nextInt(), one = f.nextInt();
            String b = Integer.toString(f.nextInt(),2);
            double total = (zero * b.replaceAll("1","").length()) + (one * b.replaceAll("0","").length());
            System.out.printf("%s $%01.2f%n",b,total/100);
        }
        f.close();
    }
}
