import java.util.*;
import java.io.*;
public class savings {
	public static void main(String[] args)throws Exception {
		new savings().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("savings.dat"));
        //Scanner f = new Scanner(System.in);
        double total = 0;
        while(f.hasNext()){
            double p = f.nextDouble();
            if((long)p != p){
                p%=1;
                total += 1-p;
            }
        }
        System.out.printf("$%.2f\n", total);
        f.close();
	}
}
