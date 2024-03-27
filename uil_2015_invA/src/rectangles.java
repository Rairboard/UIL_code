import java.awt.*;
import java.util.*;
import java.io.*;

public class rectangles {
    public static void main(String[] args) throws Exception {
        new rectangles().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("rectangle.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
            double x1 = f.nextDouble(), y1 = f.nextDouble(), x2 = f.nextDouble(), y2 = f.nextDouble();

        }
        f.close();
    }
}
