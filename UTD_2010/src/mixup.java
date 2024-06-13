import java.util.*;
import java.io.File;

public class mixup {
    public static void main(String[] args) throws Exception {
        new mixup().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("mixup").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().split("\\s+");
            for (int i = 0; i < ln.length; i++) {
                ln[i] = new StringBuilder(ln[i]).reverse().toString();
            }
            for (int i = 0; i < ln.length; i++) {
                System.out.print(ln[i]+ " ");
            }
            System.out.println();
        }
        f.close();
    }
}
