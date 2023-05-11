public class TestMain {
    public static void main(String[] args) {

        UndirectedGraph g = new UndirectedGraph();
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        System.out.println("câu 1 đến câu 6 bao gồm hai đồ thị vô hướng và có hướng ");
        System.out.println("Graph: Undirected Graph");
        g.printGraph();

        System.out.println("clone graph");
        UndirectedGraph g1 = g.clone();
        System.out.println("Print cloned graph:");
        g1.printGraph();
        g.DFS(0);
        System.out.print("DFS:");
        for(int i = 0; i < g.visited.size(); i++) {
            System.out.print(g.visited.get(i) + " ");
        }
        System.out.println();
        System.out.print("BFS:");
        g.BFS(0);
        for(int i = 0; i < g.visited.size(); i++) {
            System.out.print(g.visited.get(i) + " ");
        }
        System.out.println();
        System.out.println("is cycle:"+g.isCycle());
        System.out.println("add edge: 3 <-> 0");
        g.addEdge(3, 0);
        System.out.println("is cycle:"+g.isCycle());
//        System.out.println("number of islands:"+g.numIslands());

        System.out.println("=====================================");
        DirectedGraph g2 = new DirectedGraph();
        g2.addDirectedEdge(0, 1);
        g2.addDirectedEdge(0, 4);
        g2.addDirectedEdge(1, 2);
        g2.addDirectedEdge(1, 3);

        System.out.println("Graph2: Directed Graph");
        g2.printGraph();
        g2.DFS(0);
        System.out.print("DFS:");
        for(int i = 0; i < g2.visited.size(); i++) {
            System.out.print(g2.visited.get(i) + " ");
        }
        System.out.println();
        System.out.print("BFS:");
        g2.BFS(0);
        for(int i = 0; i < g2.visited.size(); i++) {
            System.out.print(g2.visited.get(i) + " ");
        }
        System.out.println();
        System.out.println("is cycle:"+g2.isCycle());
        System.out.println("add edge: 3 -> 0");
        g2.addEdge(3, 0);
        System.out.println("is cycle:"+g2.isCycle());

        System.out.println("=====================================");
        System.out.println("Graph3: Grid Graph");
        int[][] grid= {{1,1,0,0,0},
                       {1,1,0,0,0},
                       {0,0,1,0,0},
                       {0,0,0,1,1}};
        gridGraph g3 = new gridGraph(grid);
        System.out.println("câu 7 và câu 8");
        System.out.println("number of islands:"+g3.numOfIslands());
        System.out.println("Unit Area of largest region of 1's:"+g3.UnitAreaOfLargestOfIslands());






    }
}
