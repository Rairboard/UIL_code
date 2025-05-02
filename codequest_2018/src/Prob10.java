import java.util.*;
import java.io.*;
public class Prob10 {
	public static void main(String[] args)throws Exception {
		new Prob10().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob10.in.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String[] a = f.nextLine().trim().split(",");
            String[] b = f.nextLine().trim().split(",");
            String[] c = f.nextLine().trim().split(",");
            int row = Integer.parseInt(a[0]), col = Integer.parseInt(a[1]);
            int curR = Integer.parseInt(b[0]), curC = Integer.parseInt(b[1]);
            int moveR = Integer.parseInt(c[0]), moveC = Integer.parseInt(c[1]);
            if(moveR < 1 || moveC < 1 || moveR > row || moveC > col) System.out.println("No");
            else if((moveR + moveC) % 2 == (curR + curC)% 2) System.out.println("Yes");
            else System.out.println("No");
        }
        f.close();
	}
}
