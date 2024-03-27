import java.util.*;
import java.io.*;

public class leonardo {
    public static void main(String[] args) throws Exception {
        new leonardo().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("leonardo.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String[] y = f.nextLine().split("=");

            String[] l = y[0].split(" ");
//            System.out.println(Arrays.toString(l));
            for(String x : l)
                System.out.print((x.charAt(0)+"").toUpperCase());
            System.out.print(" = ");
            l = y[1].split(" ");

//            System.out.println(Arrays.toString(l));
            for (int i = 1; i < l.length; i++) {
                System.out.print((l[i].charAt(l[i].length()-1)+"").toUpperCase());
            }

            System.out.println();

        }
        f.close();
    }
}
