import java.util.*;
import java.io.*;
import java.math.*;

public class hong {
    String orig = "MDCLXVI";
    public static void main(String[] args) throws Exception {
        new hong().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("hong.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            Scanner line = new Scanner(f.nextLine());
            while(line.hasNext()){
                int N = line.nextInt();
                System.out.print(N + " -> ");
                String s = "";
                int[] val = {1000,500,100,50,10,5,1};
                String[] roman = orig.split("");
                for (int i = 0; i < val.length; i++) {
                    if(N>=val[i]){
                        s+=roman[i].repeat(N/val[i]);
                        N%=val[i];
                    }
                }
                System.out.println(s.replaceAll("DCCCC","CM").replaceAll("CCCC","CD").replaceAll("LXXXX","XC").replaceAll("XXXX","XL").replaceAll("VIIII","IX").replaceAll("IIII","IV"));
            }
        }
        f.close();
    }
}
