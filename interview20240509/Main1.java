package interview20240509;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int result = deleteCount(str);
        System.out.println(result);
    }

    private static int deleteCount(String str) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int maxLen = 0;
        for (char c :
                str.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c){
                int _count = 0;
                while(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                    _count ++;
                }
                count += _count;
            }else {
                stack.push(c);
            }
        }
        return count;
    }
}
