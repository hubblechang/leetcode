package practice20240411;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void mergeSort(int[] a){
        if(a == null || a.length==1){
            return;
        }
        mergeSort(a, 0, a.length-1);
    }

    private static void mergeSort(int[] a, int low, int high) {
        int mid = (high-low)/2 + low;
        if(low < high){
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];
        for (int i = low; i <= mid; i++) {
            left[i - low] = a[i];
        }
        for (int i = mid + 1; i <= high; i++) {
            right[i -mid -1] = a[i];
        }
        int i = 0, j = 0;
        int index = low;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                a[index++] = left[i];
                i++;
            }else {
                a[index++] = right[j];
                j++;
            }
        }
        while(i<left.length){
            a[index++] = left[i];
            i++;
        }
        while(j<right.length){
            a[index++] = right[j];
            j++;
        }

    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String a = sc.nextLine();
        String[] nums = a.split(" ");
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = Integer.parseInt(nums[i]);
        }
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
