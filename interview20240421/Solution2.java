package interview20240421;

import java.util.*;

public class Solution2 {
    public static int compare(String o1, String o2){
        int a = 0;
        int b = 0;
        for (int i = 0; i < o1.length(); i++) {
            if(o1.charAt(i) == '1'){
                a++;
            }
            if(o2.charAt(i) == '1'){
                b++;
            }
        }
        if(a > b){
            return -1;
        }else if(b > a){
            return 1;
        }else {
                    int a_con = 0;
                    int b_con = 0;
                    int idx = 0;
                    while (idx<o1.length()){
                        int count = 0;
                        if(o1.charAt(idx) == '0'){
                            idx ++;
                            continue;
                        }
                        while(idx <o1.length() && o1.charAt(idx) == '1'){
                            count++;
                            idx ++;
                        }
                        a_con = a_con > count ? a_con:count;
                    }

                    idx = 0;
                    while (idx<o2.length()){
                        int count = 0;
                        if(o2.charAt(idx) == '0'){
                            idx ++;
                            continue;
                        }
                        while(idx <o2.length() && o2.charAt(idx) == '1'){
                            count++;
                            idx ++;
                        }
                        b_con = b_con > count ? b_con:count;
                    }
                    if(a_con > b_con){
                        return -1;
                    } else if (a_con < b_con) {
                        return 1;
                    }else {
                        for (int i = 0; i < o1.length(); i++){
                            if(o1.charAt(i) == o2.charAt(i)){
                                continue;
                            }else {
                                return o2.charAt(i) - o1.charAt(i);
                            }
                        }
                        return 0;
                    }
        }

    }
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String mn = sc.nextLine();*/
        String mn = "4 5";
        String[] mns = mn.split(" ");
        int n = Integer.parseInt(mns[0]);
        int m = Integer.parseInt(mns[1]);
        /*String input = sc.nextLine();*/
        String input = "11100 00111 10111 01111";
        String[] p = input.split(" ");
       /* compare(p[2], p[3]);*/
        int[] res = new int[n];
        int[] ori = new int[n];
        for (int i = 0; i < ori.length; i++) {
            ori[i] = i+1;
        }
        for (int i = 0; i < n-1; i++) {
            int cur = i;
            for (int j = i+1; j < n; j++) {
                if(compare(p[cur], p[j]) > 0){
                    cur = j;
                }
            }
            String tmp = p[cur];
            p[cur] = p[i];
            p[i] = tmp;
            res[i] = cur+1;
        }
        System.out.println(res);

        PriorityQueue<Map.Entry<Integer, String>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                int a = 0;
                int b = 0;
                for (int i = 0; i < o1.getValue().length(); i++) {
                    if(o1.getValue().charAt(i) == '1'){
                        a++;
                    }
                    if(o2.getValue().charAt(i) == '1'){
                        b++;
                    }
                }
                if(a > b){
                    return -1;
                }else if(b > a){
                    return 1;
                }else {
                    int a_con = 0;
                    int b_con = 0;
                    int idx = 0;
                    while (idx<o1.getValue().length()){
                        int count = 0;
                        if(o1.getValue().charAt(idx) == '0'){
                            idx ++;
                            continue;
                        }
                        while(idx <o1.getValue().length() && o1.getValue().charAt(idx) == '1'){
                            count++;
                            idx ++;
                        }
                        a_con = a_con > count ? a_con:count;
                    }

                    idx = 0;
                    while (idx<o2.getValue().length()){
                        int count = 0;
                        if(o2.getValue().charAt(idx) == '0'){
                            idx ++;
                            continue;
                        }
                        while(idx <o2.getValue().length() && o2.getValue().charAt(idx) == '1'){
                            count++;
                            idx ++;
                        }
                        b_con = b_con > count ? b_con:count;
                    }
                    if(a_con > b_con){
                        return -1;
                    } else if (a_con < b_con) {
                        return 1;
                    }else {
                        for (int i = 0; i < o1.getValue().length(); i++){
                            if(o1.getValue().charAt(i) == o2.getValue().charAt(i)){
                                continue;
                            }else {
                                return o2.getValue().charAt(i) - o1.getValue().charAt(i);
                            }
                        }
                        return 0;
                    }
                }

            }
        });
        for (int i = 0; i < n; i++) {
            queue.add(Map.entry(i+1, p[i]));
        }

        for (int i = 0; i < n-1; i++) {
            Map.Entry<Integer, String> cur = queue.poll();
            System.out.print(cur.getKey().toString());
            System.out.print(" ");
        }
        Map.Entry<Integer, String> cur = queue.poll();
        System.out.print(cur.getKey().toString());
    }
}
