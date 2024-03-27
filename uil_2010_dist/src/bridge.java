import java.util.*;
import java.io.File;

public class bridge {
    public static void main(String[] args) throws Exception {
        new bridge().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bridge").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {

        }
        f.close();
    }
}
