import java.util.*;
import java.io.*;
public class bruno {
	public static void main(String[] args)throws Exception {
		new bruno().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("bruno.dat"));
        //Scanner f = new Scanner(System.in);
        long total = 0;
		while(f.hasNext()){
			total+=f.nextLine().trim().split("\\s+").length;
		}
		System.out.println(total);
        f.close();
	}
}
