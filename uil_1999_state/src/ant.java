import java.util.*;
import java.io.*;
public class ant {
	public static void main(String[] args)throws Exception {
		new ant().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("ant.dat"));
        //Scanner f = new Scanner(System.in);
        int cnt = 1;
        while(f.hasNext()){
            int n = f.nextInt();
            double prevX = 0, prevY = 0;
            double total = 0, direct = 0;
            for (int i = 0; i < n; i++) {
                double x = f.nextDouble(), y = f.nextDouble();
                total+=Math.sqrt(Math.pow(prevX - x,2) + Math.pow(prevY - y, 2));
                prevX = x;
                prevY = y;
                if(i==n-1){
                    direct = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
                }
            }
            System.out.printf("Source #%d, the travel distance is %.2f and the actual distance is %.2f\n", cnt++, total, direct);
        }
        f.close();
	}
}
