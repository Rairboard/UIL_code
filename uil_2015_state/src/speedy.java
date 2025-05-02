import java.util.*;
import java.io.*;
public class speedy {
	public static void main(String[] args)throws Exception {
		new speedy().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("speedy.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int n = f.nextInt();
            long t = f.nextLong();
            List<long[]> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                al.add(new long[]{f.nextLong(),f.nextLong()});
            }
            long cnt = 0;
            for(int i = 0;i < al.size();i++){
                for (int j = 0; j < al.size(); j++) {
                    if(i==j) continue;
                    if(al.get(i)[1]* (t - al.get(i)[0]) <= al.get(j)[1] * (t - al.get(j)[0]) && al.get(j)[0] >= al.get(i)[0]){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
        f.close();
	}
}
