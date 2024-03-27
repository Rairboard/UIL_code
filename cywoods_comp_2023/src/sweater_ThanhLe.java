import java.util.*;
import java.io.File;

public class sweater_ThanhLe {
    public static void main(String[] args) throws Exception {
        new sweater_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("sweater.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int N = f.nextInt();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.println("X".repeat(N*4+3));
                }
                for (int j = 0; j < 3; j++) {
                    System.out.print("X".repeat(N)+"*");
                }
                System.out.println("X".repeat(N));
            }
            for (int i = 0; i < N; i++) {
                System.out.println("X".repeat(N*4+3));
            }
            System.out.println();
        }
        f.close();
    }
}
