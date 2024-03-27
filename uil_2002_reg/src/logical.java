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

public class logical {
    public static void main(String[] args) throws Exception {
        new logical().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("logic").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String ln = f.nextLine();
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < ln.length(); i++) {
                try{
                    int N = Integer.parseInt(ln.substring(i,i+1));
                    s.push(N);
                }
                catch(Exception e){
                    char c = ln.charAt(i);
                    int a = s.pop(), b = s.pop();
                    switch(c){
                        case '*':
                            if(a == 1 && b == 1){
                                s.push(1);
                            }
                            else{
                                s.push(0);
                            }
                            break;
                        case '+':
                            if(a == 0 && b == 0){
                                s.push(0);
                            }
                            else{
                                s.push(1);
                            }
                            break;
                        case '!':
                            if(a == 1 && b == 1){
                                s.push(0);
                            }
                            else{
                                s.push(1);
                            }
                            break;
                        case '-':
                            if(a == 0 & b == 0){
                                s.push(1);
                            }
                            else{
                                s.push(0);
                            }
                            break;
                        case 'x':
                            if(a == b ){
                                s.push(0);
                            }
                            else{
                                s.push(1);
                            }
                            break;
                    }
                }
            }
        }
        f.close();
    }
}
