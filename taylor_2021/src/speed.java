import java.util.*;
import java.io.File;

public class speed {
    public static void main(String[] args) throws Exception {
        new speed().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("speed.dat"));
        //Scanner f = new Scanner(System.in);
        double conversion = 1609.34;
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            double d = f.nextDouble();
            System.out.println(343.0*d/1609.34);
            System.out.printf("%.1f\n",343.0*d/1609.34);
        }
        f.close();
    }
}
