import java.util.*;
import java.io.*;

public class infinitepiratetheorem {
    public static void main(String[] args) throws Exception {
        new infinitepiratetheorem().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("infinitepiratetheorem.txt"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            System.out.println(f.nextLine().toLowerCase().replaceAll("[argh matey]","").length()==0?"Yes":"No");
        }
        f.close();
    }
}