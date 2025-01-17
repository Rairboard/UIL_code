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

public class quilt {
    public static void main(String[] args) throws Exception {
        new quilt().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("quilt").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            char[][] m = new char[10][10];
            for (int i = 0; i < 10; i++) {
                m[i] = f.nextLine().trim().toCharArray();
            }
            int n = f.nextInt();
            f.nextLine();
            for(int t= 0;t<n;t++){
                Map<Character, Character> pattern =  new HashMap<>();
                boolean match = true;
                for(int i = 0;i < 10;i++){
                    char[] ar = f.nextLine().trim().toCharArray();
                    if(!match) continue;
                    for(int j = 0;j < ar.length;j++){
                        if (!pattern.containsKey(m[i][j])) {
                            pattern.put(m[i][j], ar[j]);
                        }
                        else{
                            if(pattern.get(m[i][j])!=ar[j]){
                                match =false;
                                break;
                            }
                        }
                    }
                }
                if(!match) out.println("NOT SAME");
                else out.println("SAME");
            }
        }
        f.close();
    }
}
