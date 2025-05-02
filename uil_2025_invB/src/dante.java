import java.util.*;
import java.io.File;
import java.util.Arrays;

import static java.lang.System.*;

public class dante {
    public static void main(String[] args) throws Exception {
        new dante().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dante").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        boolean[] prime = new boolean[100001];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2;i*i<=100000;i++){
            if(prime[i]){
                for(int p = i*i;p<=100000;p+=i){
                    prime[p] = false;
                }
            }
        }
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 0; asdf < times; asdf++) {
            int a = f.nextInt(), b = f.nextInt();
            int cnt = 0;
            for(int i = a+1;i<b;i++){
                if(prime[i]) cnt++;
            }
            out.println(cnt);
        }
        f.close();
    }
}
