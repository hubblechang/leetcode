package practice20240615;

public class ThreadCycle extends Thread {
    public static int ThreadNum = 3;

    public static volatile Object Lock = new Object();
    public static volatile Integer start = 0;
    public static final Integer end = 100;

    public int index;

    ThreadCycle(int index){
        this.index = index;
    }

    @Override
    public void run(){
        while (start < end){
            synchronized (Lock){
                while (start%ThreadNum != index){
                    try {
                        Lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(start < end){
                    System.out.printf("Thread%d,打印结果：%d\n", index, start++);
                }
                Lock.notifyAll();

            }
        }
    }

    public static void merge_sort(int[] arr){
        merge_sort(arr, 0, arr.length-1);
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if(left < right){
            int mid = (left + right) / 2;
            merge_sort(arr, left, mid);
            merge_sort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] left_arr = new int[mid - left + 1];
        int[] right_arr = new int[right - mid];
        for (int i = left; i < mid + 1; i++) {
            left_arr[i - left] = arr[i];
        }
        for (int i = mid + 1; i < right+1; i++) {
            right_arr[i - mid - 1] = arr[i];
        }
        int i =0, j=0, k=0;
        while (i < left_arr.length && j < right_arr.length){
            if(left_arr[i] <= right_arr[j]){
                arr[left + k] = left_arr[i];
                i++;
            }else {
                arr[left + k] = right_arr[j];
                j++;
            }
            k++;
        }
        if(i < left_arr.length){
            while (i < left_arr.length){
                arr[left + k] = left_arr[i];
                i++;
                k++;
            }
        }
        if(j < right_arr.length){
            while (j < right_arr.length){
                arr[left + k] = right_arr[j];
                j++;
                k++;
            }
        }
    }

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }


    public static int[] merge(int[] a, int[] b){
        int[] m = new int[a.length+b.length];
        int i=0, j=0, k=0;
        while (i<a.length && j<b.length){
            if(a[i] <= b[j]){
                m[k] = a[i];
                i++;
            }else {
                m[k] = b[j];
                j++;
            }
            k++;
        }
        if(i < a.length){
            while (i < a.length){
                m[k] = a[i];
                i++;
                k++;
            }
        }
        if(j < b.length){
            while (j < b.length){
                m[k] = b[j];
                j++;
                k++;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        for (int i = 0; i < ThreadNum; i++) {
            ThreadCycle t = new ThreadCycle(i);
            t.start();
        }
        merge(new int[]{1,2,3,4,5}, new int[]{1,3,5,7,9});
        int[] arr = new int[]{8,9,4,5,7,6,1,3,2};
        merge_sort(arr);
        System.out.println(arr);

    }
}
