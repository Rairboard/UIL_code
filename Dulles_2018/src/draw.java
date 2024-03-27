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

public class draw {
    public static void main(String[] args) throws Exception {
        new draw().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("draw.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String shape = f.next();
            if(shape.equals("rectangle")){
                int r = f.nextInt(), c = f.nextInt();
                char yn = f.next().charAt(0);
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if(i==0 || i==r-1){
                            out.print("#");
                        }
                        else if(j!=0&&j!=c-1){
                            out.print(yn=='n'?" ":"#");
                        }else{
                            out.print("#");
                        }
                    }
                    out.println();
                }
            }else{
                String a = f.next();
                if(a.equals("triangle")){
                    int n = f.nextInt();
                    char yn = f.next().charAt(0);
                    if(shape.equals("left")){
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j <= i; j++) {
                                if(i>1 && i < n-1){
                                    if(j>0 && j < i){
                                        out.print(yn=='n'?" ":"#");
                                    }else{
                                        out.print("#");
                                    }
                                }else{
                                    out.print("#");
                                }
                            }
                            out.println();
                        }
                    }else{
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n-i-1; j++) {
                                out.print(" ");
                            }
                            for (int j = 0; j <= i; j++) {
                                if(i>1 && i < n-1){
                                    if(j>0 && j < i){
                                        out.print(yn=='y'?"#":" ");
                                    }else{
                                        out.print("#");
                                    }
                                }else{
                                    out.print("#");
                                }
                            }
                            out.println();
                        }
                    }
                }else{
                    int n = Integer.parseInt(a);
                    char yn = f.next().charAt(0);
                    for (int i = 0; i < n/2+1; i++) {
                        for(int j=0;j<n/2-i;j++){
                            out.print(" ");
                        }
                        for(int j=0;j<i*2+1;j++){
                            if(j!=0&&j!=i*2){
                                out.print(yn=='n'?" " : "#");
                            }else{
                                out.print("#");
                            }
                        }
                        out.println();
                    }
                    for(int i=n-2;i>0;i-=2){
                        for (int j = 0; j < (n-i)/2; j++) {
                            out.print(" ");
                        }
                        for (int j = 0; j < i; j++) {
                            if(i==1){
                                out.print("#");
                            }else if(j == 0 || j == i-1){
                                out.print("#");
                            }else{
                                out.print(yn == 'y'?"#":" ");
                            }
                        }
                        out.println();
                    }
                }
            }
        }
        f.close();
    }
}