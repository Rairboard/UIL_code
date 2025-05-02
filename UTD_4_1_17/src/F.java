import java.util.*;
import java.io.*;
public class F {
    double timeBetweenStop = 2 * Math.PI * 30 / 27.0 / 15.0;
	public static void main(String[] args)throws Exception {
		new F().run();
	}
	public void run() throws Exception{
        String a = " ";
        for(char c = 'A';c<='Z';c++){
            a+=c;
        }
        Scanner f = new Scanner(new File("F.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String ln = f.nextLine();
            double ans = 2;
            for(int i = 1;i < ln.length();i++){
                int segmentLength = Math.abs(a.indexOf(ln.charAt(i)) - a.indexOf(ln.charAt(i-1)));
                double first = segmentLength * timeBetweenStop + 2;
                double second = (27 - segmentLength) * timeBetweenStop + 2;
                /*
                apparently the sol only account for the segment length between stop to be different in index and doesn't account for going around
                so instead of being like below
                double second = (27 - segmentLength) * timeBetweenStop + 2;
                ans += Math.min(first, second);

                actual solution
                 */
                ans+=first;
            }
            System.out.printf("Aphorism %d: %.2f\n", asdf, ans);
        }
        f.close();
	}
}
