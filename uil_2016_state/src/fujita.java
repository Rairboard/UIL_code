import java.util.*;
import java.io.*;
public class fujita {
	public static void main(String[] args)throws Exception {
		new fujita().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("fujita.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            System.out.println("*".repeat((int)Math.ceil(Math.log(f.nextDouble()) / Math.log(f.nextDouble()))));
        }
        f.close();
	}
}
