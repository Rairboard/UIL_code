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

public class calc {
    public static void main(String[] args) throws Exception {
        new calc().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("calc").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int x = f.nextInt(), y = f.nextInt();
            if(x>=10 && x<=30){
                if(y>=15 && y<= 30){
                    out.println(0);
                }
                else if(y>=40 && y<=55){
                    out.println(3);
                }
                else if(y>= 65 && y<= 80){
                    out.println(6);
                }
                else if(y>= 90 && y<= 105){
                    out.println(9);
                }
                else{
                    out.println("Panel");
                }
            }
            else if(x>= 35 && x<=55){
                if(y>=15 && y<= 30){
                    out.println(".");
                }
                else if(y>=40 && y<=55){
                    out.println(2);
                }
                else if(y>= 65 && y<= 80){
                    out.println(5);
                }
                else if(y>= 90 && y<= 105){
                    out.println(8);
                }
                else{
                    out.println("Panel");
                }
            }
            else if(x>= 60 && x<= 80){
                if(y>=15 && y<= 30){
                    out.println("=");
                }
                else if(y>=40 && y<=55){
                    out.println(1);
                }
                else if(y>= 65 && y<= 80){
                    out.println(4);
                }
                else if(y>= 90 && y<= 105){
                    out.println(7);
                }
                else{
                    out.println("Panel");
                }
            }
            else if(x>=85 && x<= 105){
                if(y>=15 && y<= 30){
                    out.println("/");
                }
                else if(y>=40 && y<=55){
                    out.println("*");
                }
                else if(y>= 65 && y<= 80){
                    out.println("-");
                }
                else if(y>= 90 && y<= 105){
                    out.println("+");
                }
                else{
                    out.println("Panel");
                }
            }
            else{
                out.println("Panel");
            }
        }
        f.close();
    }
}
