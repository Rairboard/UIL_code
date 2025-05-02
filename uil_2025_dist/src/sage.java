import java.util.*;
import java.io.*;
public class sage {
	public static void main(String[] args)throws Exception {
		new sage().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("sage.dat"));
        //Scanner f = new Scanner(System.in);
        List<String> high = new ArrayList<>(), low =new ArrayList<>();
        long max = 0, min = Long.MAX_VALUE;
        double sum = 0;
        List<Object[]> al = new ArrayList<>();
        while(f.hasNext()){
            String id = f.next();
            long score = f.nextLong();
            sum+=score;
            al.add(new Object[]{id, score});
            if(score > max){
                max = score;
                List<String> tmp =new ArrayList<>();
                tmp.add(id);
                high = new ArrayList<>(tmp);
            }
            else if(score==max){
                high.add(id);
            }
            if(score < min){
                min = score;
                List<String> tmp = new ArrayList<>();
                tmp.add(id);
                low = new ArrayList<>(tmp);
            }
            else if(score == min){
                low.add(id);
            }
        }
        sum/=al.size();
        System.out.printf("Average score: %.2f\n", sum);
        System.out.printf("   Highest score: %d\n", max);
        System.out.println(" ".repeat(6) + "Students with highest score:");
        for(String id : high){
            System.out.println(" ".repeat(9) + id);
        }
        System.out.println(" ".repeat(3) + "Lowest score: " + min);
        System.out.println(" ".repeat(6) + "Students with lowest score:");
        for(String id : low){
            System.out.println(" ".repeat(9) + id);
        }
        int cnt = 0;
        for (int i = 0; i < al.size(); i++) {
            if((long)al.get(i)[1] > sum){
                cnt++;
            }
        }
        System.out.println("Number of students above the average: " + cnt);
        f.close();
	}
}
