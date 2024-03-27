import java.util.*;
import java.io.File;

public class pyramid {
    public static void main(String[] args) throws Exception {
        new pyramid().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("pyramid").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r = f.nextInt(), c = f.nextInt();
            f.nextLine();
            int[][] m = new int[r][c];
            List<List<Integer>> al = new ArrayList<>();
            boolean solved = true;
            for (int i = 0; i < r; i++) {
                m[i] = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            int top = 0 , left = 0, right = c-1, bottom = r-1;
            while(top<=bottom && left<=right) {
                int in = top;
                al.add(new ArrayList<>());
                for(int j = left;j<=right;j++){
                    al.get(in).add(m[top][j]);
                }
                top++;
                if(top>=bottom || left>=right){
                    break;
                }
                for(int j = top;j<=bottom;j++){
                    al.get(in).add(m[j][right]);
                }
                right--;
                for(int j = right;j>=left;j--){
                    al.get(in).add(m[bottom][j]);
                }
                bottom--;
                for(int j = bottom;j>=top;j--){
                    al.get(in).add(m[j][left]);
                }
                left++;
            }
            for (int i = 0; i < al.size()-1; i++) {
                List<Integer> cur = new ArrayList<>(al.get(i));
                List<Integer> next = new ArrayList<>(al.get(i+1));
                Collections.sort(cur);
                Collections.sort(next);
                if(!cur.isEmpty()&&!next.isEmpty()){
                    if(cur.getLast()>= next.getFirst()){
                        solved = false;
                        break;
                    }
                }
            }
            System.out.println(solved?"BUILD IT":"SCRAP IT");
        }
        f.close();
    }
}
