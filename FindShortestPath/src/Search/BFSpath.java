package Search;

import java.util.ArrayList;
import java.util.List;

import Helper.Queue;
import Helper.Stack;
import Helper.fillDigraph;
import Helper.lines;


public class BFSpath {
//    private static final int Integer.MAX_VALUE = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s->v path?
    private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
    private int[] distTo;      // distTo[v] = length of shortest s->v path


    public BFSpath(Digraph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Integer.MAX_VALUE;
        validateVertex(s);
        bfs(G, s);
    }

  


    private void bfs(Digraph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }




    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }


    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);

        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }



    public static List<Integer> pathway(){
//        public static void main(String[] args){

        List<Integer> path = new ArrayList<Integer>();

        Digraph Gp = fillDigraph.fill(32);

        int s = 3;
        int v = 17;
        BFSpath bfs = new BFSpath(Gp, s);

//        for (int v = 0; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                System.out.printf("BFS %d to %d (%d):  ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
                    if (x == s) {
                    	System.out.print(x);
//                    	path.add(x);
                    }
                    else {
                    	System.out.print("->" + x);
                    	path.add(x);
                    }
                }
                System.out.println();
            }

            else {
//                System.out.printf("%d to %d (-):  not connected\n", s, v);
            }

            return path;
  }
    public static void main(String[] args) {
    	pathway();
    }


}