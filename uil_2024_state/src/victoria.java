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

public class victoria {
    public static void main(String[] args) throws Exception {
        new victoria().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("victoria").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String word = f.nextLine();
            String[] ln = word.trim().split("\\s+");
            Set<String> fourword = new HashSet<>();
            for (int i = 0; i < ln.length; i++) {
                if(ln[i].length()>=4){
                    fourword.add(ln[i]);
                }
            }
            if(fourword.size()>=4 && word.length()>=20){
                int score = 100;
                int upper = 0;
                Set<String> seen = new HashSet<>();
                for (int i = 0; i < ln.length; i++) {
                    if (!fourword.contains(ln[i])) {
                        score+=10;
                    }
                    if (ln[i].matches(".*[^a-zA-Z0-9].*")) {
                        score+=5;
                    }
                    if (ln[i].matches(".*[0-9].*")) {
                        score+=5;
                    }
                    if (ln[i].matches("[\\p{Punct}A-Z0-9]+")) {
                        upper++;
                    }
                    if (ln[i].matches("[a-zA-Z]{2,}")) {
                        if(ln[i].matches("[\\p{Punct}a-z0-9]+") || ln[i].matches("[\\p{Punct}A-Z0-9]+")){
                            score-=10;
                        }
                    }
                    if (seen.contains(ln[i])) {
                        score-=20;
                    }
                    seen.add(ln[i]);
                }
                for (int i = 0; i < ln.length; i++) {
                    for (int j = i+1; j < ln.length; j++) {
                        if (ln[j].startsWith(ln[i]) || ln[j].endsWith(ln[i])) {
                            score-=10;
                            break;
                        }
                    }
                }
                if(upper<ln.length/2){
                    score+=upper * 10;
                }
                out.print(score+":");
                if(score>=150){
                    out.println("Excellent");
                }
                else if(score >= 125){
                    out.println("Strong");
                }
                else if(score >= 100){
                    out.println("Adequate");
                }
                else if(score>=75){
                    out.println("Weak");
                }
                else if(score>=50){
                    out.println("Poor");
                }
                else{
                    out.println("Unacceptable");
                }
            }
            else{
                out.println(0 + ":Unacceptable");
            }
        }
        f.close();
    }
}
