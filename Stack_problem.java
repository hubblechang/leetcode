import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.*;

class MyQueue {
    public Stack<Integer> s1;
    public Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        int res = s2.pop();
        while (!s2.empty()){
            s1.push(s2.pop());
        }
        return res;
    }

    public int peek() {
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        int res = s2.peek();
        while (!s2.empty()){
            s1.push(s2.pop());
        }
        return res;
    }

    public boolean empty() {
        return s1.empty();
    }
}

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        q2.clear();
        while (!(q1.size() == 1)){
            q2.add(q1.poll());
        }
        int res = q1.poll();
        while (!q2.isEmpty()){
            q1.add(q2.poll());
        }
        return res;
    }

    public int top() {
        q2.clear();
        while (!(q1.size() == 1)){
            q2.add(q1.poll());
        }
        int res = q1.peek();
        q2.add(q1.poll());
        while (!q2.isEmpty()){
            q1.add(q2.poll());
        }
        return res;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

class Solution0 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> regulation = new HashMap<>();
        regulation.put('(', ')');
        regulation.put('[', ']');
        regulation.put('{', '}');
        boolean res = true;
        for (int idx = 0; idx < s.length(); idx++) {
            if(s.charAt(idx) == '(' || s.charAt(idx) == '[' || s.charAt(idx) == '{'){
                stack.add(regulation.get(s.charAt(idx)));
            }else {
                if(!stack.empty() && stack.peek() == s.charAt(idx)){
                    stack.pop();
                }else {
                    res = false;
                    break;
                }
            }
        }
        if(!stack.empty()){
            res = false;
        }
        return res;
    }
    public String removeDuplicates(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (deque.isEmpty() || deque.peek() != ch) {
                deque.push(ch);
            } else {
                deque.pop();
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;
    }

    public int countPoints(String rings) {
        int[][] count = new int[10][3];
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('G',1);
        map.put('B',2);
        for (int idx = 0; idx < rings.length()/2; idx++) {
            count[rings.charAt(idx * 2 + 1) - '0'][map.get(rings.charAt(idx * 2))] += 1;

        }
        int num = 0;
        for (int row = 0; row < 10; row++) {
            if(count[row][0]!=0 && count[row][1]!=0 && count[row][2]!=0){
                num ++;
            }
        }
        return num;
    }

    public int evalRPN(String[] tokens) {
        List<String> alg = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> eq = new Stack<>();
        for (int idx = 0; idx < tokens.length; idx++) {
            if(alg.contains(tokens[idx])){
                int b = eq.pop();
                int a = eq.pop();
                if(tokens[idx].equals("+")){eq.add(a+b);}
                else if(tokens[idx].equals("-")){eq.add(a-b);}
                else if(tokens[idx].equals("*")){eq.add(a*b);}
                else if(tokens[idx].equals("/")){eq.add(a/b);}
            }else {
                eq.add(Integer.parseInt(tokens[idx]));
            }
        }
        return eq.pop();
    }

}



public class Stack_problem {
    public static void main(String args[]){
       MyStack obj = new MyStack();
       obj.push(10);
       obj.push(20);
       int param_2 = obj.pop();
       int param_3 = obj.top();
       boolean param_4 = obj.empty();
       Solution0 s  = new Solution0();
       System.out.println(s.removeDuplicates(new String("aababaab")));
       System.out.println(s.countPoints(new String("G3R3R7B7R5B1G8G4B3G6")));
       s.evalRPN(new String[]{"4","13","5","/","+"});

    }
}
