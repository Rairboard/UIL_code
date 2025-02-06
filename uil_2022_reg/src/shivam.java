import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class shivam {
    public static void main(String[] args) throws Exception {
        new shivam().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("shivam").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            out.print("Function " +asdf + ": ");
            String[] ln = f.nextLine().trim().split("=");
            if(ln[1].matches("-?[0-9]*x\\^2[+-][0-9]*+x[+-][0-9]+")){
                String[] func = ln[1].replace("^2","").split("x");
                double a = func[0].equals("-")? -1 : func[0].isEmpty()? 1 :  Double.parseDouble(func[0]);
                double b = func[1].equals("-") ? -1 : func[1].equals("+") ? 1 : Double.parseDouble(func[1]);
                double c = Double.parseDouble(func[2]);
                double dis = b * b - 4 * a * c;
                if(dis < 0){
                    out.println("There are no real roots to the function.");
                }
                else if(dis == 0){
                    double x = -b / (2.0 * a);
                    double y = a * x * x + b * x + c;
                    out.printf("There is one real root at (%.2f,%.2f).\n", x, y);
                }
                else{
                    dis = Math.sqrt(dis);
                    double x1 = (-b + dis) / (2.0 * a);
                    double x2 = (-b - dis) / (2.0 * a);
                    if(x1 < x2){
                        out.printf("There are two real roots at (%.2f,%.2f) and (%.2f,%.2f).\n",x1, 0., x2, 0. );
                    }
                    else{
                        out.printf("There are two real roots at (%.2f,%.2f) and (%.2f,%.2f).\n", x2, 0., x1 , 0.);
                    }
                }
            }
            else if(ln[1].matches("-?[0-9]*x\\^2[+-][0-9]*x")){
                String[] func = ln[1].replace("x","").split("\\^2");
                double a = func[0].equals("-")? -1 : func[0].isEmpty()? 1 :  Double.parseDouble(func[0]);
                double b = func[1].equals("-") ? -1 : func[1].equals("+") ? 1 : Double.parseDouble(func[1]);
                double x1 = 0;
                double x2 = -b / a;
                if(x1 < x2){
                    out.printf("There are two real roots at (%.2f,%.2f) and (%.2f,%.2f).\n", x1, 0., x2, 0.);
                }
                else{
                    out.printf("There are two real roots at (%.2f,%.2f) and (%.2f,%.2f).\n", x2, 0., x1, 0.);
                }
            }
            else if(ln[1].matches("-?[0-9]*x\\^2[+-][0-9]+")){
                String[] func = ln[1].replace("^2","").split("x");
                double a = func[0].equals("-")? -1 : func[0].isEmpty()? 1 :  Double.parseDouble(func[0]);
                double c = Double.parseDouble(func[1]);
                if(-c/a < 0){
                    out.println("There are no real roots to the function.");
                }
                else{
                    double ans = -c/a;
                    double x1 = Math.sqrt(ans);
                    double x2 = -Math.sqrt(ans);
                    if(x1 < x2){
                        out.printf("There are two real roots at (%.2f,%.2f) and (%.2f,%.2f).\n", x1, 0., x2, 0.);
                    }
                    else{
                        out.printf("There are two real roots at (%.2f,%.2f) and (%.2f,%.2f).\n", x2, 0., x1, 0.);
                    }
                }
            }
            else if(ln[1].matches("-?[0-9]*x\\^2")){
                out.printf("There is one real root at (%.2f,%.2f).\n", 0., 0.);
            }
        }
        f.close();
    }
}
