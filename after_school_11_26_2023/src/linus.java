import java.util.*;
import java.io.File;

public class linus {
    public static void main(String[] args) throws Exception {
        new linus().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("linus.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            long n = f.nextLong(), d = f.nextLong();
            if(n%d==0){
                System.out.println(n/d);
            }
            else if(n>d){
                long whole = n/d;
                n%=d;
                long GCF = gcf(n,d);
                System.out.println(whole + " " + (n/GCF) + "/" + (d/GCF));
            }else{
                long GCF = gcf(n,d);
                System.out.println((n/GCF) + "/" + (d/GCF));
            }
        }
        f.close();
    }
    public long gcf(long a, long b){
        return b==0?a:gcf(b,a%b);
    }
}
