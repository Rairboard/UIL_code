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

public class Christmaths {
    public static void main(String[] args) throws Exception {
        new Christmaths().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Christmaths").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String ln = f.next();
            int ans = f.nextInt();
            int val = Integer.parseInt(ln.substring(0,1));
            for (int i = 1; i < ln.length(); i+=2) {
                int N = Integer.parseInt(ln.substring(i+1,i+2));
                switch(ln.charAt(i)){
                    case '+': val+=N;break;
                    case '-': val-=N;break;
                    case '*': val *= N;break;
                    default : val/=N;break;
                }
            }
            out.println(ans == val ? "Present for You":"Coal for You");
        }
        f.close();
    }
    public int prec(String ch){
        switch(ch){
            case "/","*": return 1;
        }
        return 0;
    }
}
