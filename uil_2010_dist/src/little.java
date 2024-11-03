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

public class little {
    List<String> al = new ArrayList<>(Arrays.asList("Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Jack,Queen,King,Ace".split(",")));
    public static void main(String[] args) throws Exception {
        new little().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("little").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int n = f.nextInt();
            List<Item> list = new ArrayList<>();
            f.nextLine();
            for (int i = 0; i < n; i++) {
                String[] ln = f.nextLine().trim().split(", ");
                String[] a = ln[0].split("\\s+");
                String[] b = ln[1].split("\\s+");
                list.add(new Item(a[0],a[2],b[0],b[2]));
            }
            Collections.sort(list);
            out.println(list);
            Item last = list.get(list.size()-1);
            if(last.pair){
                int cnt = 0;
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).pair){
                        cnt++;
                    }
                }
                out.println("PAIR " + cnt);
            }
            else if(last.flush){
                int cnt = 0;
                for (int i = 0; i < list.size() ; i++) {
                    if(list.get(i).flush){
                        cnt++;
                    }
                }
                out.println("FLUSH " + cnt);
            }else{
                int cnt = 0;
                for (int i = 0; i < list.size(); i++) {
                    if(!list.get(i).pair&&!list.get(i).flush){
                        cnt++;
                    }
                }
                out.println("HIGH CARD " + cnt);
            }

        }
        f.close();
    }
    class Item implements Comparable<Item>{
        boolean pair, flush;
        String a_card,b_card,a_suit,b_suit;
        public Item(String a, String b, String c, String d) {
            a_card = a;
            a_suit = b;
            b_card = c;
            b_suit = d;
            pair = a_card.equals(b_card);
            flush = a_suit.equals(b_suit);
        }
        public int compareTo(Item o){
            if(pair && o.pair){
                return al.indexOf(a_card) - al.indexOf(o.a_card);
            }
            if(flush && o.flush){
                int a = Math.max(al.indexOf(a_card), al.indexOf(b_card));
                int b = Math.max(al.indexOf(o.a_card), al.indexOf(o.b_card));
                if(a==b){
                    return al.indexOf(b_card) - al.indexOf(o.b_card);
                }
                return a-b;
            }
            if(pair){
                return 1;
            }
            if(flush){
                return 1;
            }
            if(!pair && o.pair){
                return -1;
            }
            if(!flush && o.flush){
                return -1;
            }
            return 0;
        }
        public String toString(){
            return a_card + "-" + a_suit + " | " + b_card + "-" +b_suit;
        }
    }
}
