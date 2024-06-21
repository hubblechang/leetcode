package interview20240620;

import java.util.Scanner;

public class Main3 {
    public static int[][] Stars;
    public static int[][] Matrix = new int[1001][1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Stars = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                Stars[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        int Query = sc.nextInt();
        int a, b;
        for (int i = 0; i < Query; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(Influenced(a, b));
            sc.nextLine();
        }
    }

    private static int Influenced(int a, int b) {
        int count = 0;
        for (int i = 0; i < Stars.length; i++) {
            if(Chebi(Stars[i][0],Stars[i][1],a,b) <= Stars[i][2]){
                count++;
            }
        }
        return count;
    }
    public static int Chebi(int x, int y, int a, int b) {
        return Math.max(Math.abs(x-a), Math.abs(y-b));
    }
}
