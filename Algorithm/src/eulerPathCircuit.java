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

public class eulerPathCircuit {
    public static void main(String[] args) throws Exception {

//        new eulerPathCircuit().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("eulerPathCircuit").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {

        }
        f.close();
    }
	/*
	In an undirected graph
	There exist an eulerian path if the number of vertices that has odd degree is:
	-> 0 (can start on any nodes)
	-> 2 (can only start on these two nodes / the node that has more outdegree is starting / the node that has more indegree is ending )
	There exist an eulerian circuit if the number of vertices that has odd degree is:
	-> 0 (can start on any nodes)
	*/
	public boolean undirectedHasEulerian(boolean[][] v){
		int oddDegree = 0;
		for (int i = 0; i < v.length; i++) {
			int degree = 0;
			for (int j = 0; j < v[i].length; j++) {
				if(v[i][j]) degree++;
			}
			if(degree%2==1) oddDegree++;
		}
		return oddDegree == 0 || oddDegree == 2;
	}
	/*
	In a directed graph
	There exist an eulerian path if:
	-> all node have same in and out degree
	-> one node has (outdegree - indegree == 1 | start ) and one node has (indegree - outdegree == 1 | end)
	and all other nodes has (indegree == outdegree)
	There exist an eulerian circuit if:
	-> all node have same in and out degree
	*/
	public boolean directedHasEulerian(boolean[][] v){
		int n = v.length;
		int[] in = new int[n];
		int[] out = new int[n];
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				if(v[i][j]){
					out[i]++;
					in[j]++;
				}
			}
		}
		int hasMoreIn = 0, hasMoreOut = 0;
		int sameDegree = 0;
		for (int i = 0; i < n; i++) {
			if(in[i] - out[i] == 0){
				sameDegree++;
			}
			if(in[i] - out[i] > 0){
				hasMoreIn++;
			}
			else if(out[i] - in[i] > 0){
				hasMoreOut++;
			}
		}
		return hasMoreIn == 1 && hasMoreOut == 1 || sameDegree == n;
	}
}
