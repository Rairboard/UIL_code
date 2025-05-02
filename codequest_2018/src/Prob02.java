import java.util.*;
import java.io.*;
public class Prob02 {
	public static void main(String[] args)throws Exception {
		new Prob02().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob02.in.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String ln = f.nextLine().toLowerCase().trim();
            int cnt = 0;
            for (int i = 0; i < ln.length(); i++) {
                if (ln.substring(i, i + 1).matches("[aeiou]")) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
        f.close();
	}
}
