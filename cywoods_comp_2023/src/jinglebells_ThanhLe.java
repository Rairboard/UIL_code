import java.util.*;
import java.io.File;

public class jinglebells_ThanhLe {
    public static void main(String[] args) throws Exception {
        new jinglebells_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("jinglebells.dat"));
        //Scanner f = new Scanner(System.in);
        int j = 0 , b = 0;
        while(f.hasNext()){
            if (f.next().equals("jingle")) {
                j++;
            }else{
                b++;
            }
        }
        System.out.println("jingle:" + j + "\nbells:" + b);
        f.close();
    }
}
