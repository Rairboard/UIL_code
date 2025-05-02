import java.util.*;
import java.io.*;
public class burpees {
	public static void main(String[] args)throws Exception {
        RedPanda a = new RedPanda("Tom","Jerry");
        System.out.println(a.name);
        System.out.println(a.i);
//		new burpees().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("burpees.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            long n = f.nextLong();
            System.out.println(n * (n+1)/2);
        }
        f.close();
	}
}
