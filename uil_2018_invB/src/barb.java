import java.util.*;
import java.io.*;

public class barb {
    public static void main(String[] args) throws Exception {
        new barb().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("barb.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			String s =f.next();
			String s2 = new StringBuilder(s).reverse().toString().toUpperCase();
			String s3;
			if(s.length()%2==1){
				s3 = new StringBuilder(s.substring(0,s.length()/2+1)).reverse().toString();

			} else{
				s3 = new StringBuilder(s.substring(0,s.length()/2)).reverse().toString();
			}
			String s4 = s.substring(s.length()/2).toUpperCase();
			System.out.println(s + " " + s2 + " " + s3 + " " + s4);
		}
        f.close();
    }
}
