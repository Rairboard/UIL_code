import java.util.*;
import java.io.*;

public class bestday {
    public static void main(String[] args) throws Exception {
        new bestday().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("bestday.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        String[] ar = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
        while (times-- > 0) {
            String s = f.nextLine();
            String[] l = s.split("\\s+");
            int max = 0, in = 0;
            for (int i = 0; i < l.length; i++) {
                if(Integer.parseInt(l[i]) > max){
                    max = Integer.parseInt(l[i]);
                    in = i;
                }
            }
            System.out.println(ar[in]);
        }
        f.close();
    }
}
