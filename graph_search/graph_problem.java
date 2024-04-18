package graph_search;

import java.util.*;

public class graph_problem {
    int[][] neighbors = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    int count = 0;
    int max  = 0;
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
            if(nexty>=0 && nextx>=0 && nextx < a.length && nexty < a[0].length && visited[nextx][nexty] == 0 & a[nextx][nexty] == 1) {
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
            if(nexty>=0 && nextx>=0 && nextx < a.length && nexty < a[0].length && visited[nextx][nexty] == 0 & a[nextx][nexty] == 1){
                q.add(nextx);
                q.add(nexty);
            }
        }
        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            if(visited[x][y] == 0) {
                dfs(a, x, y);
            }
        }
    }


    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] next = sc.nextLine().split(" ");
            if(next[0].isEmpty()){
                break;
            }
            List<String> line = new ArrayList<>(Arrays.asList(next));
            input.add(line);
        }
        int[][] a = new int[input.size()][input.getFirst().size()];
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).size(); j++) {
                a[i][j] = Integer.parseInt(input.get(i).get(j));
            }
        }
        graph_problem g = new graph_problem();
        g.countMaxIsland(a);
        System.out.printf(String.valueOf(g.max));
    }


}
