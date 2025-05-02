import java.util.*;
import java.io.*;
public class dorian {
	public static void main(String[] args)throws Exception {
		new dorian().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("dorian.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String ln = f.nextLine();
            int count = 0;
            while(!ln.isEmpty()){
                if(count > 1){
                    System.out.print("\t");
                }
                else{
                    count++;
                }
                System.out.println(ln.substring(0, Math.min(ln.length(), 89)));
                ln = ln.substring(Math.min(89, ln.length()));
            }
        }
        f.close();
	}
}
