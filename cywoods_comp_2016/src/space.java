import java.util.*;
import java.io.*;
public class space {
	public static void main(String[] args)throws Exception {
		new space().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("space.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int  n = f.nextInt(), s= f.nextInt();
            f.nextLine();
            Map<Integer,List<String>> m = new HashMap<>();
        }
        f.close();
	}
}
