import java.util.*;
import java.io.*;

public class elements {
    public static void main(String[] args) throws Exception {
        new elements().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("elements.in"));
        //Scanner f = new Scanner(System.in);
        String[] ln = f.nextLine().split("\\s+");
        int times = f.nextInt();
        while(times-->0){
            String s = f.nextLine();

        }
        f.close();
    }
}
