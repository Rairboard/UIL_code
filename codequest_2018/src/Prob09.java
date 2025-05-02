import java.util.*;
import java.io.*;
public class Prob09 {
	public static void main(String[] args)throws Exception {
		new Prob09().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob09.in.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String[] ln = f.nextLine().trim().split(",");
            int a = Integer.parseInt(ln[0]), b = Integer.parseInt(ln[1]);
            int min = Math.max(a,b);
            int sub = Math.min(a,b);
            while(min-sub != 0){
                System.out.println(min +"-"+sub+"=" + (min-sub));
                int temp1 = sub;
                int temp2 = min-sub;
                min = Math.max(temp1,temp2);
                sub = Math.min(temp1, temp2);
            }
            System.out.println(min+"-"+sub+"=0");
            if(min == 1 && sub == 1){
                System.out.println("COPRIME");
            }
            else{
                System.out.println("NOT COPRIME");
            }
        }
        f.close();
	}
}
