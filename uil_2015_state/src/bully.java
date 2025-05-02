import java.util.*;
import java.io.*;
public class bully {
	public static void main(String[] args)throws Exception {
//		new bully().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("bully.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            long b = f.nextLong(), r = f.nextLong();
            long total = b;
            while(b>=r){
                b-=r;
                b++;
                total++;
            }
            System.out.println(total);
        }
        f.close();
	}
}
