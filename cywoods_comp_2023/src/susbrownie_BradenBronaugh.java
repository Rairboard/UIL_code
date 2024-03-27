import java.io.*;
import java.util.*;

public class susbrownie_BradenBronaugh {
    private char[][] mat;
    private char[][] cloned;
    private boolean[][] shadow;
    private LinkedHashSet<Character> ingredients;
    private boolean escaped;
    private int SX = -1, SY = -1;

    public static void main(String[] args) throws Exception {
        new susbrownie_BradenBronaugh().run();
    }

    public void run() throws Exception {
        Scanner file = new Scanner(new File("susbrownie.dat"));
        int cases = file.nextInt();
        while(cases--> 0) {
            //initiate variables
            int row = file.nextInt(); int col = file.nextInt();
            mat = new char[row][col]; cloned = new char[row][col];
            int startR = 0;
            int startC = 0;
            SX = -1; SY = -1;
            shadow = new boolean[row][col];
            ingredients = new LinkedHashSet<>();
            escaped = false;

            //clear the junk
            file.nextLine();

            //read input and save position of starting and Special Ingredient
            for(int r = 0;r<row;r++) {
                String line = file.nextLine();
                for(int c = 0;c<col;c++) {
                    if(line.charAt(c) == 'K') {
                        startR = r;
                        startC = c;
                    }
                    if(line.charAt(c) == 'S') {
                        SX = r;
                        SY = c;
                    }
                }
                mat[r] = line.toCharArray();
                cloned[r] = line.toCharArray();
            }


            //replace the starting position with a path cause i can
            mat[startR][startC] = '.';
            cloned[startR][startC] = '.';

            //attempt to escape
            recur(startR, startC, 0);

            //caught by the police
            if(ingredients.contains('A')) System.out.println("Kenny got caught by the police...");

            //collected all and made the "special" brownies
            if(ingredients.size() == 5 && escaped) System.out.println("Kenny was able to bake brownies in complete secrecy!");

            //missing ingredients
            if(ingredients.size() <= 4) System.out.println("Kenny can’t bake brownies :(");
        }

        file.close();
    }

    private void recur(int r, int c, int s) {
        if(escaped) return;
        if(r<0||c<0||r>=mat.length||c>=mat[r].length) return;
        if(shadow[r][c]) return;
        shadow[r][c] = true;
        if(mat[r][c] == '.') {
            if(checkForAuth(r, c)) {
                mat[r][c] = '+';
                recur(r + 1, c, s + 1);
                recur(r - 1, c, s + 1);
                recur(r, c + 1, s + 1);
                recur(r, c - 1, s + 1);
                mat[r][c] = '.';
            }
        }
        if(mat[r][c] == 'O') {
            if(checkForAuth(r, c)) {
                if(ingredients.size() == 5) {
                    escaped = true;
                    return;
                };
            }
        }
        if(mat[r][c] == 'S') {
            if(ingredients.size() == 4) {
                ingredients.add('S');
                mat[r][c] = '+';
                recur(r + 1, c, s + 1);
                recur(r - 1, c, s + 1);
                recur(r, c + 1, s + 1);
                recur(r, c - 1, s + 1);
                mat[r][c] = '.';
            } else {
                mat[r][c] = '+';
                recur(r + 1, c, s + 1);
                recur(r - 1, c, s + 1);
                recur(r, c + 1, s + 1);
                recur(r, c - 1, s + 1);
                mat[r][c] = '.';
            }

        }
        if("BFCE".indexOf(mat[r][c]) > -1) {
            ingredients.add(mat[r][c]);
            if(ingredients.size() == 4) {
                for(boolean[] x : shadow) {
                    Arrays.fill(x, false);
                }
                for(int i = 0;i<mat.length;i++) {
                    for(int j = 0;j<mat[i].length;j++) {
                        mat[i][j] = cloned[i][j];
                    }
                }
                recur(SX, SY, 0);
                if(!escaped) {
                    ingredients.add('A');
                    return;
                }
            }
            mat[r][c] = '+';
            recur(r + 1, c, s + 1);
            recur(r - 1, c, s + 1);
            recur(r, c + 1, s + 1);
            recur(r, c - 1, s + 1);
            mat[r][c] = '.';
        }
    }

    private boolean checkForAuth(int r, int c) {
        if(!ingredients.contains('S')) return true;

        int[] dx = {1, -1, 0, 0, -1, +1, -1, +1};
        int[] dy = {0, 0, 1, -1, -1, +1, +1, -1};
        for(int i = 0;i<4;i++) {
            try {
                if(mat[r+dx[i]][c+dy[i]] == 'A') return false;
            } catch(Exception e) {}
        }
        return true;

    }
}