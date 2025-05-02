import java.util.*;
import java.io.*;
public class prob04 {
	public static void main(String[] args)throws Exception {
		new prob04().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("prob04-1-in.txt"));
        //Scanner f = new Scanner(System.in);
        String a = f.nextLine().trim();
        String input = "";
        while(f.hasNext()){
            input+=f.nextLine().trim();
        }
        String[] ln = input.split(a);
        for (int i = 0; i < ln.length; i++) {
            System.out.println(ln[i]);
        }
        f.close();
	}
}
