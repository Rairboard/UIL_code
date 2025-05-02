import java.util.*;
import java.io.*;
public class Prob14 {
	public static void main(String[] args)throws Exception {
		new Prob14().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob14.in.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int U = f.nextInt();
            f.nextLine();
            int[] upper = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int L = f.nextInt();
            f.nextLine();
            int[] lower = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            String a = "", b = "";
            while(f.hasNext()){
                String ln = f.nextLine().trim();
                for (int i = 0; i < ln.length(); i++) {
                    if (ln.substring(i, i + 1).matches("[A-Z]")) {
                        a+=ln.charAt(i);
                    } else if (ln.substring(i, i + 1).matches("[a-z]")) {
                        b+=ln.charAt(i);
                    }
                    else if(ln.charAt(i)=='-'){
                        a+=" ";
                    }
                    else if(ln.charAt(i)=='='){
                        b+=" ";
                    }
                }
            }
            for (int i = 0; i < upper.length; i++) {
                System.out.println(a.substring(0,upper[i]));
                a = a.substring(upper[i]);
            }
            for (int i = 0; i < lower.length; i++) {
                System.out.println(b.substring(0,lower[i]));
                b = b.substring(lower[i]);
            }
        }
        f.close();
	}
}
