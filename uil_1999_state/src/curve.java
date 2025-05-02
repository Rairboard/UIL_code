import java.util.*;
import java.io.*;
public class curve {
	public static void main(String[] args)throws Exception {
		new curve().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("curve.dat"));
        //Scanner f = new Scanner(System.in);
        String[] curve = "no curve,straight add,squares times 10".split(",");
        int exam = 1;
        while(f.hasNext()){
            long[] score = new long[20];
            long max = 0;
            for (int i = 0; i < 20; i++) {
                score[i] = f.nextLong();
                max = Math.max(max, score[i]);
            }
            long[] add = new long[20];
            long[] square = new long[20];
            for (int i = 0; i < 20; i++) {
                add[i] = score[i] + (100 - max);
                square[i] = Math.round(Math.sqrt(score[i]) * 10);
            }
            long[] lsv = new long[3];
            int[] count = new int[5];
            for (int i = 0; i < score.length; i++) {
                if(score[i]>=90) count[0]++;
                else if(score[i]>=80) count[1]++;
                else if(score[i]>=70) count[2]++;
                else if(score[i]>=60) count[3]++;
                else count[4]++;
            }
            lsv[0] = (long)(Math.pow(count[0] - 4,2) + Math.pow(count[1]-6,2) + Math.pow(count[2]-6,2) + Math.pow(count[3]-3,2) + Math.pow(count[4]-1,2));
            count = new int[5];
            for (int i = 0; i < add.length; i++) {
                if(add[i]>=90) count[0]++;
                else if(add[i]>=80) count[1]++;
                else if(add[i]>=70) count[2]++;
                else if(add[i]>=60) count[3]++;
                else count[4]++;
            }
            lsv[1] = (long)(Math.pow(count[0] - 4,2) + Math.pow(count[1]-6,2) + Math.pow(count[2]-6,2) + Math.pow(count[3]-3,2) + Math.pow(count[4]-1,2));
            count = new int[5];
            for (int i = 0; i < square.length; i++) {
                if(square[i]>=90) count[0]++;
                else if(square[i]>=80) count[1]++;
                else if(square[i]>=70) count[2]++;
                else if(square[i]>=60) count[3]++;
                else count[4]++;
            }
            lsv[2] = (long)(Math.pow(count[0] - 4,2) + Math.pow(count[1]-6,2) + Math.pow(count[2]-6,2) + Math.pow(count[3]-3,2) + Math.pow(count[4]-1,2));
            long minLSV = Math.min(Math.min(lsv[0], lsv[1]), lsv[2]);
            Map<Long,List<Integer>> m = new TreeMap<>();
            for (int i = 0; i < lsv.length; i++) {
                m.putIfAbsent(lsv[i], new ArrayList<>());
                m.get(lsv[i]).add(i);
            }
            Collections.sort(m.get(minLSV));
            System.out.println("For Exam #" + exam++ +", use " + curve[m.get(minLSV).getLast()]);
        }
        f.close();
	}
}
