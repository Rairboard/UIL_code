import java.util.*;
import java.io.*;
public class goldbach {
    List<String> combination;
	public static void main(String[] args)throws Exception {
		new goldbach().run();
	}
	public void run() throws Exception {
        Scanner f = new Scanner(new File("goldbach.dat"));
//        Scanner f = new Scanner(System.in);
        boolean[] prime = new boolean[101];
        Arrays.fill(prime, true);
        for (int i = 2; i * i <= 100; i++) {
            if (prime[i]) {
                for (int p = i * i; p <= 100; p += i) {
                    prime[p] = false;
                }
            }
        }
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            List<Integer> factor = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                if (prime[i]) factor.add(i);
            }
            String res = n + " = ";
            for (int i = 0; i < factor.size(); i++) {
                for(int j = i+1;j<factor.size();j++){
                    if(factor.get(i)+factor.get(j)==n){
                        res+= factor.get(i) + " + " + factor.get(j) + " = ";
                    }
                }
            }
            System.out.println(res.substring(0,res.lastIndexOf(" = ")));
        }
        f.close();
    }
    public void recur(int i, int target, List<Integer> factor, String path){
        if(target==0){
            combination.add(path.substring(0,path.lastIndexOf(" + ")));
            return;
        }
        if(i==factor.size()) return;
        for(int j = i;j<factor.size();j++){
            if(target-factor.get(j)>=0){
                recur(j+1, target-factor.get(j), factor, path + factor.get(j) + " + ");
            }
        }
    }
}
