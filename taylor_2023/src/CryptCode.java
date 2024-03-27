import java.util.*;
import java.io.*;

public class CryptCode {
    public static void main(String[] args) throws Exception {
        new CryptCode().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("CryptoCode.in"));
        //Scanner f = new Scanner(System.in);
        int c = f.nextInt(), r= f.nextInt();
		f.nextLine();
        int[][] m = new int[r][c];
		for (int i = 0; i < r; i++) {
			m[i] = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		}
		for (int i = 0; i < r; i++) {
			long prod = 1;
			for (int j = 0; j < c; j++) {
				prod *= m[i][j];
			}
			System.out.printf("%02d ",prod%100);
		}
        f.close();
    }
}
