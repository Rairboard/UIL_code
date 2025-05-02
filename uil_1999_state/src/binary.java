import java.util.*;
import java.io.*;
public class binary {
	public static void main(String[] args)throws Exception {
		new binary().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("binary.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String ln = f.nextLine().trim();
            System.out.println(ln + " = " + Integer.parseInt(ln, 2));
        }
        f.close();
	}
}
