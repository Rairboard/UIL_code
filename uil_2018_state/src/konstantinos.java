import java.util.*;
import java.io.*;

public class konstantinos {
    public static void main(String[] args) throws Exception {
        new konstantinos().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("konstantinos.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int x1 = f.nextInt(), y1 = f.nextInt(), r1=f.nextInt(), x2 = f.nextInt(), y2 = f.nextInt(), r2 = f.nextInt();
            double d = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
            if(d==r1+r2){
                System.out.println("EXTERNALLY TANGENT");
            }
            else if(d>r1+r2){
                System.out.println("NON-INTERSECTING");
            }
            else if(Math.abs(r1-r2) == d){
                System.out.println("INTERNALLY TANGENT");
            }
            else if(Math.abs(r1-r2) > d){
                System.out.println("NESTED");
            }
            else{
                System.out.println("INTERSECTING");
            }
//            System.out.println(d + " " + r1 + " " + r2);
        }
        f.close();
    }
}
