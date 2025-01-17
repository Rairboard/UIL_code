import java.util.*;

public class testing2 {
    public static void main(String[] args)throws Exception {
//        ArrayDeque<Integer> dq =new ArrayDeque<>();
//        dq.offer(0);
//        System.out.println(dq);
//        dq.offer(2);
//        System.out.println(dq);
//        dq.pollFirst();
//        System.out.println(dq);
//        dq.pollLast();
//        System.out.println(dq);
       new testing2().run();
    }
    public void run() throws  Exception{
        Scanner f = new Scanner(System.in);
        String s = f.nextLine();
        int[] ar = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        addSpaces(s, ar);
    }
//    1 -5 -20 4 -1 3 -6 -3
public String addSpaces(String s, int[] spaces) {
    String ln = "";
    int ind = 0;
    for(int i = 0; i < s.length();i++){
        if(ind < spaces.length &&   i==spaces[ind] ){
            ln+=" ";
            ind++;
        }
        ln+=s.charAt(i);
    }
    return ln;
}
}
