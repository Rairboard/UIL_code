import java.util.*;
import java.io.*;
import java.math.*;

public class pilar {
    public static void main(String[] args) throws Exception {
        new pilar().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("pilar.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int time = 0; time < times;time++){
            Map<Integer,String[][]> hm = new TreeMap<>();
            String[] in = f.nextLine().split("[,:]");
            int ll = Integer.parseInt(in[0]), ul = Integer.parseInt(in[1]);
            int lr = Integer.parseInt(in[2]), ur = Integer.parseInt(in[3]);
            int lc = Integer.parseInt(in[4]), uc = Integer.parseInt(in[5]);
            int minR = Math.min(lr,ur), minC = Math.min(lc, uc);
            lr -= minR;
            ur -= minR;
            lc -= minC;
            uc -= minC;
            for(int i=ll;i<=ul;i++){
                hm.put(i,new String[ur-lr+1][uc-lc+1]);
            }
            for(int i = ll; i<=ul;i++){
                for(int j = lr;j <= ur;j++){
                    hm.get(i)[j] = f.nextLine().split(",");
                }
            }
        //   for(Integer i : hm.keySet()){
        //       System.out.println(i +" " + Arrays.deepToString(hm.get(i)));
        //   }
            int N = f.nextInt();
            f.nextLine();
            while(N-->0){
                in = f.nextLine().split("[,:]");
                ll = Integer.parseInt(in[0]); ul = Integer.parseInt(in[1]);
                lr = Integer.parseInt(in[2]); ur = Integer.parseInt(in[3]);
                lc = Integer.parseInt(in[4]); uc = Integer.parseInt(in[5]);
                double sum = 0;
                for(int i=ll;i<=ul;i++){
                    for(int r = lr;r<=ur;r++){
                        for(int c = lc;c <= uc;c++){
                            sum += Double.parseDouble(hm.get(i)[r-minR][c-minC]);
                        }
                    }
                }
                int layers = ul - ll + 1;
                int row = ur- lr + 1;
                int col = uc - lc + 1;
                System.out.printf("%d:%.2f%n", layers * row * col, sum);
            }
            System.out.println("====================");
        }
        f.close();
    }
}
