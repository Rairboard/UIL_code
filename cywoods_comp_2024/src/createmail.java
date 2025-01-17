import java.io.File;
import java.util.Scanner;

public class createmail {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("createemail.dat"));

        while(scan.hasNext()) {
            int N = scan.nextInt();
            scan.nextLine();

            for(int i = 0; i < N; i++) {
                String str = scan.nextLine();
                System.out.println(str + "@hotmail.com");
            }
        }
    }
}
