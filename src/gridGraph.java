import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class gridGraph {
    int[][] grid;
    boolean[][] visited;
    int[][] parent;
    int[][] distance;
    int[][] color;
    int[][] discoveryTime;
    int[][] finishTime;


    public gridGraph(int[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
    }

    public void fillVisited() {
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    public void printVisited() {
        for (int i = 0; i < visited.length; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
    }

    public void DFS(int a, int b) {
        fillVisited();
        DFSVisit8Direction(a, b);

    }

    public void DFSVisit8Direction(int a, int b) {
        if (grid[a][b] == 0) {
            return;
        }
        visited[a][b] = true;
        for (int i = a - 1; i <= a + 1; i++) {
            for (int j = b - 1; j <= b + 1; j++) {
                if ((i == a && j == b) || i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                } else if (!visited[i][j] && grid[i][j] == 1) {
                    DFSVisit8Direction(i, j);
                }

            }
        }
    }

    public void BFS8Direction(int a, int b) {
        visited = new boolean[grid.length][grid[0].length];
        Queue<Integer[]> queue = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            Integer[] u = queue.poll();
            for (int i = u[0] - 1; i < u[0] + 1; i++) {
                for (int j = u[1] - 1; j < u[1] + 1; j++) {
                    if ((i == u[0] && j == u[1]) || i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                        continue;
                    }
                    if (!visited[i][j] && grid[i][j] == 1) {
                        visited[i][j] = true;
                        queue.add(new Integer[]{i, j});
                    }
                }
            }
        }
    }

    public int numOfIslands() {
        int count = 0;
        fillVisited();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    DFSVisit8Direction(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public int UnitAreaOfLargestOfIslands() {
        int max = 0;
        int temp = 0;
        fillVisited();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    DFSVisit8Direction(i, j);
                    int areaVisited = 0;
                    for (int k = 0; k < visited.length; k++) {
                        for (int l = 0; l < visited[0].length; l++) {
                            if (visited[k][l]) {
                                areaVisited++;
                            }
                        }
                    }
                    temp = areaVisited - temp;
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }


}
