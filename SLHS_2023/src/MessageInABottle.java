import java.util.*;
import java.io.*;

public class MessageInABottle {
    public static void main(String[] args) throws Exception {
        new MessageInABottle().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("MessageInABottle.txt"));
        //Scanner f = new Scanner(System.in);
        String correct =f.nextLine();
        int times = f.nextInt();
        double max = 0;
        f.nextLine();
        while (times-- > 0) {
			Stack<String> s = new Stack<>();
            String in = f.nextLine();
            for (int i = 0; i < in.length(); i++) {
                if(in.substring(i,i+1).equals("#") && !s.isEmpty()){
                    s.pop();
                }else{
                    s.push(in.substring(i,i+1));
                }
            }
            String scribe = "";
            while(!s.isEmpty()){
                scribe = s.pop() + scribe;
            }
            double sec = (double)f.nextLong()/60.0;
            double right = 0;
            f.nextLine();
            for (int i = 0; i < scribe.length() && i < correct.length(); i++) {
                if(scribe.substring(i,i+1).equals(correct.substring(i,i+1))){
                    right++;
                }
            }
            double pwm = (right/5.0) / sec;
            max = Math.max(max,pwm);
            System.out.printf("%.2f%n",pwm);
        }
        System.out.printf("The highest pirate word per minute is %.2f%n",max);
        f.close();
    }
}
