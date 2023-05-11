import java.util.ArrayList;
import java.util.HashMap;

public class DirectedGraph extends UndirectedGraph {
//    private int V;
//    ArrayList<Integer> visited;
//    private HashMap<Integer, ArrayList<Integer>> adj;
//    private HashMap<Integer, String> color;
//
//    public UndirectedGraph(HashMap<Integer, ArrayList<Integer>> adj) {
//        this.adj = adj;
//    }


    public DirectedGraph(HashMap<Integer, ArrayList<Integer>> adj) {
        super(adj);
    }

    public DirectedGraph() {
    }

//    public void addDirectedEdge(int u, int v) {
//        if (adj.containsKey(u)) {
//            if (!adj.get(u).contains(v)) {
//                adj.get(u).add(v);
//            }
//        } else {
//            ArrayList<Integer> list = new ArrayList<Integer>();
//            list.add(v);
//            adj.put(u, list);
//        }
//        if(!adj.containsKey(v)) {
//            adj.put(v, new ArrayList<Integer>());
//        }
//    }
    //    public UndirectedGraph() {
//        adj = new HashMap<Integer, ArrayList<Integer>>();
//    }
    public void printGraph() {
        System.out.println("Print adjacency list:");
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).size() > 0) {
                System.out.print(i + "->");
                for (int j = 0; j < adj.get(i).size(); j++) {
                    System.out.print(adj.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
    public DirectedGraph clone(){
        DirectedGraph newGraph= new DirectedGraph(adj);
        newGraph.color=this.color;
        return newGraph;
    }


////
//    public void DFS(int s) {
//        visited = new ArrayList<Integer>();
//        DFSVisit(s);
//    }
//    public void DFSVisit(int s) {
//        visited.add(s);
//        for (int i = 0; i < adj.get(s).size(); i++) {
//            if (!visited.contains(adj.get(s).get(i))) {
//                DFSVisit(adj.get(s).get(i));
//            }
//        }
//
//    }
//    public void BFS(int s) {
//        visited = new ArrayList<Integer>();
//        ArrayList<Integer> queue = new ArrayList<Integer>();
//        queue.add(s);
//        visited.add(s);
//        while (!queue.isEmpty()) {
//            int u = queue.remove(0);
//            for (int i = 0; i < adj.get(u).size(); i++) {
//                if (!visited.contains(adj.get(u).get(i))) {
//                    visited.add(adj.get(u).get(i));
//                    queue.add(adj.get(u).get(i));
//                }
//            }
//        }
//
//
//
//
//    }

}

