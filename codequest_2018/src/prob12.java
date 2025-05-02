import java.util.*;
import java.io.*;
public class prob12 {
	public static void main(String[] args)throws Exception {
		new prob12().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("prob12.in.txt"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int N = f.nextInt();
            String ans = "{";
            boolean[] prime = new boolean[N+1];
            Arrays.fill(prime, true);
            for(int i = 2;i<=N;i++){
                int cnt = 0;
                if(prime[i]){
                    ans+=i +",";
                    for(int p = i * 2;p <= N;p+=i){
                        if(prime[p]) cnt++;
                        prime[p] = false;
                    }
                }
                if(cnt > 0){
                    System.out.println("Prime " + i + " Composite Set Size: " + cnt);
                }
            }
            System.out.println(ans.substring(0,ans.length()-1) + "}");
        }
        f.close();
	}
}
