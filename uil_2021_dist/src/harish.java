import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class harish {
    public static void main(String[] args) throws Exception {
        new harish().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("harish").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        int[] vr = {-2,-2,2,2};
        int[] vc = {-2,2,2,-2};
        for (int asdf = 1; asdf <= times; asdf++) {
            char[][] m = new char[5][5];
            boolean found = true;
            List<int[]> al = new ArrayList<>();
            for (int i = 0; i < m.length; i++) {
                m[i] = f.nextLine().toCharArray();
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]=='a'){
                        al.add(new int[]{i,j});
                    }
                }
            }
            if(f.hasNext()){f.nextLine();}
            if(al.size()!=9){
                found = false;
            }
            o : for (int i = 0; i < al.size(); i++) {
                int r = al.get(i)[0];
                int c = al.get(i)[1];
                for (int j = 0; j < 4; j++) {
                    int nr = r + vr[j];
                    int nc = c + vc[j];
                    if(nr>=0&&nc>=0&&nr<m.length&&nc<m[nr].length){
                        if(m[nr][nc]=='a'){
                            found = false;
                            break o;
                        }
                    }
                }
            }
            out.println(found?"valid":"invalid");
        }
        f.close();
    }
}
