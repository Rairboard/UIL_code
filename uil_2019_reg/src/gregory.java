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

public class gregory {
    public static void main(String[] args) throws Exception {
        new gregory().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("gregory").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String alphabet = f.nextLine().trim();
        String symbol = f.nextLine().trim();
        HashSet<String> common = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            String[] ln = f.nextLine().trim().split(",");
            for (int j = 0; j < ln.length; j++) {
               common.add(ln[j].toUpperCase());
            }
        }
        while(f.hasNext()){
            String ln = f.nextLine().trim();
            boolean good = true;
            if(common.contains(ln.toUpperCase())||ln.length()<8){
                good = false;
            }
            int cnt = 0;
            if (ln.matches(".*[A-Z].*")) {
                cnt++;
            }
            if (ln.matches(".*[a-z].*")) {
                cnt++;
            }
            if (ln.matches(".*[0-9].*")) {
                cnt++;
            }
            for (int i = 0; i < ln.length(); i++) {
                if (symbol.contains(ln.charAt(i)+"")) {
                    cnt++;
                    break;
                }
            }
            if(cnt<3) good = false;
            if(!good){
                out.println(ln + ":0:UNACCEPTABLE");
            }
            else{
                int score = 0;
                if(cnt==4) score+=5;
                if(ln.length()>8) score+= 2 * (ln.length()-8);
                for (int i = 0; i < ln.length(); i++) {
                    int index = alphabet.indexOf(ln.substring(i,i+1).toUpperCase());
                    if(index>=0&&index<alphabet.length()/2){
                        score++;
                    }
                    if(index>=alphabet.length()/2){
                        score+=2;
                    }
                    if (ln.substring(i, i + 1).matches("[0-9]")) {
                        score+=2;
                    }
                    if(symbol.contains(ln.substring(i,i+1))){
                        score+=3;
                    }
                }
                for (int i = 0; i < ln.length() - 1; i++) {
                    if(ln.charAt(i)==ln.charAt(i+1)){
                        score--;
                    }
                    int a = category(ln.substring(i,i+1));
                    int b = category(ln.substring(i+1,i+2));
                    if(a!=b) score+=2;
                }
                for (int i = 0; i < ln.length() - 2; i++) {
                    int a = category(ln.substring(i,i+1));
                    int b = category(ln.substring(i+1,i+2));
                    int c = category(ln.substring(i+2,i+3));
                    if(a==b && b == c){
                        score-=5;
                    }
                }
                out.print(ln+":"+score+":");
                if(score>=41) out.println("STRONG");
                else if(score>=31) out.println("GOOD");
                else if(score>=16) out.println("FAIR");
                else if(score>=1) out.println("WEAK");
                else out.println("UNACCEPTABLE");
            }
        }
        f.close();
    }
    public int category(String ln){
        if(ln.matches("[a-z]")) return 0 ;
        if(ln.matches("[A-Z]")) return 1;
        if(ln.matches("[0-9]")) return 2;
        return 3;
    }
}
