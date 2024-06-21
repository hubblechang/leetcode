package interview20240617;

import java.util.HashMap;

public class Main {
    public static HashMap<Character, Integer> NUMS = new HashMap<>();
    static {
        NUMS.put('零', 0);
        NUMS.put('一', 1);NUMS.put('二', 2);NUMS.put('三', 3);
        NUMS.put('四', 4);NUMS.put('五', 5);NUMS.put('六', 6);
        NUMS.put('七', 7);NUMS.put('八', 8);NUMS.put('九', 9);
    }

    public static HashMap<Character, Integer> NORMAL = new HashMap<>();
    static {
        NORMAL.put('千', 1000);
        NORMAL.put('百', 100);
        NORMAL.put('十', 10);
    }

    public static HashMap<Character, Integer> SPECIAL = new HashMap<>();
    static {
        SPECIAL.put('万', 10000);
        SPECIAL.put('亿', 100000000);
    }


    public static int trans(String s){
        int count = 0;
        int i=0, j=0;
        while (i < s.length()){
            int unit = 0;
            while (j < s.length()){
                int cur = 0;
                if(NUMS.getOrDefault(s.charAt(j), -1) != -1){
                    cur = NUMS.get(s.charAt(j));
                    j++;
                }
                if(j>=s.length()){
                    unit += cur;
                    break;
                }else if(NORMAL.getOrDefault(s.charAt(j), -1) != -1){
                    cur *= NORMAL.get(s.charAt(j));
                    unit += cur;
                    j++;
                } else if (SPECIAL.getOrDefault(s.charAt(j), -1) != -1) {
                    unit += cur;
                    unit *= SPECIAL.get(s.charAt(j));
                    j++;
                    i = j;
                    break;
                }
            }
            count += unit;
            i = j;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(trans("一千九百一十一万七千二百八十一"));
        trans("一百零一万九千一百一十");
        
    }
}
