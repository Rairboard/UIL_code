import java.util.*;
import java.io.*;
public class sofia{
    
	public static void main(String[] args) throws Exception{
	    new sofia().run();
	}
	public void run() throws Exception{
	    // Scanner f = new Scanner(System.in);
        Scanner f = new Scanner(new File("sofia.dat"));
        int N =f.nextInt();
        for(int i = 1; i<= N;i++){
            double t = f.nextDouble(), h = f.nextDouble();
            double HI = (t + 0.5 * (t + 61.0 + ((t - 68.0) * 1.2) + (h * 0.094)))/2;
            if(HI>=80){
                System.out.print("Test case #" + i + ": ");
                HI = -42.379 + (2.04901523 * t) + (10.14333127 * h) - (0.22475541 * t * h) - (6.83783 * Math.pow(10,-3) * Math.pow(t,2)) - (5.481717 * Math.pow(10,-2) * Math.pow(h,2)) + (1.22874  * Math.pow(10,-3) * Math.pow(t,2) * h) + (8.5282 * Math.pow(10,-4) * t * Math.pow(h,2)) - (1.99 * Math.pow(10,-6) * Math.pow(t,2) * Math.pow(h,2));
                if(h < 13 && ( t >= 80 && t <= 112)){
                    HI -= ((13 - h)/4) * Math.sqrt((17- Math.abs(t - 95))/17);
                }
                if( h > 85 && (t >= 80 && t <= 87)){
                    HI += ((h-85)/10) * ((87-t)/5);
                }
                if(HI > 140 || HI < 75){
                    System.out.printf("Heat Index %.1f NOT VALID!%n", HI);
                }
                else{
                    System.out.printf("%.1f%n", HI);
                }
            }
            else{
                System.out.print("Test case #" + i + ": ");
                if(HI > 140 || HI < 75){
                    System.out.printf("Heat Index %.1f NOT VALID!%n", HI);
                } else{
                    System.out.printf("%.1f%n", HI);
                }
            }
        }
	}
}
