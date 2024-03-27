import java.util.*;
import java.io.*;

public class dylan {
    public static void main(String[] args) throws Exception {
        new dylan().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("dylan.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			long k = f.nextLong(), r = f.nextLong(), c =f.nextLong();
			long ppl = (r-1) * (k*2);
			long d = Math.abs(k-c) * 2;
            if(c>=k){
                d-=1;
            }
            System.out.println(ppl+d);
        }
        f.close();
    }
}
