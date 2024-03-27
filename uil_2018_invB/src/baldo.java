import java.util.*;
import java.io.*;

public class baldo {
    public static void main(String[] args) throws Exception {
        new baldo().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File("baldo.dat"));
        //Scanner f = new Scanner(System.in);
//        int times = f.nextInt();
//        while (times-- > 0) {
//
//        }
		char c = 'A';
		while(c <= 'Z'){
			System.out.println(c + " " + (int)c + " " + Character.toLowerCase(c) + " " + (int)(Character.toLowerCase(c)));
			c++;
		}
    }
}
