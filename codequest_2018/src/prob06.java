import java.util.*;
import java.io.*;
public class prob06 {
	public static void main(String[] args)throws Exception {
		new prob06().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("prob06.in.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        String[] status = "off,red,green,blue".split(",");
        for(int asdf = 1;asdf <= times;asdf++){
            String[] ln = f.nextLine().trim().split("\\s+");
            String a = "", b = "";
            for (int i = 0; i < 2; i++) {
                if (ln[i].equals("WORKING")) {
                    a+="0";
                }
                else{
                    a+="1";
                }
            }
            for(int i = 2;i<ln.length;i++){
                if (ln[i].equals("WORKING")) {
                    b+="0";
                }
                else{
                    b+="1";
                }
            }
            int c = Integer.parseInt(a,2), d = Integer.parseInt(b,2);
            System.out.println(status[c] + " " + status[d]);
        }
        f.close();
	}
}
