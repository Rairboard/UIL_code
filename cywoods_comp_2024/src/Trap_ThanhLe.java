import java.util.*;
import java.io.File;

public class Trap_ThanhLe {
    char[][] m;
    boolean[][] v;
    boolean solved, trap, volcano;
    public static void main(String[] args) throws Exception {
        new Trap_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Trap").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r = f.nextInt(), c = f.nextInt(),sr = f.nextInt(), sc = f.nextInt(),er = -1, ec = -1;
            char dir = f.next().charAt(0);
            int d = f.nextInt();
            f.nextLine();
            m = new char[r][c];
            v = new boolean[r][c];
            solved = false;
            trap = false;
            volcano = false;
            if(dir=='L'){
                d*=-1;
            }
            for (int i = 0; i < r; i++) {
                String s = f.nextLine().trim();
                m[i] = s.toCharArray();
                if (s.contains("E")) {
                    er = i;
                    ec = s.indexOf("E");
                }
            }
            for (int layer = 0; layer < c/2; ++layer) {
                List<Character> al = new ArrayList<>();
                int top = layer, left = layer, bottom = r-1-layer, right = c-1-layer;
                for(int j = left;j<=right;j++){
                    if(valid(top,j)) al.add(m[top][j]);
                }
                top++;
                for(int j = top;j<=bottom;j++){
                    if(valid(j,right)) al.add(m[j][right]);
                }
                right--;
                for(int j = right;j>=left;j--){
                    if(valid(bottom,j)) al.add(m[bottom][j]);
                }
                bottom--;
                for(int j = bottom;j>=top;j--){
                    if(valid(j,left)) al.add(m[j][left]);
                }
                Collections.rotate(al,d*layer);
                top = layer;
                left = layer;
                bottom = r - 1 - layer;
                right = c - 1 - layer;
                for(int j = left;j<=right;j++){
                    if(valid(top,j)) m[top][j] = al.remove(0);
                }
                top++;
                for(int j = top;j<=bottom;j++){
                    if(valid(j,right)) m[j][right] = al.remove(0);
                }
                right--;
                for(int j = right;j>=left;j--){
                    if(valid(bottom,j)) m[bottom][j] = al.remove(0);
                }
                bottom--;
                for(int j = bottom;j>=top;j--) {
                    if(valid(j,left)) m[j][left] = al.remove(0);
                }
                for(char[] cc : m){
                    System.out.println(cc);
                }
                System.out.println();
            }
            if(sr==er){
                if(sc < ec){
                    travel(sr,sc,0,1);
                }
                else{
                    travel(sr,sc,0,-1);
                }
            }
            if(sc == ec){
                if(sr < er){
                    travel(sr,sc,1,0);
                }
                else{
                    travel(sr,sc,-1,0);
                }
            }
            if(solved){
                System.out.println("New candies are mine.");
            }
            else if(trap){
                System.out.println("Trapped.");
            }
            else if(volcano){
                System.out.println("Goodbye world.");
            }
        }
        f.close();
    }
    public void travel(int r, int c, int R, int C){
        if(solved||volcano||trap) return;
        if(r==-1||c==-1||r==m.length||c==m[r].length) return;
        if(m[r][c]!='.' && m[r][c]!='A'){
            if(m[r][c]=='E'){
                solved = true;
            }
            if(m[r][c]=='@'){
                volcano = true;
            }
            if(m[r][c] == '#'){
                trap = true;
            }
        }else{
            char ch = m[r][c];
            m[r][c]='.';
            travel(r+R,c+C,R,C);
            m[r][c] = ch;
        }
    }
    public boolean valid(int r, int c){
        return r>=0&&r<m.length&&c>=0&&c<m[r].length;
    }
}
