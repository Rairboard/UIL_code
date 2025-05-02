import java.util.*;
import java.io.*;
public class compression {
	public static void main(String[] args)throws Exception {
		new compression().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("compression.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String ln = f.nextLine();
            for(int i = 0;i < ln.length();i++){
                int j = i+1;
                while(j<ln.length()&&ln.charAt(j) == ln.charAt(i)){
                    j++;
                }
                System.out.print(j-i + ""+ln.charAt(i));
                i = j-1;
            }
            System.out.println();
        }
        f.close();
	}
}
