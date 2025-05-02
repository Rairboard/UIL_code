import java.util.*;
import java.io.*;
public class reversepals {
	public static void main(String[] args)throws Exception {
		new reversepals().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("reversepals.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            long n = f.nextLong();
            int cnt = 0;
            while (!(n + "").equals(new StringBuilder(n + "").reverse().toString())) {
                n+=Long.parseLong(new StringBuilder(n+"").reverse().toString());
                cnt++;
            }
            System.out.println(n + " " + cnt);
        }
        f.close();
	}
}
