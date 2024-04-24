package graph_search;

import java.util.*;

public class graph_problem {
    int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int count = 0;
    int max = 0;
    int[][] visited;

    public void countMaxIsland(int[][] a) {
        visited = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (visited[i][j] == 1 || a[i][j] == 0) {
                    continue;
                }
                count = 0;
                dfs(a, i, j);
                max = max > count ? max : count;
            }
        }
    }

    public void bfs(int[][] a, int i, int j) {
        count++;
        visited[i][j] = 1;
        for (int k = 0; k < neighbors.length; k++) {
            int nextx = i + neighbors[k][0];
            int nexty = j + neighbors[k][1];
            if (nexty >= 0 && nextx >= 0 && nextx < a.length && nexty < a[0].length && visited[nextx][nexty] == 0 & a[nextx][nexty] == 1) {
                bfs(a, nextx, nexty);
            }
        }
    }

    public void dfs(int[][] a, int i, int j) {
        visited[i][j] = 1;
        count++;
        Queue<Integer> q = new LinkedList<>();
        for (int k = 0; k < neighbors.length; k++) {
            int nextx = i + neighbors[k][0];
            int nexty = j + neighbors[k][1];
            if (nexty >= 0 && nextx >= 0 && nextx < a.length && nexty < a[0].length && visited[nextx][nexty] == 0 & a[nextx][nexty] == 1) {
                q.add(nextx);
                q.add(nexty);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            if (visited[x][y] == 0) {
                dfs(a, x, y);
            }
        }
    }


    int en_count = 0;

    public int numEn_bfs(int[][] grid, int i, int j) {
        boolean flag = false;
        Queue<Integer> q = new LinkedList<>();
        en_visited[i][j] = 1;
        q.add(i);
        q.add(j);
        count++;
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int k = 0; k < neighbors.length; k++) {
                int xx = x + neighbors[k][0];
                int yy = y + neighbors[k][1];
                if (xx >= 0 && yy >= 0
                        && xx < grid.length && yy < grid[0].length
                        && en_visited[xx][yy] == 0 && grid[xx][yy] == 1) {
                    if (xx == 0 || yy == 0 || xx == grid.length - 1 || yy == grid[0].length - 1) {
                        flag = true;
                    }
                    q.add(xx);
                    q.add(yy);
                    en_visited[xx][yy] = 1;
                    en_count++;
                }
            }
        }
        if (flag) {
            return 0;
        }
        return en_count;
    }

    int[][] en_visited;

    public int numEnclaves(int[][] grid) {
        en_visited = new int[grid.length][grid[0].length];
        int COUNT = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (en_visited[i][j] == 0 && grid[i][j] == 1) {
                    en_count = 0;
                    COUNT += numEn_bfs(grid, i, j);
                }
            }
        }
        return COUNT;
    }



    public static void main(String[] args) {
//        List<List<String>> input = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()){
//            String[] next = sc.nextLine().split(" ");
//            if(next[0].isEmpty()){
//                break;
//            }
//            List<String> line = new ArrayList<>(Arrays.asList(next));
//            input.add(line);
//        }
//        int[][] a = new int[input.size()][input.get(0).size()];
//        for (int i = 0; i < input.size(); i++) {
//            for (int j = 0; j < input.get(i).size(); j++) {
//                a[i][j] = Integer.parseInt(input.get(i).get(j));
//            }
//        }
        graph_problem g = new graph_problem();
//        g.countMaxIsland(a);
//        System.out.printf(String.valueOf(g.max));

        System.out.println(g.numEnclaves(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}));

    }


}
