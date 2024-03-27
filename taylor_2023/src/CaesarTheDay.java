import java.util.*;
import java.io.*;

public class CaesarTheDay {
    public static void main(String[] args) throws Exception {
        new CaesarTheDay().run();
    }

    public void run() throws Exception {
		String upper = "";
		String lower = "";
		char A = 'A';
		char a  = 'a';
		for (int i = 0; i < 26; i++) {
			upper += A++;
			lower += a++;
		}
        Scanner f = new Scanner(new File("CaesarTheDay.in"));
        //Scanner f = new Scanner(System.in);
		int shift = f.nextInt();
		f.nextLine();
		String[] s = f.nextLine().split("\\s+");
		String res = "";
		for (int i = 0; i < s.length; i++) {
			String part = s[i];
			for (int j = 0; j < part.length(); j++) {
				if(Character.isUpperCase(part.charAt(j))){
					res += upper.charAt( (upper.indexOf(part.charAt(j)) + shift) %upper.length());
				}
				else{
					res += lower.charAt((lower.indexOf(part.charAt(j)) + shift) % lower.length());
				}
			}
			res += " ";
		}
		System.out.println(res.trim());
        f.close();
    }
}
