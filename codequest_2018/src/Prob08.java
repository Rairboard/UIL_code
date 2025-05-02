import java.util.*;
import java.io.File;

public class Prob08 {
    public static void main(String[] args) throws Exception {
        new Prob08().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Prob08").toLowerCase() + ".in.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            double[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            for (int i = 0; i < ar.length; i++) {
                if(ar[i]>=180){
                    System.out.printf("%06.2f ", ar[i]-180);
                }
                else System.out.printf("%06.2f ", ar[i] + 180);
            }
            System.out.println();
        }
        f.close();
    }
}
