import java.util.*;
import java.io.File;

public class battleships {
    public static void main(String[] args) throws Exception {
        new battleships().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("battleships").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            char[][] m = new char[10][10];
            f.nextLine();
            for (int i = 0; i < m.length; i++) {
                m[i] = f.nextLine().replaceAll("[0-9\\|]","").toCharArray();
            }
            int n = f.nextInt();
            f.nextLine();
            while(n-->0){
                String s = f.nextLine();
                int r = Integer.parseInt(s.substring(1));
                int c = s.charAt(0)-'A';
                try{
                    if(m[r][c]=='O'){
                        System.out.println("HIT!");
                        m[r][c] = '~';
                    }else{
                        System.out.println("MISS");
                    }
                }catch(Exception e){
                    System.out.println("MISS");
                }
            }
        }
        f.close();
    }
}
