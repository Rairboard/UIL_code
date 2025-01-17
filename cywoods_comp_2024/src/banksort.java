import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class banksort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("banksort.dat"));
        int n=in.nextInt();
        in.nextLine();
        while(n-->0){
            long sum=0;
            for (int i = 0; i < 10; i++) {
                if(in.hasNextInt()){
                    sum+=in.nextInt();
                    in.nextLine();
                }
                else in.nextLine();
            }
            System.out.println(sum);
            if(in.hasNextLine()) in.nextLine();
        }
    }
}
