import java.util.*;
import java.io.*;

public class lamb {
    public static void main(String[] args) throws Exception {
        new lamb().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("lamb.dat"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            System.out.println(f.nextLine().toLowerCase().replaceAll("[^lamb]","").contains("lamb")?"Lamb location confirmed.":"Where's the lamb sauce?!?");
        }
        f.close();
    }
}