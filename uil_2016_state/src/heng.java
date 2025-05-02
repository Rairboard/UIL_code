import java.util.*;
import java.io.*;
public class heng {
	public static void main(String[] args)throws Exception {
//        System.out.println(Long.toBinaryString(Long.parseLong("AC",16)));
		new heng().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("heng.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            long a = Long.parseLong(f.next(), 16), b = Long.parseLong(f.next(), 16);
            String bin = Long.toString(b, 2);
            int sf = bin.length() - bin.indexOf("1") - 1;
            if(f.hasNext())f.nextLine();
//            System.out.println(Long.toString(a,2) + " " + Long.toString(b,2));
            while(Long.toString(a,2).length() >= Long.toString(b,2).length()){
                int shift = Long.toString(a, 2).length() - Long.toString(b, 2).length();
                long xor = a ^ b << shift;
//                System.out.println(Long.toBinaryString(xor));
                a = xor;
            }
            String ans = Long.toString(a,2);

            while(ans.length() < sf){
                ans = "0" + ans;
            }
            System.out.println(ans);
        }
        f.close();
	}
}
