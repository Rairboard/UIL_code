import java.util.*;
import java.io.File;

public class planetx {
    public static void main(String[] args) throws Exception {
        new planetx().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("planetx").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine().trim();
            int gleeb = 0;
            int glorb = 0;
            for (int i = 0; i < ln.length() - 4; i++) {
                if (ln.substring(i, i + 5).equalsIgnoreCase("gleeb")) {
                    gleeb++;
                } else if (ln.substring(i, i + 5).equalsIgnoreCase("glorb")) {
                    glorb++;
                }
            }
            System.out.println(gleeb+" " +glorb);
        }
        f.close();
    }
}
