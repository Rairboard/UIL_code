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

public class destination {
    public static void main(String[] args) throws Exception {
        new destination().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("destination").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int x1 = f.nextInt(), y1 = f.nextInt(), x2 = f.nextInt(), y2 = f.nextInt();
            int n = f.nextInt();
            f.nextLine();
            if(x1 == x2 && y1 == y2){
                for (int i = 0; i < n; i++) {
                    f.nextLine();
                }
                out.println(0);
            }
            else{
                int move = -1;
                for (int i = 0; i < n; i++) {
                    String[] ln = f.nextLine().trim().split("\\s+");
                    int d = Math.abs(Integer.parseInt(ln[1]));
                    if (ln[0].equals("north")) {
                        int ny = y1 + d;
                        if(x1 == x2 && Math.min(y1,ny) <= y2 && y2 <= Math.max(y1,ny)){
                            if(move==-1) move = i+1;
                        }
                        y1+=d;
                    }
                    else if (ln[0].equals("south")) {
                        int ny = y1 - d;
                        if(x1 == x2 && Math.min(y1,ny) <= y2 && y2 <= Math.max(y1,ny)){
                            if(move==-1) move = i+1;
                        }
                        y1-=d;
                    }
                    else if (ln[0].equals("west")) {
                        int nx = x1 - d;
                        if(y1 == y2 && Math.min(x1,nx) <= x2 && x2 <= Math.max(x1,nx)){
                            if(move==-1)move = i+1;
                        }
                        x1-=d;
                    }
                    else if (ln[0].equals("east")) {
                        int nx = x1 + d;
                        if(y1 == y2 && Math.min(x1,nx) <= x2 && x2 <= Math.max(x1,nx)){
                            if(move==-1)move = i+1;
                        }
                        x1+=d;
                    }
                }
                if(move!=-1){
                    out.println(move);
                }
                else{
                    out.println("You didn't make it");
                }
            }
        }
        f.close();
    }
}
