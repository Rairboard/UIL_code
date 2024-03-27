import java.util.*;
import java.io.*;

public class oscar {
    public static void main(String[] args) throws Exception {
        new oscar().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("oscar.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            System.out.println("************");
            String z = f.nextLine();
            String[] x = z.split(" ");
            if(z.length() + x.length-1 > 10)
                System.out.println("SIGN CANNOT BE MADE");
            else {
                for (int i = 0; i < x.length; i++) {
                    String y = "";
                    //while  (x[i].length())
                }
            }

        }
        f.close();
    }
}
