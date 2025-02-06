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

public class dhruv {
    public static void main(String[] args) throws Exception {
        new dhruv().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dhruv").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);

        Map<String,Integer> channel = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            channel.put(f.next(), f.nextInt());
        }
        int n = f.nextInt();
        f.nextLine();
        for (int i = 0; i < n; i++) {
            int fr = f.nextInt();
            if( fr < 535 || fr > 1605) out.println("BAD INPUT");
            else{
                Map<Integer,List<String>> closeChannel = new TreeMap<>();
                for(String c : channel.keySet()){
                    closeChannel.putIfAbsent(Math.abs(channel.get(c) - fr),new ArrayList<>());
                    closeChannel.get(Math.abs(channel.get(c)-fr)).add(c);
                }
                int bestDistance = new ArrayList<>(closeChannel.keySet()).getFirst();
                if(closeChannel.get(bestDistance).size()>1){
                    Collections.sort(closeChannel.get(bestDistance), (a,b) -> channel.get(b) - channel.get(a));
                    out.println(closeChannel.get(bestDistance).getFirst());
                }
                else{
                    out.println(closeChannel.get(bestDistance).getFirst());
                }
            }
        }
        f.close();
    }
}
