import java.util.*;
import java.io.*;

public class lucas {
    public static void main(String[] args) throws Exception {
        new lucas().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("lucas.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        for (int i = 0; i < times; i++) {
			String s = f.next();
			int sum = 0;
			while(!s.isEmpty()){
			    sum += (s.charAt(0) - 96) * (int)Math.pow((s.length()-s.replaceAll(s.substring(0,1),"").length()),2);
			    s = s.replaceAll(s.substring(0,1),"");
			}
			System.out.println(sum);
        }
        f.close();
    }
}
