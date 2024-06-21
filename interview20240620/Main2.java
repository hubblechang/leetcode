package interview20240620;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static long[][] Constructions;
    public static long Value = 0;
    public static long ValueSum = 0;

    public static long CantAfford(int[] visited, int index){
        long count = 0L;
        for (int j = 0; j < index; j++) {
            if(visited[j] == 0){
                count += Constructions[j][3];
            }
        }
        return count;
    }
    public static void DFS(int[] visited, long A, long B, long C, long V){
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 1){
                continue;
            }
            if(Constructions[i][0] > A){
                break;
            }
            if(Constructions[i][0] <= A && Constructions[i][1] <= B && Constructions[i][2] <= C){
                int[] _v = Arrays.copyOf(visited, visited.length);
                _v[i] = 1;
                long _A = A-Constructions[i][0];
                long _B = B-Constructions[i][1];
                long _C = C-Constructions[i][2];
                long _V = V + Constructions[i][3];
                Value = Math.max(_V, Value);
                if(Value + CantAfford(visited, i) > ValueSum){
                    continue;
                }
                if(_A <=0 || _B <=0 || _C <=0){
                    continue;
                }
                DFS(_v, _A, _B, _C, _V);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        sc.nextLine();
        Constructions = new long[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                Constructions[i][j] = sc.nextLong();
            }
            ValueSum += Constructions[i][3];
            sc.nextLine();
        }
        Arrays.sort(Constructions, ((o1, o2) -> Math.toIntExact(o1[0] - o2[0])));
        DFS(new int[n], A, B, C, 0);
        System.out.println(Value);
    }


}
