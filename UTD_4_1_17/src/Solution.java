import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
//        for(int i = 1; i <= 4;i++){
//            for(int j = 1;j<=4;j++){
//                System.out.println(i + " " + j);
//            }
//        }
        Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        for (int asdf = 0; asdf < n; asdf++) {
            long N = f.nextLong();
            int k = f.nextInt();
            Map<Long,Long> positive = new HashMap<>();
            Map<Long,Long> negative = new HashMap<>();
            for (int i = 0; i < k; i++) {
                long r = f.nextLong(), c = f.nextLong();
                positive.put(r+c,positive.getOrDefault(r+c,0L)+1);
                negative.put(r-c,negative.getOrDefault(r-c,0L)+1);
            }
            long maxPiece = 0;
            for(long id : positive.keySet()){
                if(Math.abs(id) <= N + 1){
                    long size = Math.abs(id) -1;
                    if(positive.get(id) <size){
                        maxPiece = Math.max(maxPiece, positive.get(id));
                    }
                }
                else{
                    long size = N - (Math.abs(N - id) - 1);
                    if(positive.get(id) < size){
                        maxPiece = Math.max(maxPiece, positive.get(id));
                    }
                }
            }
            for(long id : negative.keySet()){
                long size = N - Math.abs(id);
                if(negative.get(id) < size){
                    maxPiece = Math.max(maxPiece, negative.get(id));
                }
            }
            System.out.println(maxPiece);
        }
    }
}