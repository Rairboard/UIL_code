import java.util.*;
import java.io.*;
public class receipt {
	public static void main(String[] args)throws Exception {
		new receipt().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("receipt.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String[] item = f.nextLine().trim().split("\\s+");
            double a = f.nextDouble(), b = f.nextDouble(), c = f.nextDouble(), d = f.nextDouble(), e = f.nextDouble(), F = f.nextDouble();
            f.nextLine();
            System.out.println("Grocery Store #" + asdf + ":");
            try{
                double slope1 = -a/b;
                double slope2 = -d/e;
                if(slope2 == slope1){
                    System.out.println("CANNOT COMPUTE PRICES");
                }
                else{
                    double y = (F - d * c/a) / (-d*b/a + e);
                    double x = (c-b*y)/a;
                    System.out.printf("%s: %.2f, %s: %.2f\n", item[0], x, item[1], y);
                }
            }catch (Exception E){
                System.out.println("CANNOT COMPUTE PRICES");
            }
        }
        f.close();
	}
}
