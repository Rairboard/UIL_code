import java.util.*;
import java.io.*;

public class nina {
    public static void main(String[] args) throws Exception {
        new nina().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("nina.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf<=times;asdf++){
            double r = f.nextDouble();
            double side = 2 * r * Math.sin(Math.PI/5);
            double area = (5 * Math.pow(side,2))/(4 * Math.tan(Math.PI/5));
            System.out.print("LOCATION #" + asdf + " ");
            if(area <= 43560){
                System.out.printf("%.2f %.2f%n",area,side*5);
            }
            else{
                System.out.println("WILL NOT FIT");
            }
        }
        f.close();
    }
}
