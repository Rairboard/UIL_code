import java.util.*;
import java.io.*;

public class duplicates {
    public static void main(String[] args) throws Exception {
        new duplicates().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("duplicates.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
		f.nextLine();
        while (times-- > 0){
			System.out.println(f.nextLine().matches(".*A.*E.*I.*O.*U.*")?"YES":"NO");
        }
        f.close();
    }
}
