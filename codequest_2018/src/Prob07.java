import java.util.*;
import java.io.*;
public class Prob07 {
	public static void main(String[] args)throws Exception {
		new Prob07().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob07.in.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int n = f.nextInt();
            f.nextLine();
            List<Integer> bad = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String ln = f.nextLine().toLowerCase();
                if (!ln.equals(new StringBuilder(ln).reverse().toString())) {
                    bad.add(i+1);
                }
            }
            if(bad.size()>0){
                System.out.print("False - ");
                for (int i = 0; i < bad.size(); i++) {
                    if(i < bad.size()-1){
                        System.out.print(bad.get(i) + ", ");
                    }
                    else System.out.println(bad.get(i));
                }
            }
            else System.out.println("True");
        }
        f.close();
	}
}
