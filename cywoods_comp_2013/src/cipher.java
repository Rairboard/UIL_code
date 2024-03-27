import java.util.*;
import java.io.*;

public class cipher {
    public static void main(String[] args) throws Exception {
        new cipher().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("cipher.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
		String s = "bcdefghijklmnopqstuvxyz";
        f.nextLine();
        while (times-- > 0) {
			String[] l = f.nextLine().split("\\s+");
			String res = "";
			for (int i = 0; i < l.length; i++) {
				char[] w = l[i].toCharArray();
				for (int j = 0; j < w.length; j++) {
					if((w[j]+"").matches("[^war]")){
						int N = ((s.indexOf(w[j])-1) + s.length()) % s.length();
						w[j] = s.charAt(N);
					}
				}
				res +=  new String(w)+ " ";
			}
			System.out.println(res.trim());
        }
        f.close();
    }
}
