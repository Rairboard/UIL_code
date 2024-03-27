import java.util.*;
import java.io.File;

public class catscan {
    public static void main(String[] args) throws Exception {
        new catscan().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("catscan").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String[] ln = f.nextLine().split("\\s+");
            String name = (ln[0]+" "+ln[1]).replaceAll("'","");
            int year = Integer.parseInt(ln[ln.length-1]);
            if(name.equals("Mick Jagger")){
                System.out.println(name +" is SEXY!");
            }
            else if(year>=1975){
                System.out.println(name +" is SEXY!");
            }else{
                System.out.println(name+" is a DINOSAUR!");
            }
        }
        f.close();
    }
}
