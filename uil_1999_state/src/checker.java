import java.util.*;
import java.io.*;
public class checker {
	public static void main(String[] args)throws Exception {
		new checker().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("checker.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        List<String> al = new ArrayList<>();
        int[][] prescore = new int[times][26];
        for(int asdf = 1;asdf <= times;asdf++){
            String ln = f.nextLine().trim().toLowerCase();
            al.add(ln);
            prescore[asdf-1] = calc(ln);
        }
        while(f.hasNext()){
            String ln = f.nextLine().trim().toLowerCase();
            if(al.contains(ln)) continue;
            int[] cnt = calc(ln);
            int mx = Integer.MIN_VALUE;
            Map<Integer, List<String>> m = new TreeMap<>(Collections.reverseOrder());
            for (int i = 0; i < times; i++) {
                int score = 0;
                for (int j = 0; j < 26; j++) {
                    if(prescore[i][j] > 0 && cnt[j]>0){
                        score++;
                    }
                    if(prescore[i][j]>0 && cnt[j]==0){
                        score--;
                    }
                    if(prescore[i][j]==0 && cnt[j]>0) {
                        score--;
                    }
                }
                m.putIfAbsent(score, new ArrayList<>());
                m.get(score).add(al.get(i));
                mx = Math.max(mx, score);
            }
            System.out.print(ln+"->");
            if(mx < 0) System.out.println("NO SUGGESTION");
            else System.out.println(m.get(mx).getFirst());
        }
        f.close();
	}
    public int[] calc(String ln){
        int[] count = new int[26];
        for (int i = 0; i < ln.length(); i++) {
            count[ln.charAt(i)-'a']++;
        }
        return count;
    }
}
