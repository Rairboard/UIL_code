import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class risk {
    public static void main(String[] args) throws Exception {
        new risk().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("risk").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long seed =f.nextLong();
            long a = f.nextLong(), d = f.nextLong();
            Random r = new Random(seed);
            while(a>0 && d >0){
                List<Integer> attacker = new ArrayList<>(), defender = new ArrayList<>();
                for (int i = 0; i < Math.min(3, a); i++) {
                    attacker.add(r.nextInt(6)+1);
                }
                for (int i = 0; i < Math.min(2, d); i++) {
                    defender.add(r.nextInt(6)+1);
                }
                Collections.sort(attacker, (A,B) -> B-A);
                Collections.sort(defender, (A,B) -> B-A);
                while(!attacker.isEmpty() && !defender.isEmpty()){
                    int ba = attacker.remove(0);
                    int bd = defender.remove(0);
                    if(ba>bd){
                        d--;
                    }
                    else {
                        a--;
                    }
                }
            }
            out.println(a + " " + d);
        }
        f.close();
    }
}
