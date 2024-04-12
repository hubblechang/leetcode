package practice20240411;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int[] a) {
        if(a == null || a.length==1){
            return;
        }
        quickSort(a, 0, a.length-1);
    }

    private static void quickSort(int[] a, int low , int high) {
        if(low < high){
            int part = partitiion(a, low, high);
            quickSort(a, low, part-1);
            quickSort(a, part+1, high);
        }
    }

    private static int partitiion(int[] a, int low, int high) {
        int benchmark = a[low];
        while(low<high){
            while(low < high && a[high] > benchmark){
                high--;
            }
            if(low<high){
                a[low] = a[high];
            }
            while (low < high && a[low] < benchmark){
                low++;
            }
            if(low<high){
                a[high] = a[low];
            }
        }
        a[low] = benchmark;
        return low;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String a = sc.nextLine();
        String[] nums = a.split(" ");
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = Integer.parseInt(nums[i]);
        }
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
