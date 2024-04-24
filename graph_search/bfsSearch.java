package graph_search;

import java.util.LinkedList;
import java.util.Queue;

public class bfsSearch {
    int[][] dir = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    int count;
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    count = 0;
                    bfs(grid, i, j);
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }
    private void bfs(int[][] grid, int x, int y){
        Queue<Integer> que = new LinkedList<>();
        que.offer(x);
        que.offer(y);
        visited[x][y] = true;
        count++;

        while(!que.isEmpty()){
            int currX = que.poll();
            int currY = que.poll();

            for(int i = 0; i < 4; i++){
                int nextX = currX + dir[i][0];
                int nextY = currY + dir[i][1];

                if(nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                    continue;
                if(!visited[nextX][nextY] && grid[nextX][nextY] == 1){
                    que.offer(nextX);
                    que.offer(nextY);
                    visited[nextX][nextY] = true;
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        bfsSearch s = new bfsSearch();
        int[][] a = new int[][]{{0,0,1,1},{0,0,1,1},{0,0,1,1},{0,0,1,1}};
        s.maxAreaOfIsland(a);
        int[][] b = new int[][]{};

    }
}
