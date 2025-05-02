import java.util.*;
import java.io.*;
public class vc1 {
	public static void main(String[] args)throws Exception {
		new vc1().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("vc1.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int p = f.nextInt();
            long[] A = new long[p], B = new long[p];
            for (int i = 0; i < p; i++) {
                A[i] = f.nextLong();
            }
            for (int i = 0; i < p; i++) {
                B[i] = f.nextLong();
            }
            boolean good = true;
            for (int i = 0; i < p; i++) {
                if(A[i] > B[i]){
                    good = false;
                    break;
                }
            }
            if(!good){
                good = true;
                for (int i = 0; i < p; i++) {
                    if(B[i] > A[i]){
                        good = false;
                        break;
                    }
                }
                if(good) System.out.println("B -> A");
                else System.out.println("A || B");
            }
            else{
                System.out.println("A -> B");
            }
        }
        f.close();
	}
}
