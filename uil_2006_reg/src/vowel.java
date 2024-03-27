import java.util.*;
import java.io.*;

public class vowel {
    public static void main(String[] args) throws Exception {
        new vowel().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("vowel.in"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        String vow = "aeiouAEIOU";
        while (t-- > 0) {
            String str = f.next();
            if(!str.isEmpty()){
                System.out.println(vow.contains(str.charAt(0)+"")? "The word '"+ str+"' begins with a vowel.":"The word '"+ str+"' begins with a consonant.");
            }
        }
        f.close();
    }
}