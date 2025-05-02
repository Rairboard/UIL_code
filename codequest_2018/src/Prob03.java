import java.util.*;
import java.io.*;
public class Prob03 {
	public static void main(String[] args)throws Exception {
		new Prob03().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("Prob03.in.txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int n = Integer.parseInt(f.nextLine().replaceAll("[^0-9]",""));
            if(n%100 > 10 && n % 100 < 20){
                System.out.println(n +"th");
            }
            else {
                if(n % 10 == 1){
                    System.out.println(n + "st");
                }
                else if(n % 10 == 2){
                    System.out.println(n + "nd");
                } else if (n % 10 == 3) {
                    System.out.println(n + "rd");
                }
                else System.out.println(n +"th");
            }
        }
        f.close();
	}
}
