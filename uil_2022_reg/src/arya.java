import java.util.*;
import java.io.*;
class arya{
    int[] ar;
    public static void main(String[] args) throws FileNotFoundException {
        new arya().run();
    }
    public void run () throws FileNotFoundException {
        // Scanner f = new Scanner(System.in);
        Scanner f = new Scanner(new File("arya.dat"));
        int t = f.nextInt();
        while(t-->0){
            int N = f.nextInt(), r = f.nextInt();
            ar = new int[N];
            for(int i=0;i<N;i++){
                ar[i] = i + 1;
            }
            int low = 0, high = N-1, mid = (low + high)/2;
            while(low <= high){
                System.out.println(ar[low] + "-" + ar[mid] + "-" + ar[high]);
                if(ar[mid] == r){
                    System.out.println("GOT IT!!!");
                    break;
                }
                else if(ar[mid] < r){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
                mid = (low+high)/2;
            }
        }
    }
}
