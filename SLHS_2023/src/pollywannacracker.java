import java.util.*;
import java.io.*;

public class pollywannacracker {
    public static void main(String[] args) throws Exception {
        new pollywannacracker().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("pollywannacracker.txt"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            String ln = f.nextLine();
            for (int i = 1; i <= ln.length(); i++) {
                if(ln.replaceAll(ln.substring(0,i),"").length()==0){
                    System.out.println(ln.substring(0,i));
                    break;
                }
            }
        }
        f.close();
    }
}