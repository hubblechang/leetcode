package interview20240620;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main4 {
    public static int[][] Matrix = new int[1001][1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            Influenced(x,y,r);
            sc.nextLine();
        }
        int Query = sc.nextInt();
        int a, b;
        for (int i = 0; i < Query; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(Matrix[a+500][b+500]);
            sc.nextLine();
        }
    }

    private static void Influenced(int x, int y, int r) {
//        IntStream.range(Math.max(x + 500 - r, 0), Math.min(x + 500 + r, 1000)+1).parallel()
//                .forEach(i -> IntStream.range(Math.max(y + 500 - r, 0), Math.min(y + 500 + r, 1000)+1)
//                        .forEach(j -> Matrix[i][j]++));
        for (int i = Math.max(x + 500 - r, 0); i <= Math.min(x + 500 + r, 1000); i++) {
            for (int j = Math.max(y + 500 - r, 0); j <= Math.min(y + 500 + r, 1000); j++) {
                Matrix[i][j] ++;
            }
        }
    }
}
