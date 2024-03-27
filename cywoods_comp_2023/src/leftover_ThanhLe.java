import java.util.*;
import java.io.*;
public class leftover_ThanhLe{
    public static void main (String[] args)throws Exception{
        new leftover_ThanhLe().run();
    }
    public void run()throws Exception{
//         Scanner f = new Scanner(System.in);
        Scanner f = new Scanner(new File("leftover.dat"));
        int times = f.nextInt();
        for(int asdf = 0; asdf < times;asdf++){
            int N = f.nextInt();
            double pizza = f.nextDouble();
            double sum = 0;
            for(int i=0;i<N;i++){
                f.next();
                sum+=f.nextDouble();
            }
            pizza-=sum;
            System.out.println(pizza > 0 ? "Leftover for Bowen":"Bowen's crying");
        }
    }
}