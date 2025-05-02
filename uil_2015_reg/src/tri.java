import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class tri {
	public static void main(String[] args)throws Exception {
		new tri().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("tri.dat"));
        //Scanner f = new Scanner(System.in);
        while (f.hasNext()) {
            List<BigInteger> al = new ArrayList<>();
            al.add(f.nextBigInteger());
            al.add(f.nextBigInteger());
            al.add(f.nextBigInteger());
            Collections.sort(al);
            System.out.print(al.get(0)+ " " + al.get(1) + " " + al.get(2) + " ");
            if(al.get(0).add(al.get(1)).compareTo(al.get(2)) > 0){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
        f.close();
	}
}
