package interview20240509;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        //double[] x = new double[];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextDouble();
            sc.nextLine();
        }

        int[] nums = new int[n];
        double[] dp = new double[n];
        for (int i = 0; i < m; i++) {
            dp[m-1] += x[i];
        }
        dp[m-1] /= m;
        nums[m-1] = m;
        if(m == n){
            System.out.printf("%.3f", dp[m-1]);
            return;
        }
        for (int i = m; i < n; i++) {
            double tmp1 = (dp[i-1] * nums[i-1] + x[i]) / (nums[i-1] +1);
            double tmp2 = (dp[i-1] * nums[i-1] - x[i - nums[i-1]] + x[i]) / nums[i-1];
            if(tmp1 > tmp2){
                dp[i] = tmp1;
                nums[i] = nums[i-1] +1;
            }else {
                dp[i] = tmp2;
                nums[i] = nums[i-1];
            }
        }
        double res = 0;
        for (int i = m; i < n; i++) {
            res = res>dp[i]?res:dp[i];
        }
        String a = "123";
        
        System.out.printf("%.3f", dp[m-1]);*/
    }
}
