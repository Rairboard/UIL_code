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

public class kevin {
    public static void main(String[] args) throws Exception {
        new kevin().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("kevin").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        List<String[]> al =new ArrayList<>();
        double totalDist = 0, totalTime = 0, day = 0, longestDist = 0, longestTime = 0, fastestPace = 0;
        double shortDist = 0, shortTime = 0, mediumDist = 0, mediumTime = 0, longDist = 0, longTime = 0;
        int[] count = new int[3];
        while(f.hasNext()){
            String[] ln = f.nextLine().trim().split("\\s+");
            double dist = Double.parseDouble(ln[1]);
            String[] time = ln[2].split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            int s = Integer.parseInt(time[2]);
            double t = h * 3600 + m * 60 + s;
            totalDist+=dist;
            totalTime+=t;
            day++;
            longestDist = Math.max(longestDist, dist);
            longestTime = Math.max(longestTime, t);
            fastestPace = Math.max(t/dist, fastestPace);
            if(dist>=42.195/2){
                longDist+=dist;
                longTime+=t;
                count[0]++;
            }
            if(dist>=10){
                mediumDist+=dist;
                mediumTime+=t;
                count[1]++;
            }
            if(dist>=5){
                shortDist+=dist;
                shortTime+=t;
                count[2] ++;
            }
            al.add(ln);
        }
        double longestConsecDist = 0, longestConsecTime = 0;
        String streak = "";
        for(int i = 0;i < al.size()-6;i++){
            double d = 0, t = 0;
            for(int j = i;j<i+7;j++){
                d+=Double.parseDouble(al.get(j)[1]);
                String[] time = al.get(j)[2].split(":");
                int h = Integer.parseInt(time[0]);
                int m = Integer.parseInt(time[1]);
                int s = Integer.parseInt(time[2]);
                t+=h * 3600 + m * 60 + s;
            }
            if(d > longestConsecDist){
                longestConsecDist = d;
                longestConsecTime = t;
                streak = al.get(i)[0] +"-"+al.get(i+6)[0];
            }
        }
        out.printf("Total distance = %.2f\n", totalDist);
        out.printf("Total time = %d:%d:%d\n", (long)totalTime/3600, (long)totalTime%3600/60, (long)totalTime%3600%60);
        out.printf("Average distance = %.2f\n", totalDist/day);
        totalTime/=day;
        out.printf("Average time = %d:%d:%d\n", (long)totalTime/3600, (long)totalTime%3600/60, (long)totalTime%3600%60);
        out.printf("Longest distance = %.2f\n", longestDist);
        out.printf("Longest time = %d:%d:%d\n", (long)longestTime/3600, (long)longestTime%3600/60, (long)longestTime%3600%60);
        out.printf("Fastest pace = %.2f\n" , fastestPace / 60);
        longDist/=count[0];
        longTime/=count[0];
        mediumDist/=count[1];
        mediumTime/=count[1];
        shortDist/=count[2];
        shortTime/=count[2];
        out.printf("Short run average distance = %.2f\nShort run average pace = %.2f\nMedium run average distance = %.2f\nMedium run average distance = %.2f\nLong run average distance = %.2f\nLong run average distance = %.2f\n", shortDist, shortTime/60, mediumDist, mediumTime/60, longDist, longTime/60);
        out.println("Best 7-day streak " + streak);
        out.printf("Total distance = %.2f\nTotal time = %d:%d:%d\nAverage distance = %.2f\nAverage time = %d:%d:%d\nAverage pace = %.2f\n", longestConsecDist, (long)longestConsecTime/3600, (long)longestConsecTime%3600/60, (long)longestConsecTime%3600%60, longestConsecDist/7, (long)longestConsecTime/7/3600, (long)longestConsecTime/7%3600/60, (long)longestConsecTime/7%3600%60, longestConsecTime/60/7);
        f.close();
    }
}
