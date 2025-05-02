import java.util.*;
import java.io.*;
public class kassie {
	public static void main(String[] args)throws Exception {
		new kassie().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("kassie.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String[] ln = f.nextLine().trim().split("\\s+");
            long a = Long.parseLong(ln[0]);
            long b = Long.parseLong(ln[2]);
            try{
                switch (ln[1]){
                    case "+":
                        System.out.println(a + b);break;
                    case "-":
                        System.out.println( a-b);
                        break;
                    case "/":
                        System.out.println(a/b);break;
                    case "*":
                        System.out.println(a * b);break;
                }
            }catch(Exception e){}
        }
        f.close();
	}
}
