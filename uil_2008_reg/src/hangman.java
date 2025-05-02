import java.util.*;
import java.io.*;
public class hangman {
	public static void main(String[] args)throws Exception {
		new hangman().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("hangman.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        out : for(int asdf = 1;asdf <= times;asdf++){
            String ln = f.nextLine().trim().toLowerCase().replace(" " ,"");
            String guess =f.nextLine().trim().toLowerCase();
            int incorrect = 0;
            for (int i = 0; i < guess.length(); i++) {
                if(!ln.contains(guess.substring(i,i+1))){
                    incorrect++;
                    if(incorrect==7 && !ln.isEmpty()) {
                        System.out.println("LOST " + 0);
                        continue  out;
                    }
                }
                ln = ln.replace(guess.substring(i,i+1), "");
            }
            if(!ln.isEmpty()){
                System.out.println("QUIT " + (7-incorrect));
            }
            else System.out.println("WON " + (7-incorrect));
        }
        f.close();
	}
}
