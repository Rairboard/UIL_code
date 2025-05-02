import java.util.*;
import java.io.*;
public class scoreboard {
	public static void main(String[] args)throws Exception {
		new scoreboard().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("scoreboard.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            Map<Integer,Map<Integer,List<String>>> record = new HashMap<>();
            f.nextLine();
            int t = f.nextInt();
            f.nextLine();
            for (int i = 0; i < t; i++) {
                int teamNumber = f.nextInt(), problem = f.nextInt();
                String status = f.next();
                record.putIfAbsent(teamNumber, new HashMap<>());
                record.get(teamNumber).putIfAbsent(problem, new ArrayList<>());
                record.get(teamNumber).get(problem).add(status);
            }
            List<long[]> al = new ArrayList<>();
            for(int team : record.keySet()){
                boolean display = false;
                long[] ar = new long[3];
                ar[0] = team;
                for(int problem : record.get(team).keySet()){
                    List<String> submission = new ArrayList<>(record.get(team).get(problem));
                    if (submission.contains("A") || submission.contains("I") || submission.contains("E") || submission.contains("U")) {
                        display = true;
                    }
                    else continue;
                    if(submission.contains("A")){
                        for(int i = 0;i < submission.indexOf("A");i++){
                            if (submission.get(i).equals("I")) {
                                ar[2]-=5;
                            }
                        }
                        ar[2]+=60;
                        ar[1]++;
                    }
                }
                if(ar[2] < 0) ar[2] = 0;
                if(display)al.add(ar);
            }
//            System.out.println(record);
            Collections.sort(al, (a,b) -> Long.compare(b[2],a[2]) == 0 ? Long.compare(a[0], b[0]) : Long.compare(b[2],a[2]));
            for(long[] team : al){
                System.out.println(team[0] + " " + team[1] +" " + team[2]);
            }
            System.out.println();
        }
        f.close();
	}
}
