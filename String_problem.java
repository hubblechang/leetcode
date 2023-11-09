import java.util.*;
public class String_problem {


    static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = s[left];
            left ++;
            right --;
        }
    }

    static String pathEncryption(String path) {
        char[] res = new char[path.length()];
        for(int idx = 0; idx<path.length(); idx++){
            if(path.charAt(idx) == '.'){
                res[idx] = ' ';
                continue;
            }
            res[idx] = path.charAt(idx);
        }
        return new String(res);
    }

    static String reverseWords(String s) {
//        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int start, end;
        int idx = 0;
        int val_num = 0;
        int val_length = 0;
        while(idx < s.length()){
            if(s.charAt(idx) == ' '){
                idx++;
            }
            else {
                // left closed, right open
                start = idx;
                end = idx;
                while(s.charAt(end) != ' ' && end < s.length()){
                    end ++;
                    val_length ++;
                }
                val_num ++;
                stack.push(start);
//                map.put(start, end);
                idx = end;
            }
        }
        idx = 0;
        int tmp;
        char[] res = new char[val_num + val_length - 1];
        while(!stack.empty()){
            for(tmp = stack.pop(); s.charAt(tmp)!=' '&& tmp < s.length(); tmp ++){
                res[idx] = s.charAt(tmp);
                idx ++;
            }
            if(!(idx == res.length)){
                res[idx] = ' ';
                idx ++;
            }

        }
        return new String(res);
    }

    static String dynamicPassword(String password, int target) {
        char[] a = password.toCharArray();
        int len = a.length;
        String res = new String();
        for (int idx = target; idx < len + target; idx++) {
            res += a[idx % len];
        }
        return res;
    }

    static int strStr(String haystack, String needle) {
        int idx = 0;
        while(idx < haystack.length() - needle.length() + 1){
            if(haystack.charAt(idx) == needle.charAt(0)){
                int tmp_idx = 1;
                boolean flag  = true;
                while(tmp_idx < needle.length()){
                    if(haystack.charAt(idx + tmp_idx) != needle.charAt(0 + tmp_idx)){
                        flag = false;
                        break;
                    }else {
                        tmp_idx ++;
                    }
                }
                if (flag){
                    return idx;
                }
            }
            idx ++;
        }
        return -1;
    }

    static void getNext(int[] next, String s) {
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

    static int strStr_KMP(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }

    static boolean repeatedSubstringPattern(String s) {
        String sub = new String();
        String re = new String();
        for (int i = s.length()/2; i > 0; i--) {
            sub = s.substring(0, i);
            if(sub.equals(s.substring(i, 2*i)) && s.length()%i == 0){
                re = sub + "";
                break;
            }
        }
        if(re.equals("")){
            return false;
        }
        boolean flag = true;
        for (int idx = 1; idx < s.length()/re.length(); idx++) {
            if(!s.substring(idx * re.length(), (idx+1) * re.length()).equals(re)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    static int maxProduct(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()<o2.length() ? 1 : o1.length()==o2.length() ? 0 : -1 ;
            }
        });
        List<Set<Character>> a = new ArrayList<>();
        for (String iter: words) {
            Set<Character> tmp = new HashSet<>();
            for (int idx = 0; idx < iter.length(); idx++) {
                tmp.add(iter.charAt(idx));
            }
            a.add(tmp);
        }
        return 0;
    }

    public static void main(String args[]){
        String a = new String(new char[]{'a','b'});
        strStr(new String("leetcode"), new String("leeto"));
        maxProduct(new String[]{"abc", "abcd", "cd"});
        getNext(new int[12], new String("aabaacaabaac"));
        strStr_KMP(new String("aabaabaafa "), new String("aabaaf"));


    }
}
