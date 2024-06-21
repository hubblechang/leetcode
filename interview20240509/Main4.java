package interview20240509;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            String tmp = sc.nextLine();
            String[] ab = tmp.split(" ");
            int n = Integer.parseInt(ab[0]);
            int m = Integer.parseInt(ab[1]);
            int[] areas = new int[n];
            for (int j = 0; j < n; j++) {
                areas[j] = Integer.parseInt(sc.nextLine());
            }
            int sum = findMax(areas, m);
            System.out.printf("%.3f\n", sum * 1.0 / m);
        }
    }

    private static int findMax(int[] areas, int m) {
        int max = 0;
        for (int i = 0; i < areas.length - m + 1; i++) {
            int tmp = 0;
            for (int j = i; j < i + m ; j++) {
                tmp += areas[j];
            }
            max = max >tmp?max:tmp;
        }
        return max;
    }
}
