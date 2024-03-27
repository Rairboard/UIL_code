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

public class Ocho {
    List<String> al = new ArrayList<>(Arrays.asList("CERO UNO DOS TRES CUATRO CINCO SEIS SIETE OCHO NUEVE DIEZ".split(" ")));
    public static void main(String[] args) throws Exception {
        new Ocho().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Ocho").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int a = al.indexOf(f.next()), b = al.indexOf(f.next());
            if(a== 8 || b == 8){
                if(a==b){
                    out.println(a + " = " + b);
                }
                if(a == 8 && b != 8){
                    out.println(a + " > " + b);
                }else{
                    out.println(a +" < " + b);
                }
            }else{
                if(a==b){
                    out.println(a + " = " + b);
                }
                else if(a < b ){
                    out.println(a + " < " + b);
                }else{
                    out.println(a + " > " + b);
                }
            }
        }
        f.close();
    }
}
