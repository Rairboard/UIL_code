import java.util.*;
import java.io.*;
class barb{
	public static void main(String[] args)throws Exception{
	   new barb().run();
	}
	public void run()throws Exception{
        // Scanner f = new Scanner(System.in);
        Scanner f = new Scanner(new File("barb.dat"));
        int N = f.nextInt();
        System.out.println("A   A*A   3*A   A/2");
        for(int i=1;i<=N;i++){
            System.out.println(i + "     " + (i*i) + "     " + (i*3) + "     " + (i/2));
        }
    }
}
