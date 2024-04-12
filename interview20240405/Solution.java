package interview20240405;

import java.util.*;


public class Solution {
    int count = 0;

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)){
                j = next[j - 1];
                count++;
            }
            if (needle.charAt(j) == haystack.charAt(i)){
                j++;
                count++;
            }
            if (j == needle.length()){
                return i - needle.length() + 1;
            }
        }
        return -1;

    }

    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.strStr("abaabaabcabaabcabbaaabb", "abaabc");
        int[] a = {1,2,3,4,5};
        System.out.println(s.count);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请录入一个整数");
//        int j = scanner.nextInt();
//        System.out.println(j);
//        scanner = new Scanner(System.in); //重写创建一个对象
//        System.out.println("请随便输入一段字符串");
//        //录入字符串
//        String s = scanner.nextLine();
//        System.out.println(s);
//
//        int ARRAYLENGTH = 8;  //指定数组长度
//        int a[] = new int[ARRAYLENGTH];
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入数组，并以回车结束：");
//        for(int i = 0; i < a.length; i++){
//            a[i] = sc.nextInt();
//        }
//        //直接打印数组a出来的是数组的首地址，必须用toString方法
//        System.out.println("数组a为:" + Arrays.toString(a));
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int sum = 0;
//            String[] m  = sc.nextLine().split(" ");
//            for(String c: m){
//                sum += Integer.parseInt(c);
//            }
//            System.out.println(sum);
//        }
//        System.out.println("next");
//        while(sc.hasNext()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println(a+b);
//        }
    }

}
