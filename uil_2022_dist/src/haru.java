import java.math.BigInteger;
import java.util.*;
import java.io.*;
class haru {
    public static void main(String[] args) throws Exception{
        new haru().run();
    }
    public void run()throws Exception{
        // Scanner f =new Scanner(System.in);
        Scanner f= new Scanner(new File("haru.dat"));
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 0; asdf < times; asdf++) {
            int n = f.nextInt();
            HashSet<String> spike = new HashSet<>();
            int x1 = f.nextInt(), y1 = f.nextInt();
            String a = f.nextLine().trim();
            int x2 = f.nextInt(), y2 = f.nextInt();
            String b = f.nextLine().trim();
            boolean headOn = false, p1spike = false, p2spike = false;
            for (int i = 0; i < n; i++) {
                int[] p1 = move(x1,y1,a.charAt(i));
                int[] p2 = move(x2,y2,b.charAt(i));
                if(p1[0]==p2[0] && p1[1] == p2[1]) headOn = true;
                if(p1[0] == x2 && p1[1] == y2 && p2[0] == x1 && p2[1] == y1) headOn = true;
                if(p1[0] < 0 || p1[0] > 100 || p1[1] < 0 || p1[1] > 100 || spike.contains(p1[0]+" " + p1[1])|| spike.contains(x1+" "+y1)) p1spike = true;
                if(p2[0] < 0 || p2[0] > 100 || p2[1] < 0 || p2[1] > 100 || spike.contains(p2[0] +" "+p2[1])|| spike.contains(x2+" "+y2)) p2spike = true;
                spike.add(x1+" "+y1);
                spike.add(x2+" "+y2);
                x1 = p1[0];
                y1 = p1[1];
                x2 = p2[0];
                y2 = p2[1];
                if(headOn||p1spike||p2spike) break;
            }
            if(headOn) System.out.println("HEAD ON");
            else if(p1spike && p2spike) System.out.println("DOUBLE SPIKE");
            else if(!p1spike&&!p2spike) System.out.println("DRAW");
            else if(p1spike) System.out.println("P2 WIN");
            else  System.out.println("P1 WIN");
        }
        f.close();
    }
    public int[] move(int x, int y, char move){
        int[] pos = new int[]{x,y};
        switch (move){
            case 'R' -> pos[0]++;
            case 'L' -> pos[0]--;
            case 'U' -> pos[1]++;
            case 'D' -> pos[1]--;
        }
        return pos;
    }
}