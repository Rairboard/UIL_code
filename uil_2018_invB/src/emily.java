import java.util.*;
import java.io.*;

public class emily {
    public static void main(String[] args) throws Exception {
        new emily().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("emily.dat"));
        //Scanner f = new Scanner(System.in);
       while(f.hasNext()){
		   double area = (double)(f.nextInt()+f.nextInt())/2 * f.nextInt();
		   if((int)area == area){
			   System.out.println((int)area);
		   }
		   else{
			   System.out.printf("%.1f%n",area);
		   }
	   }
        f.close();
    }
}
