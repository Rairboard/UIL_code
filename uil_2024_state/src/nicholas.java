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

public class nicholas {
    int max;
    List<Integer> al;
    public static void main(String[] args) throws Exception {
        new nicholas().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("nicholas").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            int[][] event = new int[n][3];
            String[] ln = f.nextLine().trim().split(",");
            for (int i = 0; i < ln.length; i++) {
                event[i] = Arrays.stream(ln[i].split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            max = 0;
            al = new ArrayList<>();
            HashSet<Integer> visited = new HashSet<>();
            ArrayDeque<int[]> interval =new ArrayDeque<>();
            recur(event, 0, visited, interval);
            Collections.sort(al, (a,b) -> event[a][0] - event[b][0]);
            for(Integer  i : al){
                out.print(i + 1 + " ");
            }
            out.println();
        }
        f.close();
    }
    public void recur(int[][] event, int total, HashSet<Integer> visited, ArrayDeque<int[]> interval){
        for(int i = 0;i < event.length;i++){
            if(visited.contains(i)) continue;
            int s = event[i][0], e = event[i][1];
            boolean canUsed = true;
            for(int[] pos : interval){
                if(s < pos[0] && e > pos[1]) canUsed = false;
                if(s > pos[0] && s < pos[1] || e > pos[0] && e < pos[1]) canUsed = false;
                if(!canUsed) break;
            }
            if(canUsed){
                visited.add(i);
                interval.push(new int[]{s,e});
                if(total + event[i][2] > max){
                    max = total + event[i][2];
                    al = new ArrayList<>(visited);
                }
                recur(event, total + event[i][2], visited, interval);
                visited.remove(i);
                interval.pop();
            }
        }
    }
}
