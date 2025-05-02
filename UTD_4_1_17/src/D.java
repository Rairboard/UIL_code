import java.util.*;
import java.io.*;
public class D {
	public static void main(String[] args)throws Exception {
		new D().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("D.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            long n = f.nextLong();
            Set<String> ts = new TreeSet<>();
            for(long num = 10;num<=n;num++){
                String ln = num+"";
                for (int i = 0; i < ln.length(); i++) {
                    String part = ln.substring(0,i) + ln.substring(i+1);
                    if(Long.parseLong(part) + num == n){
                        ts.add(num + " + " + part + " = " + n);
                    }
                }
            }
            System.out.println("Problem " + asdf + ": " + ts.size());
            for(String ans : ts){
                System.out.println(ans);
            }
        }
        f.close();
	}
}
