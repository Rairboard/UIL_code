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

public class xml {
    public static void main(String[] args) throws Exception {
        new xml().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("xml").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int t = f.nextInt();
            f.nextLine();
            boolean valid = true;
            Stack<String> st = new Stack<>();
            for (int i = 0; i < t; i++) {
                String ln= f.nextLine().trim();
                if(!valid) continue;
                if (ln.matches("</.*>")) {
                    if(!st.isEmpty()){
                        int a = ln.indexOf("/") + 1;
                        int b = ln.indexOf(">");
                        if (!st.peek().equals(ln.substring(a, b))) {
                            valid = false;
                        }
                        else{
                            st.pop();
                        }
                    }else{
                        valid = false;
                    }
                } else if (ln.matches("<.*>")) {
                    int a = ln.indexOf("<")+1;
                    int b = ln.indexOf(">");
                    st.push(ln.substring(a,b));
                }
            }
            if(valid){
                out.println("valid");
            }
            else{
                out.println("invalid");
            }
        }
        f.close();
    }
}
