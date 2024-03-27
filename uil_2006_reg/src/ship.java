import java.util.*;
import java.io.*;

public class ship {
    char[][] m;
    Map<Character,Integer> cnt;
    Map<Character,String> type;
    public static void main(String[] args) throws Exception {
        new ship().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("ship.in"));
        //Scanner f = new Scanner(System.in);
        type = new HashMap<>();
        String[] ar = {"carrier","battleship","destroyer","submarine","patrol boat"};
        for (int i = 0; i < ar.length; i++) {
            type.put(Character.toUpperCase(ar[i].charAt(0)),ar[i]);
        }
        int t = f.nextInt();
        f.nextLine();
        for(int cases  = 1 ;cases<=t;cases++){
            m = new char[10][10];
            cnt = new HashMap<>();
            System.out.println("Data Set #" + cases);
            for (int i = 0; i <m.length; i++) {
                m[i] = f.nextLine().toCharArray();
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]!='.'){
                        cnt.putIfAbsent(m[i][j],0);
                        cnt.put(m[i][j],cnt.get(m[i][j])+1);
                    }
                }
            }
            int cc = f.nextInt();
            while(cc-->0){
                String p = f.next();
                int r = p.charAt(0)-'A';
                int c = Integer.parseInt(p.substring(1))-1;
                try{
                    if(m[r][c]!='.'){
                       cnt.put(m[r][c],cnt.get(m[r][c])-1);
                       if(cnt.get(m[r][c])==0){
                           System.out.println(p + " sank my " + type.get(m[r][c]) + "!");
                       }
                       else{
                           System.out.println(p + " hit!");
                       }
                       m[r][c] = '.';
                    }
                    else{
                        System.out.println(p + " miss");
                    }
                }catch (Exception e) {
                    System.out.println(p + " miss");
                }
            }
            if(f.hasNext()){
                f.nextLine();
            }
        }
        f.close();
    }
}