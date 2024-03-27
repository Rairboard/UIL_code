import java.util.*;
import java.io.*;

public class catherine {
    public static void main(String[] args) throws Exception {
        new catherine().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("catherine.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
			String t = f.next(), g = f.next();
			char[] s = new char[5];
			for (int i = 0; i < g.length(); i++) {
				if(t.indexOf(t.charAt(i)) != g.indexOf(t.charAt(i))){
					if(t.indexOf(g.charAt(i)) == -1){
						s[i] = '*';
					}
					else{
						s[g.indexOf(g.charAt(i))] = g.charAt(i);
					}
				}
				else{
					s[i] = Character.toUpperCase(t.charAt(i));
				}
			}
			System.out.println(new String(s));
        }
        f.close();
    }
}
