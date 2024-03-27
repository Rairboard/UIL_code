import java.util.*;
import java.io.*;
class bryce{
	public static void main(String[] args)throws Exception{
	   new bryce().run();
	}
	public void run()throws Exception{
        // Scanner f = new Scanner(System.in);
        Scanner f = new Scanner(new File("bryce.dat"));
        while(f.hasNext()){
            int N = f.nextInt();
            System.out.print(N + ":");
            String s = "",rn;
            if(N>=1000){
                rn = "M";
                s += rn.repeat(N/1000);
                N%=1000;
            }
            if(N>=500){
                rn = "D";
                s += rn.repeat(N/500);
                N%=500;
            }
            if(N>=100){
                rn = "C";
                s += rn.repeat(N/100);
                N%=100;
            }
            if(N>=50){
                rn = "L";
                s += rn.repeat(N/50);
                N%=50;
            }
            if(N>=10){
                rn = "X";
                s += rn.repeat(N/10);
                N%=10;
            }
            if(N>=5){
                rn = "V";
                s += rn.repeat(N/5);
                N%=5;
            }
            if(N>=1){
                rn = "I";
                s += rn.repeat(N/1);
                N%=1;
            }
            s = s.replaceAll("DCCCC","CM").replaceAll("LXXXX","XC").replaceAll("VIIII","IX").replaceAll("IIII","IV");
            System.out.println(s);
        }
    }
}
