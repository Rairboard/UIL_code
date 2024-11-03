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

public class boss_ThanhLe {
    public static void main(String[] args) throws Exception {
        new boss_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bosses").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int[] ln = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int jared = 0, bowen = 0;
            for (int i = 0; i < ln.length; i++) {
                if(ln[i]%2==0){
                    bowen+=ln[i];
                }
                else{
                    jared+=ln[i];
                }
            }
            out.println(jared>bowen?"Jared Owns Bowen":"Bowen Owns Jared");
        }
        f.close();
    }
}
