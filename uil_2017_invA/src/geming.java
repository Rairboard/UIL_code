import java.util.*;
import java.io.*;

public class geming {
    public static void main(String[] args) throws Exception {
        new geming().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("geming.dat"));
        //Scanner f = new Scanner(System.in)
        while (f.hasNext()) {
			int N = f.nextInt();
			System.out.println(N + " " +(-N-1));
        }
        f.close();
    }
}
