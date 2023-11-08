import java.util.HashSet;
import java.util.Set;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    static ListNode reverseList(ListNode head) {
        // ListNode new_head = new ListNode();
        // ListNode current_node = new ListNode();
        // int count = 0;
        // List<Integer> list1 = new ArrayList<>();
        // ListNode origin_head = new ListNode(head.val, head.next);
        // while (origin_head != null) {
        //     list1.add(origin_head.val);
        //     origin_head = origin_head.next;
        //     count++;
        // }
        // if(count>0){
        //     new_head.val = list1.get(count-1);
        //     current_node = new_head;
        // }
        
        // for (int i = count-2; i>=0; i--){
        //     ListNode next = new ListNode(list1.get(i));
        //     current_node.next = next;
        //     current_node = current_node.next;
        // }
        // return new_head;
        ListNode new_head = null;
        ListNode cur_node = head;
        while(cur_node != null){
            ListNode cur_next = cur_node.next;
            cur_node.next = new_head;
            new_head = cur_node;
            cur_node = cur_next;
        }
        return new_head;
    }


    static ListNode swapPairs(ListNode head) {
        ListNode virtual_head = new ListNode(0, head);
        ListNode cur_node = virtual_head;
        if(cur_node.next == null){
            return virtual_head.next;
        }
        while(cur_node.next.next != null){
            ListNode tmp1 = cur_node.next;
            ListNode tmp2 = cur_node.next.next;
            cur_node.next = tmp2;
            tmp1.next = tmp2.next;
            tmp2.next = tmp1;
            cur_node = cur_node.next.next;
            if(cur_node.next == null){
                break;
            }
        }
        return virtual_head.next;
    }


    static ListNode removeElements(ListNode head, int val) {
        ListNode virtual_head = new ListNode(0, head);
        ListNode cur_node = virtual_head;
        while(cur_node != null && cur_node.next != null){
            while(cur_node.next.val == val) {
                cur_node.next = cur_node.next.next;
                if(cur_node.next == null){
                    break;
                }
            }
            cur_node = cur_node.next;
        }
        return virtual_head.next;
    }


    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode cur_1 = l1;
        ListNode cur_2 = l2;
        ListNode cur_sum_node = sum;
        int carry = 0;
        while(cur_1 != null || cur_2 != null){
            int cur_sum = carry;
            if(cur_1 != null){
                cur_sum += cur_1.val;
                cur_1 = cur_1.next;
            }
            if (cur_2 != null) {
                cur_sum += cur_2.val;
                cur_2 = cur_2.next;
            }
            if (cur_sum > 9){
                carry = 1;
            } else {
                carry =0;
            }
            ListNode iter_node = new ListNode(cur_sum % 10);
            cur_sum_node.next = iter_node;
            cur_sum_node = cur_sum_node.next;
        }

        if (carry == 1){
            ListNode iter_node = new ListNode(1);
            cur_sum_node.next = iter_node;
        }

        return sum.next;
    }


    static int maxSubArray(int[] nums) {
        int count = 0;
        int max_sum = -100000;
        int start_index = 0;
        for(int end_index = start_index; end_index < nums.length;){
            count = 0;
            end_index = start_index;
            while(end_index < nums.length && count >= 0){
                count += nums[end_index];
                if(max_sum < count){
                    max_sum = count;
                }
                end_index ++;
            }
            start_index = end_index;
        }
        return max_sum;
    }


    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode new_head = new ListNode();
        new_head.next = head;
        ListNode cur_head = head;
        int count = 0;
        while(cur_head != null){
            count ++;
            cur_head = cur_head.next;
        }
        int index  = count - n;
        ListNode fore_delete = new_head;
        while(index != 0){
            fore_delete = fore_delete.next;
            index --;
        }
        fore_delete.next = fore_delete.next.next;
        return  new_head.next;
    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listA = headA;
        ListNode listB = headB;
        if(listA == null || listB ==null){
            return null;
        }
        while(listA != listB){
            listA = listA == null? headB : listA.next;
            listB = listB == null? headA : listB.next;
        }
        return listA;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode iter_head = head;
        Set<ListNode> nodes = new HashSet<>();
        while(iter_head != null && !nodes.contains(iter_head)){
            nodes.add(iter_head);
            iter_head = iter_head.next;
        }
        return iter_head;
    }



    public static void main(String args[]){
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode head = n0;

        ListNode node_0 = new ListNode(1);
        ListNode node_1 = new ListNode(2);
        ListNode node_2 = new ListNode(3);
        ListNode node_3 = new ListNode(4);
        ListNode node_4 = new ListNode(5);
        ListNode node_5 = new ListNode(6);
        node_0.next = node_1;
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        ListNode head2 = node_0;

        ListNode iter = head;
        while(iter != null){
            System.out.println(iter.val);
            iter = iter.next;
        }

//        ListNode new_list = addTwoNumbers(n1, n1);
//        ListNode new_list = removeNthFromEnd(n0, 2);
        ListNode new_list = getIntersectionNode(head, head2);
        System.out.println("new list is:");
        while(new_list != null){
            System.out.println(new_list.val);
            new_list = new_list.next;
        }

//        int[] nums = {-2,1};
//        System.out.println(maxSubArray(nums));
    }
}