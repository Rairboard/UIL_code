import java.io.*;
import java.util.*;

public class susbrownie_JaredAllen {
    private char[][] mat;
    private int[][] shadow;
    private boolean solved;
    private boolean cuaght;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("susbrownie.dat"));
        int testCases = f.nextInt();
        for (int asdf = 0; asdf < testCases; asdf++) {
            int rows=f.nextInt(); int cols=f.nextInt();
            mat= new char[rows][cols]; shadow=new int[rows][cols];
            f.nextLine(); int sx=0; int sy=0;
            for (int i = 0; i < rows; i++) {
                String sline=f.nextLine().trim();
                if(sline.contains("K")){
                    sx=i; sy=sline.indexOf("K");
                }
                mat[i]=sline.toCharArray();
            }
            char[] todo={'E','F','C','B'};
            solved=true; boolean check=true;
            for(char x: todo) {
                solved = false;
                for (int i = 0; i < rows; i++) Arrays.fill(shadow[i], Integer.MAX_VALUE);
                recur(sx, sy, x, 0);
                if (!solved) check=false;
            }
            solved=false;
            for (int i = 0; i < rows; i++) Arrays.fill(shadow[i], Integer.MAX_VALUE);
            recur(sx,sy,'S',0);
            if(solved&&check){
                mat[sx][sy]='.';
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[i].length; j++) {
                        if(mat[i][j]=='S'){
                            sx=i; sy=j;
                        }
                        if(mat[i][j]=='A'){
                            del(i,j);
                        }
                    }
                }
                for (int i = 0; i < rows; i++) Arrays.fill(shadow[i], Integer.MAX_VALUE);
                solved=false; cuaght=false;
                recur(sx,sy,'O',0);
                if(solved){
                    System.out.println("Kenny was able to bake brownies in complete secrecy!");
                }
                else if(cuaght){
                    System.out.println("Kenny got caught by the police...");
                }
                else{
                    System.out.println("Kenny can’t bake brownies :(");
                }
            }
            else{
                System.out.println("Kenny can’t bake brownies :(");
            }


        }

    }
    public void recur(int r, int c, char look, int trav){
        if(r>-1&&r<mat.length&&c>-1&&c<mat[r].length&&mat[r][c]!='#'&&mat[r][c]!='A'&&mat[r][c]!='+'&&shadow[r][c]>trav){
            if(look!='O'&&mat[r][c]=='O') return;
            shadow[r][c]=trav; char sto=mat[r][c]; mat[r][c]='+';
            if(sto==look){
                solved=true;
                mat[r][c]=sto;
            }
            else{
                if(sto!='1'){
                    recur(r-1,c,look,trav+1);
                    recur(r+1,c,look,trav+1);
                    recur(r,c-1,look,trav+1);
                    recur(r,c+1,look,trav+1);
                    mat[r][c]=sto;
                }
                else{
                    cuaght=true;
                    mat[r][c]=sto;
                }
            }
        }
    }
    public void del(int r, int c){
        if(r>-1&&r<mat.length&&c>-1&&c<mat[r].length){
            if(mat[r][c]=='A'){
                mat[r][c]='1';
                del(r-1,c+1);
                del(r-1,c-1);
                del(r-1,c);
                del(r+1,c+1);
                del(r+1,c-1);
                del(r+1,c);
                del(r,c+1);
                del(r,c-1);
            }
            mat[r][c]='1';
        }
    }

    public static void main(String[] args) throws Exception {
        susbrownie_JaredAllen a = new susbrownie_JaredAllen();
        a.run();
    }
}
