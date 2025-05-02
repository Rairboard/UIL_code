import java.util.*;
import java.io.*;
public class nibble {
	public static void main(String[] args)throws Exception {
		new nibble().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("nibble.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String ln = f.nextLine();
            if(!ln.replaceAll("[01]", "").isEmpty()) {
                System.out.println("Wrong Base...");
                continue;
            }
            if(ln.length()%4!=0) ln+="0".repeat(4 - ln.length()%4);
            for (int i = 0; i < ln.length(); i+=4) {
                System.out.print(ln.substring(i,i+4)+" ");
            }
            System.out.println();
        }
        f.close();
	}
}
