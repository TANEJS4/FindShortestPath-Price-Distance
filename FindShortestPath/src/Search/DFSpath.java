package Search;
import java.util.ArrayList;
import java.util.List;

import Helper.Stack;
import Helper.fillDigraph;


public class DFSpath {
	
    private boolean[] marked;  // marked[v] = true iff v is reachable from s
    private int[] edgeTo;      // edgeTo[v] = last edge on path from s to v
    private final int s;       // source vertex

    public DFSpath(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        validateVertex(s);
        dfs(G, s);
    }

    private void dfs(Digraph G, int v) { 
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }


    	
    
//    public static void main(String[] args) {
      public static List<Integer> pathway(){

        Digraph G = fillDigraph.fill(32);

   
        int s = 3 ; /**Integer.parseInt(args[1]);*/
        int v = 17 ; /**Integer.parseInt(args[1]);*/

        List<Integer> path = new ArrayList<Integer>();
        
        DFSpath dfs = new DFSpath(G, s);

        if (dfs.hasPathTo(v)) {
            System.out.print("DFS"+ s + " to " + v+":  ");
            for (int x : dfs.pathTo(v)) {
                if (x == s) System.out.print(x);
                else {
                	System.out.print("-" + x);
                	path.add(x);

                }
            }
            System.out.println();
        }

        else {
        	
            System.out.println(s + " to " + v + " not connected\n");
        }
        return path;
    }
      public static void main(String[] args) {
      	pathway();
      }

}