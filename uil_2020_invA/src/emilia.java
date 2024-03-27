import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

public class emilia {
    static SimpleDateFormat ff = new SimpleDateFormat("MM:HH");
    public static void main(String[] args) throws Exception {
        new emilia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("emilia.dat"));
        //Scanner f = new Scanner(System.in);
        int[] degree = {0,30,60,90,120,150,180,210,240,270,300,330};
        int[] hour = {3,2,1,12,11,10,9,8,7,6,5,4};
        int[] min = {15,10,5,0,55,50,45,40,35,30,25,20};
        int times = f.nextInt();
        while (times-- > 0) {
            double hd = f.nextDouble(), md = f.nextDouble();
            int h = 0, m = 0;
            for(int i=degree.length-1;i>=0;i--){
                if(hd >= degree[i]){
                    if(hd==degree[i]){
                        h = hour[i];
                    } else{
                        h = hour[i]-1;
                    }
                    break;
                }
            }
            for(int i=degree.length-1;i>=0;i--){
                if(md>=degree[i]){
                    if(md==degree[i]){
                        m = min[i];
                    } else{
                        md-=degree[i];
                        md/=6;
                        m = min[i] - (int)md;
                    }
                    break;
                }
            }
           if(h<=0){
               if(h<0){
                   h = 12+h;
               } else{
                   h = 12;
               }
           }
           if(m<=0){
               if(m<60){
                   m = 60+m;
               } else{
                   m = 60;
               }
           }
           System.out.printf("%02d:%02d%n",h,m);
        }
        f.close();
    }
}
