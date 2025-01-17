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

public class rearrange {
    public static void main(String[] args) throws Exception {
        new rearrange().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("rearrange").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String[] ln = f.nextLine().trim().split("\\s+");
            String ans = "";
            Stack<String> st = new Stack<>();
            for (int i = 0; i < ln.length; i++) {
                try{
                    int n = Integer.parseInt(ln[i]);
                    ans+= n+" ";
                }
                catch (Exception e){
                    while(!st.isEmpty() && precedence(st.peek()) >= precedence(ln[i])){
                        ans += st.pop() +" ";
                    }
                    st.push(ln[i]);
                }
            }
            while(!st.isEmpty()){
                ans+= st.pop()+" ";
            }
            out.println(ans.trim());
        }
        f.close();
    }
    public int precedence(String c){
        if ("*/".contains(c)) {
            return 2;
        }
        return 1;
    }
}
