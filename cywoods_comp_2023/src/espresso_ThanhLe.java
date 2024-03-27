import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class espresso_ThanhLe {
    public static void main(String[] args) throws Exception {
        new espresso_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Espresso.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int b = f.nextInt();
			int bag = 1;
			double bestPrice = Double.MAX_VALUE;
			for (int i = 1; i <= b; i++) {
				double bean = f.nextDouble(), price = f.nextDouble();
				if(price/bean < bestPrice){
					bestPrice = price/bean;
					bag = i;
				}
			}
			out.println(bag);
        }
        f.close();
    }
}
