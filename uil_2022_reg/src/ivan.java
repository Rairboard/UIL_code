import java.util.*;
import java.io.*;
class ivan{
    public static void main(String[] args) throws FileNotFoundException {
        new ivan().run();
    }
    public void run () throws FileNotFoundException {
        // Scanner f = new Scanner(System.in);
        Scanner f = new Scanner(new File("ivan.dat"));
        int time = f.nextInt();
        String key = f.next();
        for(int t=1;t<=time;t++){
            String ans = f.next();
            int right = 0, wrong = 0, atmp = 0;
            for(int i=0;i<ans.length();i++){
                if(ans.charAt(i)!='_'){
                    atmp++;
                    if(ans.charAt(i)==key.charAt(i)){
                        right++;
                    }
                    else{
                        wrong++;
                    }
                }
            }
            System.out.printf("Exam #%d: %d %.1f%n",t,(right*6 - wrong*2),((double)right/atmp));
        }
    }
}
