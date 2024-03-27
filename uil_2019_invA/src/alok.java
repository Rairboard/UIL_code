import java.util.*;
import java.io.*;

public class alok {
    public static void main(String[] args) throws Exception {
        new alok().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("alok.dat"));
        //Scanner f = new Scanner(System.in);
        double sum = 0;
		double c = 0;
		while(f.hasNext()){
			double d = f.nextDouble();
			sum+=d;
			c++;
		}
		System.out.printf("$%.2f%n",sum);
		System.out.printf("$%.2f%n",sum/c);
        f.close();
    }
}
