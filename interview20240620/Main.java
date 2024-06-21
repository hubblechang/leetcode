package interview20240620;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int[] a = new int[5];
//        int[] b = new int[5];
//        int[] c = new int[5];
//        int[] d = new int[5];
        int[][] matrix = new int[4][5];
        Scanner sc  = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            String input = sc.nextLine();
            String[] nums_string = input.split(" ");
            for (int j = 0; j < nums_string.length; j++) {
                matrix[i][j] = Integer.parseInt(nums_string[j]);
            }
        }
        int i = 0, j=0;
        while (i < 5 && j <5){
            if(matrix[3][j] <= matrix[0][i]){
                matrix[3][j] -= matrix[0][i];
                j++;
                if (j >= 5){
                    break;
                }
            }else {
                matrix[3][j] -= matrix[0][i];
            }
            if(matrix[1][i] <= matrix[2][j]){
                matrix[1][i] -= matrix[2][j];
                i++;
                if (i >= 5){
                    break;
                }
            }else {
                matrix[1][i] -= matrix[2][j];
            }
        }
        if(i < 5){
            System.out.println("win");
            System.out.println(5 - i);
        }else {
            System.out.println("lose");
            System.out.println(5 - j);
        }
    }
}
