import java.util.*;
import java.io.*;

public class dinner {
    public static void main(String[] args) throws Exception {
        new dinner().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("dinner.in"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            int d = f.nextInt(), r = f.nextInt(), c = f.nextInt(), day = f.nextInt();
            for (int i = 0; i < day; i++) {
                int aliveRab = 0, aliveDog = 0;
                for (int j = 0; j < r; j++) {
                   if(c>=3){
                       c-=3;
                       aliveRab+=1;
                   }
                   else{
                       c=0;
                   }
                }
                r = aliveRab;
                for (int j = 0; j < d; j++) {
                    if (r >= 2) {
                        r -= 2;
                        aliveDog += 1;
                    }
                    else{
                        r = 0;
                    }
                }
                d = aliveDog;
            }
            System.out.println(d +" " + r + " " + c);
        }
        f.close();
    }
}