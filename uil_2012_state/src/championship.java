import java.util.*;
import java.io.*;
public class championship {
	public static void main(String[] args)throws Exception {
		new championship().run();
	}

	public void run() throws Exception{
        Scanner f = new Scanner(new File("championship.dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        int[] seedOrder = {7,5,3,1,2,4,6,8};
        for(int asdf = 1;asdf <= times;asdf++){
            String event = f.nextLine();
            int swimmer = f.nextInt();
            f.nextLine();
            List<Object[]> sorted = new ArrayList<>();
            for (int i = 0; i < swimmer; i++) {
                String name = f.next() + " " + f.next();
                String[] time = f.nextLine().strip().split(":");
                if(time[0].equals("DQ")) continue;
                double t = Double.parseDouble(time[0]) * 60 + Double.parseDouble(time[1]);
                sorted.add(new Object[]{name, t,  String.join(":", time)});
            }
            Collections.sort(sorted, (a,b) -> Double.compare((double)a[1],(double)b[1]));
            List<Object[]> consolationSwimmer = new ArrayList<>();
            List<Object[]> finalSwimmer = new ArrayList<>();
            for (int i = 0; i < 8 && i < sorted.size(); i++) {
                finalSwimmer.add(sorted.get(i));
            }
            for(int i = 8;i<16 && i < sorted.size();i++){
                consolationSwimmer.add(sorted.get(i));
            }
            System.out.println(event + " CONSOLATION FINALS");
            for(int i = 0; i < seedOrder.length;i++){
                int index = seedOrder[i]-1;
                if(index<consolationSwimmer.size()){
                    String[] name = ((String) consolationSwimmer.get(index)[0]).split("\\s+");
                    System.out.println(i+1 + " " + name[1] + ", " + name[0] +" " + consolationSwimmer.get(index)[2]);
                }
            }
            System.out.println("\n" + event + " CHAMPIONSHIP FINALS");
            for(int i = 0; i < seedOrder.length;i++){
                int index = seedOrder[i]-1;
                if(index<finalSwimmer.size()){
                    String[] name = ((String) finalSwimmer.get(index)[0]).split("\\s+");
                    System.out.println(i+1 + " " + name[1] + ", " + name[0] +" " + finalSwimmer.get(index)[2]);
                }
            }
            System.out.println();
        }
        f.close();
	}
}
