import java.util.*;
import java.io.File;

public class slow_ThanhLe {
    public static void main(String[] args) throws Exception {
        new slow_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("slow.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int total = 0;
            String[] l = f.nextLine().split("\\+");
            for (int i = 0; i < l.length; i++) {
                total+=Integer.parseInt(l[i]);
            }
            String ln = "1+".repeat(total-1);
            System.out.println(ln + "1 makes " + total + "!");
        }
        f.close();
    }
}
