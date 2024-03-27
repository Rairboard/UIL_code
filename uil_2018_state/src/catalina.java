import java.util.*;
import java.io.*;

public class catalina {
    public static void main(String[] args) throws Exception {
        new catalina().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("catalina.dat"));

        while (f.hasNext()) {

            String str = "";
            String line =f.nextLine().trim().replaceAll("[^A-Z]","");
            System.out.println(line);
        }
        f.close();
    }
}
