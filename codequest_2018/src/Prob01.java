import java.util.*;
import java.io.File;

public class Prob01 {
    public static void main(String[] args) throws Exception {
        new Prob01().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Prob01").toLowerCase() + ".in.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			System.out.println(f.nextLong() >= 70 ? "PASS":"FAIL");
        }
        f.close();
    }
}
