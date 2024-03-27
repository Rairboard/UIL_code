import java.util.*;
import java.io.*;

public class base3 {
    public static void main(String[] args) throws Exception {
        new base3().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("base3.dat"));
        //Scanner f = new Scanner(System.in);
        while (f.hasNext()) {
            String s = f.next();
            int sum = 0;
            for (int i = s.length()-1; i >= 0; i--){
                switch(s.charAt(i)){
                    case 'M': sum+=1 * (int)Math.pow(3,s.length()-i-1);break;
                    case 'A': sum += -1 * (int)Math.pow(3,s.length()-i-1);break;
                    case 'O':sum += 0 * (int)Math.pow(3,s.length()-i-1);break;
                }
            }
            System.out.println(sum);
        }
        f.close();
    }
}
