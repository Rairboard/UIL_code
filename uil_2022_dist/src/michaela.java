import java.util.*;
import java.io.*;

public class michaela {
    public static void main(String[] args) throws Exception {
        new michaela().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("michaela.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
		f.nextLine();
		String[] dictionary = {"-.....-","-....-.","-....--","-...-..","-...-.-","-...--.","-...---","-..-...","-..-..-","-..-.-.","-..-.--","-..--..","-..--.-","-..---.","-..----","-.-....","-.-...-","-.-..-.","-.-..--","-.-.-..","-.-.-.-","-.-.--.","-.-.---","-.--...","-.--..-","-.--.-.","-....."};
        for(int t=1;t<=times;t++) {
			System.out.print("Message #" + t + ": ");
			String a =f.nextLine();
			String s= "";
			for (int i = 0; i < a.length(); i++) {
				if(a.charAt(i) == ' '){
					s+=dictionary[dictionary.length-1]+" ";
				}else{
					s+=dictionary[Character.toUpperCase(a.charAt(i)) - 65] + " ";
				}
			}
			System.out.println(s.trim());
        }
        f.close();
    }
}
