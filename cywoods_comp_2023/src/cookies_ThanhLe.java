import java.util.*;
import java.io.File;

public class cookies_ThanhLe {
    public static void main(String[] args) throws Exception {
        new cookies_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("cookies.dat"));
        //Scanner f = new Scanner(System.in);
        String[] measure = "cup of flour,cup of butter,teaspoon of baking soda,cup of sugar,cup of royal icing,egg".split(",");
        double[] amt = {2.0,3.0/4,1.5,3.0,1.0/2,1.0};
        while(f.hasNext()){
            int cc = f.nextInt();
            for (int i = 0; i < 4; i++) {
                f.next();
            }
            String[] name = {f.next(),f.next()};
            if(!name[0].toLowerCase().matches("[shrank]") && !name[1].toLowerCase().matches("[fraeder]+")){
                System.out.println("Shopping list for " + name[0] + " " + name[1] + "'s order:");
                for (int i = 0; i < 6; i++) {
                    double a = cc * amt[i];
                    String b = measure[i];
                    if(a > 1){
                        if(b.equals("egg")){
                            b+="s";
                        }else{
                            b = b.substring(0,b.indexOf(" ")) + "s" + b.substring(b.indexOf(" "));
                        }
                    }
                    if(a % 1 ==0){
                        System.out.println((int)a + " " + b);
                    }
                    else{
                        System.out.printf("%.2f %s\n",a,b);
                    }
                }
            }else{
                System.out.println("DO NOT SELL!!!");
            }
            System.out.println();
        }
        f.close();
    }
}
