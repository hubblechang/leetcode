package practice20240615;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class InverseK {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val = val;}
        ListNode(){}
    }

    public static ListNode construct_List(int[] nums){
        ListNode dummyhead = new ListNode();
        ListNode cur = dummyhead;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return dummyhead.next;
    }

    public static ListNode[] reverse(ListNode head, ListNode tail){
        ListNode cur = head;
        ListNode pre = null;
        while (pre!=tail){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }

    public static ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverse_K(ListNode head, int k){
        ListNode cur = head;
        ListNode pre = head;
        ListNode dummyhead = new ListNode();
        dummyhead.next = head;
        ListNode former = dummyhead;
        while (cur!=null){
            ListNode cur_head = cur;
            for (int i = 0; i < k-1; i++) {
                cur = cur.next;
                if (cur == null){
                    return dummyhead.next;
                }
            }
            ListNode next = cur.next;
            ListNode[] nodes = reverse(cur_head, cur);
            ListNode new_head = nodes[0];
            ListNode new_tail = nodes[1];
            former.next = new_head;
            new_tail.next = next;
            former = new_tail;
            cur = next;
        }
        return dummyhead.next;
    }

    public static void print(ListNode head){
        ListNode cur = head;
        while (cur!=null){
            System.out.printf("%d\t", cur.val);
            cur = cur.next;
        }
        System.out.print("\n");
    }
    
    public static int[][] union(int[][] intervals){
        boolean flag = true;
        ArrayList<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        for (int i = 0; i < intervals.length; i++) {
            pq.add(intervals[i]);
        }
        int[] a = pq.poll();
        while (!pq.isEmpty()){
            int[] b = pq.peek();
            if(a[1] >= b[0]){
                a[1] = b[1];
                flag = false;
            }else {
                res.add(a);
                a = b;
                flag = true;
            }
            pq.poll();
        }
        if (flag){
            res.add(a);
        }
        return (int[][]) res.toArray();
    }

    public static void main(String[] args) {
        ListNode head = construct_List(new int[]{1,2,3,4,5,6,7,8});
        print(head);
        ListNode cur = head;
//        while (cur.next != null){
//            cur = cur.next;
//        }
//        for (int i = 0; i < 4; i++) {
//            cur = cur.next;
//        }
//        head = reverse(head, cur)[0];
        head = reverse_K(head, 3);
        print(head);
        union(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
