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

public class Switch {
    public static void main(String[] args) throws Exception {
        new Switch().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Switch").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times =f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf<=times;asdf++){
            int n = f.nextInt(), k = f.nextInt();
            f.nextLine();
            BitSet[] toggle = new BitSet[k];
            for (int i = 0; i < k; i++) {
                toggle[i] = new BitSet(n);
                String flip = f.nextLine();
                for(int j = n-1;j>=0;j--){
                    if(flip.charAt(j) == 'Y'){
                        toggle[i].set(n-1-j);
                    }
                }
            }
            int move = -1;
            BitSet s = new BitSet(n), e = new BitSet(n);
            e.set(0,n);
            HashSet<BitSet> visited = new HashSet<>();
            visited.add(s);
            Queue<state> q = new LinkedList<>();
            q.offer(new state(s, 0));
            while(!q.isEmpty()){
                state cur = q.remove();
                if(cur.step > 10) continue;
                if (cur.curSwitch.equals(e)) {
                    move = cur.step;
                    break;
                }
                for (int i = 0; i < k; i++) {
                    BitSet newSwitch = (BitSet)cur.curSwitch.clone();
                    newSwitch.xor(toggle[i]);
                    if (!visited.contains(newSwitch)) {
                        visited.add(newSwitch);
                        q.offer(new state(newSwitch, cur.step+1));
                    }
                }
            }
            if(move==-1) out.println("TOO HARD!");
            else out.println(move);
        }
        f.close();
    }
    class state{
        BitSet curSwitch;
        int step;
        public state(BitSet b, int s){
            curSwitch = b;
            step = s;
        }
    }
}

