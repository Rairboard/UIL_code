import java.util.*;
import java.io.*;
class waitlist {
    public static void main(String[] args) throws Exception {
        new waitlist().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File("waitlist.dat"));
        //Scanner f = new Scanner(System.in);
        int N = f.nextInt();
        while(N-->0){
            System.out.print(f.next() + " ");
            int m = f.nextInt(), r = f.nextInt();
            System.out.println(r-m>0? r-m:0);
        }
        f.close();
    }
}
