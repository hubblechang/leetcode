package interview20240509;

import java.util.Scanner;

public class Main2 {
    public static int length;
    public static int count = 0;

    public static void how(char[] a){
        if (length == 0){
            return;
        }
        int times = 0;
        int idx = 0;
        int long_idx = 0;
        while(idx < length){
            int _count = 1;
            int _idx = idx;
            while(idx+1 < length && a[_idx] == a[_idx+1]){
                _count ++;
                _idx ++;
            }
            if(times < _count){
                times = _count;
                long_idx = _idx +1-_count;
            }
            idx = _idx +1;
        }
        for (int i = long_idx; i < length - times; i++) {
            a[i] = a[i + times];
        }
        length -= times;
        count ++;
        how(a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        length = Integer.parseInt(sc.nextLine());
        String arr = sc.nextLine();
        char[] input = arr.toCharArray();
        how(input);
        System.out.println(count);
    }
}
