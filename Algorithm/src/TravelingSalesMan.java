import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class TravelingSalesMan {
    int startingNode;
    public static void main(String[] args) throws Exception {
        new TravelingSalesMan().run();
    }

//    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("TravelingSalesMan").toLowerCase() + ".dat"));
//        //Scanner f = new Scanner(System.in);
//
//        //getting number of nodes
//        int n = f.nextInt();
//
//
//        // getting cost for each pair of nodes
//        long[][] cost = new long[n][n];
//        for (int i = 0; i < n; i++) {
//            int a = f.nextInt(), b = f.nextInt();
//            long c = f.nextLong();
//            cost[a][b] = cost[b][a] = c;
//        }
//
//        long[][] dp = new long[n][1<<n];
//        /* the size is defined as n x (1 << n) because we are using
//            binary representation of visited nodes so for the current
//            nodes you are on, there is 2^n visited state
//         */
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        long minCost = Long.MAX_VALUE;
//        /* we are assuming we can start on any arbitrary nodes in the graph
//        -> the graph must be a complete graph for this condition to be true
//         */
//        for (int i = 0; i < n; i++) {
//            startingNode = i;
//            /* we passed in i as our current node
//            visited is now 1 << i because we start on the ith node
//            n, dp, cost is passed in as needed information for
//            the rest of the computation
//             */
//            long c = recur(i, 1 << i, n, dp, cost);
//            minCost = Math.min(minCost, c);
//        }
//        out.println(minCost);
//        f.close();
//    }
//    public long recur(int cur, int visited, int n, long[][] dp, long[][] cost){
//        /* since visited nodes is represented in binary (1 - visited , 0 - unvisited)
//        -> Ex: 1111 would be base case for n = 4
//         */
//        if(visited == (1<<n)-1){
//            // we then simple return the cost to travel from cur nodes back to starting node
//            return cost[cur][startingNode];
//        }
//
//        /* here we check if we have already computed the best distance when we go from current state
//        of visited nodes to the current node
//         */
//        if(dp[cur][visited] != -1){
//            return dp[cur][visited];
//        }
//
//        /* otherwise we visit every other ith node that is connected to our current node that
//        haven't been visited
//         */
//        long min = Long.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//
//            /* if a node is visited its bit value will be 1 so during & operation if we have visited
//            the node the result will be 1
//            if we check for zero then that means the bit haven't been visited as the bit value is zero
//             */
//            if((visited & (1 << i)) == 0){
//                /* we then simply compute the distance it takes to visit the rest of the unvisited nodes
//                starting from the ith nodes + the distance to go from the current to the ith node
//                -> visited is set to visited | (1 << i) marking the ith node as visited
//                 */
//                min = Math.min(min, cost[cur][i] + recur(i, visited | (1 << i), n, dp, cost));
//            }
//        }
//        /* min represent the minimum distance it to visit all other unvisited nodes once starting from
//        the current node
//         */
//        return min;
//    }
    public void run() throws Exception{
        Scanner f = new Scanner(in);
        int n = f.nextInt();
        int m = f.nextInt();
        long[][] cost = new long[n][n];
        long[][] dp = new long[n][1 << n];
        for (int i = 0; i < m; i++) {
            int a = f.nextInt(), b = f.nextInt();
            cost[a][b] = cost[b][a] = f.nextLong();
        }
        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            startingNode = i;
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[j], -1);
            }
            minCost = Math.min(minCost, recur(i, 1 << i, n, dp, cost));
        }
        out.println(minCost);
    }
    public long recur(int cur, int visited, int n, long[][] dp, long[][] cost){
        if(visited < 0) return Long.MAX_VALUE;
        if(visited == (1 << n) - 1){
            return cost[cur][startingNode];
        }
        if(dp[cur][visited] != -1){
            return dp[cur][visited];
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if((visited & (1 << i)) == 0){
                min = Math.min(min, cost[cur][i] + recur(i, visited | (1 << i), n, dp, cost));
            }
        }
        return min;
    }
}
