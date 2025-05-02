import java.util.*;
import java.io.*;
public class becker {
	public static void main(String[] args)throws Exception {
		new becker().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("becker.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            double a = f.nextDouble(), r = f.nextDouble()/100, n = f.nextDouble(), t = f.nextDouble();
            double p = a / Math.pow((1 + r/n),n * t);
            System.out.printf("%.0f\n", Math.ceil(p));
        }
        f.close();
	}
}
