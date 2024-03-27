import java.util.*;
import java.io.*;

public class thepiratejimmy {
    public static void main(String[] args) throws Exception {
        new thepiratejimmy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("thepiratejimmy.txt"));
        System.out.println(f.nextLine().toLowerCase().equals("gold coin")?"yes":"no");
        f.close();
    }
}