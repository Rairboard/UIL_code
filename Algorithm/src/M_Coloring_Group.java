import java.util.*;
import java.io.*;
public class M_Coloring_Group {
    /*
    The general overview of M coloring group is that if we can divide a graph into at most M groups such that no two vertices that original
    connected is connected in the new group

    Bipartite graph is a version of M coloring group where M = 2 meaning a graph is bipartite if we can divide the graph into 2 group where no
    two vertex is originally connected is now connected in the new group ( they could be in the same group but just can't connect to each other)

    Side nodes: the total number of configuration of graph coloring is M ^ V
    => M: # of color
    => V: # of vertices
    */
	public static void main(String[] args)throws Exception {
		new M_Coloring_Group().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("M_Coloring_Group.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int graph[][] = {
                    { 0, 1, 1, 1 },
                    { 1, 0, 1, 0 },
                    { 1, 1, 0, 1 },
                    { 1, 0, 1, 0 },
            };
            int n = graph.length;
            boolean[][]  connected = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(graph[i][j]==1) connected[i][j] = true;
                }
            }
            int m =3;
            int[] color =new int[n];
            boolean canColor = recur(m, 0, n, connected, color);
            System.out.println(canColor);
        }
        f.close();
	}
    /*
        The recur function takes in:
        => M: the maximum number of colors we can use
        => cur: our current vertex
        => numVertices: the number of vertices there are in the graph
        => connected: our graph represented as a boolean matrix
        => color: array to store the color each vertex was assigned (0 is unassigned and any value between 1 to M represent a color)
    */
    public boolean recur(int M , int cur, int numVertices, boolean[][] connected, int[] color){
        //  we first check if we have assigned all vertex then we simply return true
        if(cur == numVertices){
            return true;
        }
        // then we check for every color we could use represented as 1 to M
        for(int c = 1; c <= M;c++){

            // then we check if there are any adjacent vertex that have already been assigned to the current color c
            boolean canColor = true;
            for (int i = 0; i < numVertices; i++) {
                if(connected[cur][i] && color[i]== c){
                    canColor = false;
                    break;
                }
            }

            // if there is none then we can proceed to color the current vertex with color c
            if(canColor){

                // we assigned color c to the current vertex
                color[cur] = c;

                /*
                    then we recursively proceed to the next vertex
                =>  if the recursive method returns true that means we found a valid coloring configurations for all vertices then we can return true
                =>  if the recursive method return false that means using the color c will prevent coloring the rest of the vertices
                */
                if (recur(M, cur + 1, numVertices, connected, color)) {
                    return true;
                }

                /*
                    this point is only reachable when the above if is false meaning we can't use color c so we have to reset the color for our current
                    vertex and try a new color
                */
                color[cur] = 0;
            }
        }
        /*
        this point is reachable when we fail even when using all colors from 1 to M so that means we have to return false to signify to previous recursive
        call that there is no way to color the current vertex another color is needed for previous vertices
        */
        return false;
    }
}
