import java.util.*;
import java.io.File;

public class vowely {
    public static void main(String[] args) throws Exception {
        new vowely().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("vowely.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String s = f.nextLine();
            int mid = s.length() % 2==0 ? s.length()/2 : s.length()/2+1;
            System.out.println(s.replaceAll("[^aeiou]","").length()>=mid?"YES":"NO");
        }
        f.close();
    }
}
