import java.util.*;
import java.io.*;
public class odd {
	public static void main(String[] args)throws Exception {
		new odd().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("odd.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            char[] c = f.nextLine().toCharArray();
            Arrays.sort(c);
            System.out.println( new String(c));
        }
        f.close();
	}
}
