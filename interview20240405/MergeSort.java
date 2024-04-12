package interview20240405;

public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid); // 对左侧子序列进行归并排序
            mergeSort(arr, mid + 1, right); // 对右侧子序列进行归并排序
            merge(arr, left, mid, right); // 合并两个有序子序列
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        // 创建临时数组来存放排序结果
        int[] L = new int[n1];
        int[] R = new int[n2];
        // 将数据拷贝到临时数组
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        // 合并两个有序子序列
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // 将剩余元素直接拷贝到排序数组
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
