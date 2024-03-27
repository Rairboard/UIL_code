import java.util.*;
import java.io.*;

public class hojin {
    public static void main(String[] args) throws Exception {
        new hojin().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("hojin.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1; asdf <= times;asdf++) {
			System.out.println("Case #" + asdf + ": " + pizza(f.nextLong(),f.nextLong()));
        }
        f.close();
    }
	public long pizza(long cat, long dog){
		if(cat < dog){
			return pizza (dog,cat);
		}
		if(dog==0){
			return cat;
		}
		return pizza(cat%dog,dog);
	}
}
