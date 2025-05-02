import java.util.*;
import java.io.*;
public class stone {
	public static void main(String[] args)throws Exception {
		new stone().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("stone.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            double r = f.nextDouble(), dis = f.nextDouble();
            System.out.printf("Radius: %.1f, Distance: %.1f, Rotations: %.1f\n", r, dis, dis / (Math.PI * 2 * r));
        }
        f.close();
	}
}
