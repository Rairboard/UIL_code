import java.util.*;
import java.io.*;
public class Prob11 {
	public static void main(String[] args)throws Exception {
		new Prob11().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob11.in.txt"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int cr = f.nextInt(), cg = f.nextInt(), cb = f.nextInt();
            int t = f.nextInt();
            int fr = f.nextInt(), fg = f.nextInt(), fb = f.nextInt();
            int br = f.nextInt(), bg = f.nextInt(), bb = f.nextInt();
            if(Math.sqrt(Math.pow(cr-fr,2) + Math.pow(cg-fg,2) + Math.pow(cb-fb,2)) <= t){
                System.out.println(br + " " + bg + " " + bb);
            }
            else {
                System.out.println(fr + " "+  fg+" "+fb);

            }
        }
        f.close();
	}
}
