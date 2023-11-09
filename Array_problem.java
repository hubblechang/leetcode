import javax.sound.midi.Soundbank;
import java.util.*;

public class Array_problem {

    static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        return getIntersection(set1, set2);
    }

    static int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();
        for (int num : set1) {
            if (set2.contains(num)) {
                intersectionSet.add(num);
            }
        }
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            intersection[index++] = num;
        }
        return intersection;
    }


    static int next_num(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n%10) * (n%10);
            n = n / 10;
        }
        return sum;
    }

    static boolean isHappy(int n) {
        Set<Integer> median = new HashSet<>();
        int cur_value = n;
        while(cur_value != 1 && !median.contains(cur_value)){
            median.add(cur_value);
            cur_value = next_num(cur_value);
        }
        return cur_value == 1;
    }


    static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> count = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            count.putIfAbsent(s.charAt(i), 0);
            count.replace(s.charAt(i), count.get(s.charAt(i)) + 1);
        }
        for(int i = 0; i<t.length(); i++){
            if(!count.containsKey(t.charAt(i))){
                return false;
            }
            count.replace(t.charAt(i), count.get(t.charAt(i)) -1);
            if(count.get(t.charAt(i)) < 0){
                return false;
            }
        }
        return true;
    }

    static int[] singleNumber(int[] nums) {
        Set<Integer> only_one = new HashSet<>();
        for(int x: nums){
            if(only_one.contains(x)){
                only_one.remove(x);
            }
            else{
                only_one.add(x);
            }
        }
        int[] one_time_array = new int[only_one.size()];
        int index = 0;
        for (Integer integer : only_one) {
            one_time_array[index] = integer;
            index ++;
        }
        return one_time_array;
    }


    static int minSubArrayLen(int target, int[] nums) {
        int min_length = 100001;
        int left_index = 0;
        int sum = 0;
        for(int idx = 0; idx < nums.length; idx++){
            sum += nums[idx];
            while(sum >= target){
                min_length = min_length > (idx - left_index + 1)? (idx - left_index + 1): min_length;
                sum -= nums[left_index];
                left_index ++;
            }
        }
        return min_length == 100001? 0: min_length;
    }

    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int idx = 0; idx<nums.length; idx++){
            if(map.containsKey(nums[idx])){
                return new int[] {map.get(nums[idx]), idx};
            }
            else{
                map.put(target - nums[idx], idx);
            }
        }
        return new int[] {0, 0};
    }

    static int lengthOfLongestSubstring(String s) {
        ArrayList<Character> substring_char = new ArrayList<>();
        int count = 0;
        for (int idx = 0; idx<s.length(); idx++){
            if(!substring_char.contains(s.charAt(idx))){
                substring_char.add(s.charAt(idx));
                count = count>substring_char.size()?count:substring_char.size();
            }
            else {
                while(substring_char.contains(s.charAt(idx))){
                    substring_char.remove(0);
                }
                substring_char.add(s.charAt(idx));
            }
        }
        return count;
    }


    static int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 1; 3 * i <= n; i++){
            sum += i * 3;
        }
        for (int i = 1; 5 * i <= n; i++){
            if( i % 3 != 0){
                sum += i * 5;
            }
        }
        for (int i = 1; 7 * i <= n; i++){
            if( i % 3 != 0 && i % 5 != 0){
                sum += i * 7;
            }
        }
        return sum;
    }


    static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int num : nums) {
            q.offer(num);
        }
        long ans = 0;
        for (int i = 0; i < k; ++i) {
            int x = q.poll();
            ans += x;
            q.offer((x + 2) / 3);
        }
        return ans;
    }

    static int[][] generateLoopMatrix(int n){
        int loop = 0;
        int[][] matrix = new int[n][n];
        int count = 1;
        int start = 0;
        int i,j;

        while(loop++ < n/2){
            for (i = start; i < n-loop; i++){
                matrix[start][i] = count++;
            }
            for(j = start; j< n-loop; j++){
                matrix[j][i] = count++;
            }
            for(; i >= loop; i--){
                matrix[j][i] = count++;
            }
            for(; j >= loop; j--){
                matrix[j][i] = count++;
            }
            start ++;
        }
        if(!(n%2==0)){
            matrix[start][start] = count;
        }
        return matrix;
    }

    static int[][] generateMatrix(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;

        while (loop++ < n / 2) { // 判断边界后，loop从1开始
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }
            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }
            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }
            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }
        if (n % 2 == 1) {
            res[start][start] = count;
        }
        return res;
    }


    static int combinatorial_number(int a, int k){
        int number = 1;
        k = k > a- k? a-k: k;
        for(int i = a; i > a-k; i--){
            number *= i;
        }
        for(int j = 1; j < k; j++){
            number /= j;
        }
        return number;
    }

    static int tupleSameProduct(int[] nums) {
        int combation = 0;
        int num_len  = nums.length;
        int[] dot = new int[num_len * (num_len-1)/2];
        int dot_idx = 0;
        for(int i = 0; i < num_len-1; i ++){
            for(int j = i +1 ; j< num_len; j ++){
                dot[dot_idx++] = nums[i] * nums[j];
            }
        }
        Map<Integer, Integer> value_count = new HashMap<>();
        for(int i = 0; i<dot_idx; i++){
            value_count.putIfAbsent(dot[i], 0);
            value_count.put(dot[i], value_count.get(dot[i]) + 1);
        }
        for(int x : value_count.values()){
            if (x > 1){
                combation += 8*combinatorial_number(x,2);
            }
        }
        return combation;
    }


    static List<List<Integer>> fourSum(int[] nums, int target) {
        int num_len = nums.length;
        List<List<Integer>> rse_list = new ArrayList<>();
        Set<Set<Integer>> res_set = new HashSet<>();
        for(int i = 0; i< num_len - 3; i++){
            for(int j = i +1; j< num_len - 2; j++){
                for(int k = j+1; k< num_len - 1; k++){
                    for(int m = k+1; m< num_len; m++){
                        if(nums[i] + nums[j] + nums[k] + nums[m] == target){
                            Set<Integer> tmp = new HashSet<>();
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.add(nums[k]);
                            tmp.add(nums[m]);
                            if(!res_set.contains(tmp)){
                                rse_list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[m]));
                            }
                            res_set.add(tmp);
                        }
                    }
                }
            }
        }
        return rse_list;
    }

    static String categorizeBox(int length, int width, int height, int mass) {
        boolean heav = false;
        boolean bulk = false;
        long volu = 1L * length*width*height;
        if(length>=10000 || width>=10000 || height>=10000 || volu>=1000000000){
            bulk = true;
        }
        if(mass>=100){
            heav = true;
        }
        if(heav){
            if(bulk){
                return new String("Both");
            }
            else {
                return new String("Heavy");
            }
        }
        else {
            if(bulk){
                return new String("Bulky");
            }
            else {
                return new String("Neither");
            }
        }

    }

    static int maxPower(String s) {
        int count = 1;
        int max = 0;
        Character cur = s.charAt(0);
        for(int idx = 1; idx< s.length(); idx++){
            if(s.charAt(idx) == cur){
                count ++;
            }
            else {
                max = max>count?max:count;
                count=1;
                cur = s.charAt(idx);
            }
        }
        max = max>count?max:count;
        return max;
    }

    static String reverseStr(String s, int k) {
        char[] res_char = new char[s.length()];
        int iter_len = s.length() /k * k;
        boolean flag = false;
        int idx = 0;
        for (; idx < iter_len; idx++){
            if(idx % k==0){
                flag = !flag;
            }
            if(flag){
                res_char[idx] = s.charAt(idx);
            }else {
                res_char[idx] = s.charAt(idx/k*k+k-(idx + 1 - idx/k*k));
            }
        }
        flag = !flag;
        if(flag){
            for(;idx<s.length();idx ++){
                res_char[idx] = s.charAt(idx);
            }
        }else {
            int end = s.length() -1;
            for(;idx<s.length();idx ++){
                res_char[idx] = s.charAt(end);
                end--;
            }
        }
        return new String(res_char);
    }

    static boolean canConstruct(String ransomNote, String magazine) {
        int[] count_note = new int[26];
        for(int idx = 0; idx < ransomNote.length(); idx ++){
            count_note[ransomNote.charAt(idx) - 'a'] ++;
        }
        for(int idx = 0; idx < magazine.length(); idx ++){
            count_note[magazine.charAt(idx) - 'a'] --;
        }
        for(int idx = 0; idx < count_note.length; idx ++){
            if(count_note[idx] > 0){
                return false;
            }
        }
        return true;
    }

    static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int height_cut = horizontalCuts.length;
        int width_cut = verticalCuts.length;
        int max_sub_height = 0;
        int max_sub_width = 0;
        int div = 1000000007;
