import java.awt.*;
import java.util.*;
import java.io.*;
public class inside {
	public static void main(String[] args)throws Exception {
		new inside().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("inside.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int corner = f.nextInt(), point = f.nextInt();
            f.nextLine();
            Polygon p = new Polygon();
            for (int i = 0; i < corner; i++) {
                p.addPoint(f.nextInt(),f.nextInt());
            }
            for (int i = 0; i < point; i++) {
                int x = f.nextInt(), y = f.nextInt();
                if (p.contains(x, y)) {
                    System.out.println("inside");
                }
                else System.out.println("outside");
            }
        }
        f.close();
	}
}
