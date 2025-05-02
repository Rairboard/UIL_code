import java.util.*;
import java.io.*;

public class michaela {
    public static void main(String[] args) throws Exception {
        new michaela().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("michaela.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
		f.nextLine();
		for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine().toUpperCase();
			System.out.print("Message #" + asdf + ": ");
			for (int i = 0; i < ln.length(); i++) {
				int n = ln.charAt(i);
				String bit = Integer.toBinaryString(n);
				for (int j = 0; j < bit.length(); j++) {
					if(bit.charAt(j)=='1'){
						System.out.print("-");
					}
					else System.out.print(".");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
        f.close();
    }
}
