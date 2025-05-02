import java.util.*;
import java.io.*;
public class kai {
	public static void main(String[] args)throws Exception {
		new kai().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("kai.dat"));
        //Scanner f = new Scanner(System.in);
        String[] ln = " _  ,(*> ,//\\ ,V_/_".split(",");
        int times = f.nextInt();
        for (int i = 0; i < ln.length; i++) {
            System.out.println(ln[i].repeat(times));
        }
        f.close();
	}
}
