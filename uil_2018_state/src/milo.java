import java.util.*;
import java.io.*;

public class milo {
    public static void main(String[] args) throws Exception {
        new milo().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("milo.dat"));
        //Scanner f = new Scanner(System.in);
       HashMap<Character,Integer> set = new HashMap<>();
        set.put('I',1);
        set.put('V',5);
        set.put('X',10);
        set.put('L',50);
        set.put('C',100);
        set.put('D',500);
        set.put('M',1000);
        while(f.hasNext()){
            char[] x = f.nextLine().toCharArray();
            int sum = set.get(x[0]);
            for (int i = 1; i < x.length; i++) {
                if(set.get(x[i-1]) < set.get(x[i]))
                    sum-=set.get(x[i-1])*2;
                sum+=set.get(x[i]);

            }
            System.out.println(sum);
        }

        f.close();
    }
}
