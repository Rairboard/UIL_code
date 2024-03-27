import java.util.*;
import java.io.*;

public class typingtest {
    public static void main(String[] args) throws Exception {
        new typingtest().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("typingtest.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();f.nextLine();
        while (times-- > 0) {
			String[] s= f.nextLine().split("\\s+");
			System.out.println(Math.round(60.0/Integer.parseInt(s[0])*(s.length-1))+ " WPM");
        }
        f.close();
    }
}
