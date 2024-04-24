import java.util.*;

class SmallestInfiniteSet {

    Set<Integer> deleted;
    Integer smallest;

    public SmallestInfiniteSet() {
        deleted = new HashSet<>();
        smallest = 1;
    }

    public int popSmallest() {
        int res = smallest;
        deleted.add(smallest);
        while(deleted.contains(smallest)){
            smallest ++;
        }
        return res;
    }

    public void addBack(int num) {
        if(deleted.contains(num)){
            deleted.remove(num);
        }
        if(num < smallest){
            smallest = num;
        }
    }
}

class Solution3 {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            Character tmp = word1.charAt(i);
            map1.putIfAbsent(tmp, 0);
            map1.put(tmp, map1.get(tmp)+1);

            tmp = word2.charAt(i);
            map2.putIfAbsent(tmp, 0);
            map2.put(tmp, map2.get(tmp)+1);
        }
        Set<Character> keys1 = map1.keySet();
        Set<Character> keys2 = map2.keySet();
        if (! keys1.equals(keys2)){
            return false;
        }

        ArrayList<Integer> values1 = new ArrayList<>(map1.values());
        ArrayList<Integer> values2 = new ArrayList<>(map2.values());
        Collections.sort(values1);
        Collections.sort(values2);

        boolean same = true;
        for (int i = 0; i < values1.size(); i++) {
            if(! values1.get(i).equals(values2.get(i))){
                same = false;
                break;
            }
        }
        return same;
    }

    public int minReorder_wrong(int n, int[][] connections) {
        List<Integer> reach = new ArrayList<>();
        int[] unused = new int[connections.length];
        int res = 0;
        while (reach.size() != n){
            for (int i = 0; i < unused.length; i++) {
                if(unused[i] == 1){
                    continue;
                }
                if(reach.contains(connections[i][1])){
                    unused[i] = 1;
                    reach.add(connections[i][0]);
                } else if (reach.contains(connections[i][0])) {
                    unused[i] = 1;
                    res += 1;
                    reach.add(connections[i][1]);
                }
            }
        }
        return res;
    }

    public int minReorder(int n, int[][] connections) {
        List<int[]>[] e = new List[n];
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<int[]>();
        }
        for (int[] edge : connections) {
            e[edge[0]].add(new int[]{edge[1], 1});
            e[edge[1]].add(new int[]{edge[0], 0});
        }
        return dfs(0, -1, e);
    }

    public int dfs(int x, int parent, List<int[]>[] e) {
        int res = 0;
        for (int[] edge : e[x]) {
            if (edge[0] == parent) {
                continue;
            }
            res += edge[1] + dfs(edge[0], x, e);
        }
        return res;
    }

    /**
     * No.2048
     */
    public int nextBeautifulNumber(int n) {
        for (int i = n+1; i <= 1224444; i++) {
            if(isBeautifulNumber(i)){
                return i;
            }
        }
        return -1;
    }

    public boolean isBeautifulNumber(int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        while (n > 0){
            int pos = n % 10;
            n /= 10;
            int fre = map.getOrDefault(pos, 0) + 1;
            if(fre > pos){
                return false;
            }
            map.put(pos, fre);
        }
        for (Integer i :
                map.keySet()) {
            if (! i.equals(map.get(i))) {
                return false;
            }
        }
        return true;
    }


    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= s.length()-3; i++) {
            if(s.length()-i > 9 || (i>1 && s.charAt(0) == '0')){
                continue;
            }
            int ip_0 = Integer.parseInt(s.substring(0, i));
            if(ip_0>255){
                break;
            }
            for (int j = i+1; j <= s.length()-2; j++) {
                if(s.length()-j > 6 || (j-i>1 && s.charAt(i) == '0')){
                    continue;
                }
                int ip_1 = Integer.parseInt(s.substring(i, j));
                if(ip_1>255){
                    break;
                }
                for (int k = j+1; k <= s.length()-1; k++) {
                    if(s.length()-k > 3 || (k-j>1 && s.charAt(j) == '0') || (s.length()-k>1 && s.charAt(k) == '0')){
                        continue;
                    }
                    int ip_2 = Integer.parseInt(s.substring(j, k));
                    int ip_3 = Integer.parseInt(s.substring(k, s.length()));
                    if(ip_2>255){
                        break;
                    }
                    if(ip_3>255){
                        continue;
                    }
                    res.add(Integer.toString(ip_0) + "." + Integer.toString(ip_1) + "." + Integer.toString(ip_2) + "." + Integer.toString(ip_3));
                }
            }
        }
        return res;

    }

    public static String split_string(String s, int n){
        char[] new_s = new char[s.length()%n==0?s.length()+(s.length()/n-1):s.length()+(s.length()/n+(n-s.length()%n))];
        Queue<Character> queue = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)-'a'>26 || s.charAt(i)-'a'<0){
                return new String("ERROR");
            }
            queue.add(s.charAt(i));
        }
        for (int i = 0; i < new_s.length; i++) {
            new_s[i] = '0';
        }
        for (int i = 0; i < new_s.length; i++) {

            if ((i+1)%(n+1) == 0){
                new_s[i] = ',';
            }else {
                if(queue.isEmpty()){
                    break;
                }
                new_s[i] = queue.poll();
            }
        }
        return new_s.toString();
    }


//    public static int countWays(int[][] ranges) {
//        Arrays.sort;
//
//    }
    public static void map_queue(){
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());
        PriorityQueue<int[]> Queue = new PriorityQueue<>(
                (e1, e2) -> e2[1] - e1[1]);
        for (int i = 0; i < 5; i++) {
            priorityQueue.add(Map.entry(i,6-i));
            Queue.add(new int[]{i, 6-i});
        }
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll().getValue());
            System.out.println(Queue.poll()[1]);
        }

    }


}

public class Daily_problem {
    public static void main(String args[]){
        SmallestInfiniteSet test = new SmallestInfiniteSet();
        test.popSmallest();
        test.addBack(1);
        test.popSmallest();
        test.popSmallest();
        test.popSmallest();
        test.addBack(2);
        test.addBack(3);
        test.popSmallest();
        test.popSmallest();

        Solution3 s = new Solution3();
        s.closeStrings(new String("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"), new String("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"));
        s.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}});
        System.out.println(s.isBeautifulNumber(231332));

        System.out.println(Solution3.restoreIpAddresses("99999999999"));
        Solution3.split_string(new String("yuytrewert0"), 4);
        Solution3.map_queue();
    }
}
