import java.util.*;
import java.io.*;

public class whydiditakegerman {
    public static void main(String[] args) throws Exception {
        new whydiditakegerman().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File("whydiditakegerman.txt"));
        Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            String ln = f.next();
            long a = Long.parseLong(ln.replaceAll("[^0-9]",""));
            long b = (long)Math.pow(10,ln.substring(ln.indexOf(".")+1).length());
            long c = gcf(a,b);
            System.out.println(a/c + " " + b/c);
        }
        f.close();
    }
    public long gcf(long cat, long dog){
        if(cat < dog){
            return gcf (dog,cat);
        }
        if(dog==0){
            return cat;
        }
        return gcf(cat%dog,dog);
    }
}