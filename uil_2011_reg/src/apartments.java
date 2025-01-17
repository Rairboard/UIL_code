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

public class apartments {
    public static void main(String[] args) throws Exception {
        new apartments().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("apartments").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int m = f.nextInt();
            int unoccupied = 0;
            double total = 0;
            for (int i = 0; i < m; i++) {
                int number = f.nextInt(), people = f.nextInt();
                if(people==0){
                    unoccupied++;
                }
                else{
                    total+=people;
                }
            }
            if(m-unoccupied==0){
                out.println("YES " + unoccupied);
            }
            else if(total/(m-unoccupied)<= 4){
                out.println("YES " + unoccupied);
            }
            else{
                out.println("NO " + unoccupied);
            }
        }
        f.close();
    }
}
