import java.util.*;
import java.io.File;

public class seating_ThanhLe {
    List<String> bad = new ArrayList<>(Arrays.asList("Nik.S Bow.Y Hen.F Tro.D Bra.B Jar.A".split(" ")));
    public static void main(String[] args) throws Exception {
        new seating_ThanhLe().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File("seating.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int period = f.nextInt();
            f.nextLine();
            List<String> student = new ArrayList<>();
            List<String> front = new ArrayList<>();
            String[] ln = f.nextLine().split("\\s+");
            for (int i = 0; i < ln.length; i++) {
                if(bad.contains(ln[i])){
                    front.add(ln[i]);
                }else{
                    student.add(ln[i]);
                }
            }
            Collections.sort(front , (a,b) -> {
                return bad.indexOf(a) - bad.indexOf(b);
            });
            front.addAll(student);
            int size = (int)Math.ceil(Math.sqrt(front.size())), top = 0, left = 0, right = size-1, bottom = size-1;
            String[][] m = new String[size][size];
            while(top <= bottom && left <= right){
                for (int i = left; i <= right; i++) {
                    m[top][i] = front.size() > 0 ? front.remove(0) : "     ";
                }
                top++;
                for(int i = top; i<= bottom;i++){
                    m[i][right] = front.size() > 0 ? front.remove(0) : "     ";
                }
                right--;
                for(int i = right;i>= left;i--){
                    m[bottom][i] = front.size() > 0 ? front.remove(0) : "     ";
                }
                bottom--;
                for(int i = bottom;i>=top;i--){
                    m[i][left] = front.size() > 0 ? front.remove(0) : "     ";
                }
                left++;
            }
            for (int i = 0; i < m[0].length; i++) {
                List<String> col = new ArrayList<>();
                for (int j = 0; j < m.length; j++) {
                    if(!m[j][i].matches("\\s+")){
                       col.add(m[j][i]);
                       m[j][i] = "     ";
                    }
                }
                for (int j = 0; j < m.length; j++) {
                    if(col.size() > 0){
                        m[j][i] = col.remove(0);
                    }
                }
            }
            System.out.println("Period " + period);
            System.out.println("-".repeat(("Period " + period).length()));
            for (int i = 0; i < m.length; i++) {
                String l = "";
                for (int j = 0; j < m[i].length; j++) {
                    l += m[i][j] + " ";
                }
                if(!l.trim().isEmpty()){
                    System.out.println(l);
                }
            }
            System.out.println();
        }
        f.close();
    }
}
