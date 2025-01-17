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

public class all {
    List<String> team = new ArrayList<>(List.of("Armadillos", "Anesthesiologists", "Apples", "Bratwursts", "Banditos", "Bananas", "Cattle", "Chefs","Coconuts","Donkeys","Dopplegangers","Donuts"));
    public static void main(String[] args) throws Exception {
        new all().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("all").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();f.nextLine();
            Map<String,Integer>[][] m  = new HashMap[team.size()][2];
            for (int i = 0; i < team.size(); i++) {
                m[i] = new HashMap[2];
                m[i][0] = new HashMap<>();
                m[i][1] = new HashMap<>();
            }
            // 0 = win, 1 = loss
            for(int i =0 ;i < n;i++){
                String[] ln = f.nextLine().trim().split("\\s+");
                int winner =team.indexOf(ln[0]);
                int loser = team.indexOf(ln[1]);
                m[winner][0].put(ln[1],m[winner][0].getOrDefault(ln[1],0)+1);
                m[loser][1].put(ln[0],m[loser][1].getOrDefault(ln[0],0)+1);
            }
            String[] ln = f.nextLine().trim().split("\\s+");
            int a = team.indexOf(ln[0]), b = team.indexOf(ln[1]);
            int[] totalWin = new int[2];
            int[] h2h = new int[2];
            int[] divWin = new int[2];
            for(String t : m[a][0].keySet()){
                totalWin[0]+=m[a][0].get(t);
            }
            for(String t : m[a][1].keySet()){
                totalWin[0]-=m[a][1].get(t);
            }
            for(String t : m[b][0].keySet()){
                totalWin[1] += m[b][0].get(t);
            }
            for(String t : m[b][1].keySet()){
                totalWin[1]-=m[b][1].get(t);
            }
            if(totalWin[0] == totalWin[1]){
                if(m[a][0].get(ln[1])!=null) h2h[0] += m[a][0].get(ln[1]);
                if(m[a][1].get(ln[1])!=null) h2h[0] -= m[a][1].get(ln[1]);
                if(m[b][0].get(ln[0])!=null) h2h[1] += m[b][0].get(ln[0]);
                if(m[b][1].get(ln[0])!=null) h2h[1] -= m[b][1].get(ln[0]);
                if(h2h[0]==h2h[1]){
                    int[] range1 = divRange(ln[0]), range2 = divRange(ln[1]);
                    for(int i = range1[0]; i<= range1[1];i++){
                        if(i==a) continue;
                        if(m[a][0].get(team.get(i))!=null){
                            divWin[0] += m[a][0].get(team.get(i));
                        }
                        if(m[a][1].get(team.get(i))!=null){
                            divWin[0]-=m[a][1].get(team.get(i));
                        }
                    }
                    for(int i = range2[0]; i<=range2[1];i++){
                        if(i==b) continue;
                        if(m[b][0].get(team.get(i))!=null){
                            divWin[1]+= m[b][0].get(team.get(i));
                        }
                        if(m[b][1].get(team.get(i))!=null){
                            divWin[1]-=m[b][1].get(team.get(i));
                        }
                    }
                    out.println(divWin[0]>divWin[1]? ln[0]:ln[1]);
                }
                else{
                    out.println(h2h[0]>h2h[1]?ln[0]:ln[1]);
                }
            }
            else{
                out.println(totalWin[0]>totalWin[1] ? ln[0]:ln[1]);
            }
        }
        f.close();
    }
    public int[] divRange(String n){
        int i = team.indexOf(n);
        if(i>=0&&i<=2){
            return new int[]{0,2};
        }
        else if(i>=3 && i <= 5){
            return new int[]{3,5};
        }
        else if(i >= 6 && i<= 8){
            return new int[]{6,8};
        }
        else{
            return new int[]{9,11};
        }
    }
}
