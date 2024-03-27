import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class igor {
    HashSet<String>hs;
    public static void main(String[] args) throws Exception {
        new igor().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("igor.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
            hs = new HashSet<>();
            String ln = f.nextLine();
            permu(ln,"");
            out.println(hs.size());
        }
        f.close();
    }
    public void permu(String orig, String cur) {
        if (orig.length() == 0) {
            for (int i = 0; i < cur.length()-1; i++) {
                for (int j = i+1; j <= cur.length(); j++) {
                    if (new StringBuilder(cur.substring(i, j)).reverse().toString().equals(cur.substring(i, j))) {
                        hs.add(cur.substring(i,j));
                    }
                }
            }
        } else {
            for (int i = 0; i < orig.length(); i++) {
                permu(orig.substring(0, i) + orig.substring(i + 1), cur + orig.charAt(i));
            }
        }
    }
}
