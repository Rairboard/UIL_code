import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class antonia {
    public static void main(String[] args) throws Exception {
        new antonia().run();
    }

    public void run() throws Exception {
        //Scanner f = new Scanner(new File("antonia.dat"));
        //Scanner f = new Scanner(System.in);
        String s = "BRAVO UIL COMPSCI";
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < (int)(s.charAt(i)-64); j++) {
				System.out.print(s.substring(i,i+1));
			}
			System.out.println();
		}
        //f.close();
    }
}
