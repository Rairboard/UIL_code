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

public class singing {
    public static void main(String[] args) throws Exception {
        new singing().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("singing").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        f.nextLine();
        List<String> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = f.nextLine();
            if(al.contains(s)){
                out.println(s.split(" – ")[1].toUpperCase() + " AGAIN?!");
            }else{
                al.add(s);
            }
        }
    }
}
