import java.util.*;
import java.io.*;

public class facundo {
    public static void main(String[] args) throws Exception {
        new facundo().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("facundo.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
			String s = f.next();
			int r = f.nextInt();
			String upper , lower;
			while(r-->0){
				int half = s.length() % 2== 0 ? s.length()/2: s.length()/2+1;
				String ss = "";
				upper = s.substring(0,half);
				lower = s.substring(half);
				int u = upper.length()-1, l = lower.length()-1;
				while( u >=0 || l >=0){
					if(u >=0){
						ss += upper.charAt(u);
						u--;
					}
					if(l>=0){
						ss+= lower.charAt(l);
						l--;
					}
				}
				s = new StringBuilder(ss).reverse().toString();
			}
			System.out.println(s);
        }
        f.close();
    }
}
