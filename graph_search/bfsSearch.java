package graph_search;

import org.w3c.dom.ls.LSOutput;

public class bfsSearch {
    // DFS

    int[][] dir = {
        {0, 1}, //right
        {1, 0}, //down
        {0, -1}, //left
        {-1, 0} //up
    };
    boolean[][] visited;
    int count;
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    count = 0;
                    dfs(grid, i, j);
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }
    private void dfs(int[][] grid, int x, int y){
        if(visited[x][y] || grid[x][y] == 0)
            return;

        visited[x][y] = true;
        count++;

        for(int i = 0; i < 4; i++){
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if(nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                continue;
            dfs(grid, nextX, nextY);
        }
    }

    public static void main(String[] args) {
        bfsSearch s = new bfsSearch();
        int[][] a = new int[][]{{0,0,1,1},{0,0,1,1},{0,0,1,1},{0,0,1,1}};
        s.maxAreaOfIsland(a);
        int[][] b = new int[][]{};


    }
}
