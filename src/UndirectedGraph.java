
import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Set;

public class UndirectedGraph {
    int V;
    ArrayList<Integer> visited;
    HashMap<Integer, ArrayList<Integer>> adj;
    HashMap<Integer, String> color;

    public UndirectedGraph(HashMap<Integer, ArrayList<Integer>> adj) {
        this.adj = adj;
    }

    public void addEdge(int u, int v) {
        addDirectedEdge(u, v);
        addDirectedEdge(v, u);
    }

    public void addDirectedEdge(int u, int v) {
        if (adj.containsKey(u)) {
            if (!adj.get(u).contains(v)) {
                adj.get(u).add(v);
            }
        } else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(v);
            adj.put(u, list);
        }
        if (!adj.containsKey(v)) {
            adj.put(v, new ArrayList<Integer>());
        }
    }

    public UndirectedGraph() {
        adj = new HashMap<Integer, ArrayList<Integer>>();
    }

    public void printGraph() {
        System.out.println("Print adjacency list:");
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + "->");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    public UndirectedGraph clone(){
        UndirectedGraph newGraph= new UndirectedGraph(adj);
        newGraph.color=this.color;
        return newGraph;
    }

    public void DFS(int s) {
        visited = new ArrayList<Integer>();
        DFSVisit(s);
    }

    public void DFSVisit(int s) {
        visited.add(s);
        for (int i = 0; i < adj.get(s).size(); i++) {
            if (!visited.contains(adj.get(s).get(i))) {
                DFSVisit(adj.get(s).get(i));
            }
        }

    }

    public void BFS(int s) {
        visited = new ArrayList<Integer>();
        ArrayList<Integer> queue = new ArrayList<Integer>();
        queue.add(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            int u = queue.remove(0);
            for (int i = 0; i < adj.get(u).size(); i++) {
                if (!visited.contains(adj.get(u).get(i))) {
                    visited.add(adj.get(u).get(i));
                    queue.add(adj.get(u).get(i));
                }
            }
        }


    }

    public boolean isCycle() {
        visited = new ArrayList<Integer>();
        Set<Integer> keySet = adj.keySet();
        for (Integer i : keySet) {
            if (!visited.contains(i)) {
                if (isCycleUtil(i, -1)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean isCycleUtil(int s, int parent) {
        visited.add(s);
        for (int j = 0; j < adj.get(s).size(); j++) {
            if (!visited.contains(adj.get(s).get(j))) {
                if (isCycleUtil(adj.get(s).get(j), s)) {
                    return true;
                }
            } else if (adj.get(s).get(j) != parent) {
                return true;
            }
        }
        return false;
    }

//    public int numIslands(){
//        visited = new ArrayList<Integer>();
//        int count=0;
//        Set<Integer> keySet = adj.keySet();
//        for (Integer i : keySet) {
//            if (!visited.contains(i)) {
//                count++;
//                DFSVisit(i);
//            }
//        }
//        return count;
//    }
//
//    public int UnitAreaOfLargestRegionOf1s(){
//        visited = new ArrayList<Integer>();
//        int max=0;
//        int count=0;
//        Set<Integer> keySet = adj.keySet();
//        for (Integer i : keySet) {
//            if (!visited.contains(i)) {
//                DFSVisit(i);
//                count=visited.size()-count;
//                if(count>max){
//                    max=count;
//                }
//            }
//        }
//        return max;
//    }

    public boolean isEulerCircuit(int s,int parent){
        visited.add(s);
        for (int j = 0; j < adj.get(s).size(); j++) {
            if (!visited.contains(adj.get(s).get(j))) {
                if (isCycleUtil(adj.get(s).get(j), s)) {
                    return true;
                }
            } else if (adj.get(s).get(j) != parent) {
                return true;
            }
        }
        visited.remove(s);
        return false;
    }



}
