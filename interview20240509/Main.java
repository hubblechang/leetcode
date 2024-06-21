package interview20240509;

import java.util.Scanner;

public class Main {
    public static int[][] res;

    public static int burgerPrice(int m){
        if(m > 5){
            return 5;
        }else {
            return 10-m;
        }
    }
    public static int[] solution(int n,int m){
        int cost = 0;
        int count = 0;
        while(n >= burgerPrice(m)){
            count ++;
            n -= burgerPrice(m);
            cost += burgerPrice(m);
            m = m>5?m-5:0;
        }
        return new int[]{count, cost};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int[][] cases = new int[num][2];
        res = new int[num][2];
        for (int i = 0; i < num; i++) {
            String tmp = sc.nextLine();
            String[] ab = tmp.split(" ");
            cases[i][0] = Integer.parseInt(ab[0]);
            cases[i][1] = Integer.parseInt(ab[1]);
        }
        for (int i = 0; i < num; i++) {
            int[] tmp = solution(cases[i][0], cases[i][1]);
            res[i][0] = tmp[0];
            res[i][1] = tmp[1];
        }
        for (int i = 0; i < num; i++) {
            System.out.printf("%d %d\n", res[i][0], res[i][1]);
        }
    }
}
