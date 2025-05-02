import java.util.*;
import java.io.*;
public class Prob05 {
	public static void main(String[] args)throws Exception {
		new Prob05().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob05.in.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int n = f.nextInt();
            System.out.print(n + ":");
            int cnt = 1;
            while(n > 1){
                if (n % 2 == 0) {
                    n/=2;
                }
                else{
                    n = n * 3 +1;
                }
                cnt++;
            }
            System.out.println(cnt);
        }
        f.close();
	}
}
