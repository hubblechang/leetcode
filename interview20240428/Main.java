package interview20240428;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        System.out.println(a*(a-1)+1);*/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        StringBuilder s_builder = new StringBuilder();
        for (int i = k-1; i < n; i++) {
            s_builder.append(s.charAt(i));
        }
        if((n-k+1)%2 == 1){
            for (int j = k-2; j >=0; j--) {
                s_builder.append(s.charAt(j));
            }
        }else {
            for (int j = 0; j < k-1; j++) {
                s_builder.append(s.charAt(j));
            }
        }
        System.out.println(s_builder.toString());
    }
}
