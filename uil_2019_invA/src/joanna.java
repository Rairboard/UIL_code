import java.util.*;
import java.io.*;

public class joanna {
    public static void main(String[] args) throws Exception {
        new joanna().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("joanna.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			double g = f.nextDouble() * f.nextDouble(), laptop = f.nextDouble(), a = f.nextDouble(), tr = f.nextDouble()/100;
			double net = g * 10 - g*.765;
			double purchase = (laptop + laptop * tr) + (a + a * tr);
			net = Double.parseDouble(String.format("%8.1f",net) +"0");
			System.out.printf("Net Pay:  $%,8.2f%n",net);
			System.out.printf("Purchase: $%,8.2f%n",purchase);
			System.out.printf("Fun Cash: $%,8.2f%n",net - purchase);
			System.out.println("*********");
        }
        f.close();
    }
}