//        int[] sub_height = new int[height_cut + 1];
//        int[] sub_width = new int[width_cut + 1];
        int cur = 0;
        for (int idx = 0; idx < height_cut + 1; idx++) {
            if(idx == 0){
                max_sub_height = horizontalCuts[idx];
            } else if (idx < height_cut) {
                cur = horizontalCuts[idx] - horizontalCuts[idx - 1];
                max_sub_height = max_sub_height>cur ? max_sub_height: cur;
            } else {
                cur = h - horizontalCuts[idx - 1];
                max_sub_height = max_sub_height>cur ? max_sub_height: cur;
            }
        }
        for (int idx = 0; idx < width_cut + 1; idx++) {
            if(idx == 0){
                max_sub_width = verticalCuts[idx];
            } else if (idx < width_cut) {
                cur = verticalCuts[idx] - verticalCuts[idx - 1];
                max_sub_width = max_sub_width>cur ? max_sub_width: cur;
            } else {
                cur = w - verticalCuts[idx - 1];
                max_sub_width = max_sub_width>cur ? max_sub_width: cur;
            }
        }
        return max_sub_width * max_sub_height % div;
    }


    static int[] dailyTemperatures(int[] temperatures) {
        /*int[] res = new int[temperatures.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, temperatures[0]);
        for (int idx = 1; idx < temperatures.length; idx++) {
            int cur_temp = temperatures[idx];
            List<Integer> rem = new ArrayList<>();
            for (Integer i: map.keySet()) {
                if(cur_temp > temperatures[i]){
                    res[i] = idx - i;
                    rem.add(i);
                }
            }
            for (Integer i:rem) {
                map.remove(i);
            }
            map.put(idx, temperatures[idx]);
        }
        return res;*/
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }


    static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            map.put(nums[idx], map.getOrDefault(nums[idx], 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair1[1]-pair2[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(pq.size()<k){
                pq.add(new int[]{entry.getKey(),entry.getValue()});
            }else{
                if(entry.getValue()>pq.peek()[1]){
                    pq.poll();
                    pq.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i] = pq.poll()[0];
        }
        return ans;

    }

    static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] sorted_spells = Arrays.copyOf(spells, spells.length);
        Arrays.sort(sorted_spells);
        HashMap<Integer, Integer> map = new HashMap<>();
        int[]  res = new int[spells.length];
        int cur_start = potions.length - 1;
        for (int idx = 0; idx < spells.length; idx++) {
            int p = cur_start;
            for(; p>=0 && (long) potions[p] * sorted_spells[idx] >= success; p--){}
            cur_start = p;
            map.put(sorted_spells[idx], potions.length - p - 1);
        }
        for (int idx = 0; idx < res.length; idx++) {
            res[idx] = map.get(spells[idx]);
        }
        return res;
    }

    class NumArray {
        int[] num_array;

        public NumArray(int[] nums) {
            num_array = Arrays.copyOf(nums, nums.length);
        }
        public void update(int index, int val) {
            num_array[index] = val;

        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for(int idx = left; idx <= right; idx++){
                sum += num_array[idx];
            }
            return sum;
        }
    }


    public static void main(String args[]){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        Set<Integer> set1 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        System.out.println(set1.contains(2));
        int happy_num = 19;
        boolean is_happy = isHappy(happy_num);
        System.out.println(is_happy);
        String s = new String("anagram");
        String t = new String("nagaram");
        boolean is_anagram = isAnagram(s, t);
        System.out.println(is_anagram);

        int[] nums = {1,2,1,3,2,5};
        int[] one_time = singleNumber(nums);
        for (int x: one_time){
            System.out.print(x);
            System.out.print('\t');
        }
        System.out.print('\n');

        int[] nums_min = {1,2,3,4,5};
        System.out.println(minSubArrayLen(11, nums_min));

        int[] nums_twosum = {2,7,11,15};
        int[] twosum_index = twoSum(nums_twosum, 9);
        for (int x: twosum_index) {
            System.out.println(x);
        }

        String get_substring = new String("qrsvbspk");
        System.out.println(lengthOfLongestSubstring(get_substring));

        int sum_multiples = 10;
        System.out.println(sumOfMultiples(sum_multiples));

        int[] max_sum_nums = new int[] {533854490,546147233,543352274,161843442,268635067};
        System.out.println(maxKelements(max_sum_nums, 3));

        int[] same_product = new int[] {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192};
        System.out.println(tupleSameProduct(same_product));

        System.out.println(categorizeBox(2909,3968,3272,727));

        System.out.println(maxPower(new String("aabbbbbccccdddddddeffffffggghhhhhiiiiijjjkkkkkllllmmmmmnnnnnoopppqrrrrsssttttuuuuvvvvwwwwwwwxxxxxyyyzzzzzzzz")));

        System.out.println(maxArea(5,4,new int[]{3,1}, new int[]{1}));

        System.out.println(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));

        successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16);
    }
}
