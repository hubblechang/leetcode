import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class Solution2{
    public Node connect(Node root) {
        Node iter = new Node();
        iter.left = root;
        Queue<Node> cur = new LinkedList<>();
        cur.add(iter);
        Queue<Node> next = new LinkedList<>();
        do{
            while(!cur.isEmpty()){
                Node tmp = cur.poll();
                if(tmp.left != null){next.add(tmp.left);};
                if(tmp.right != null){next.add(tmp.right);};
            }
            while(!next.isEmpty()){
                Node tmp1 = next.poll();
                cur.add(tmp1);
                Node tmp2 = next.peek();
                tmp1.next = tmp2;
            }
        }while(!next.isEmpty());
        return root;
    }

    public void traversal(TreeNode cur, List<Integer> res) {
        if(cur == null){
            return;
        }
        res.add(cur.val);
        traversal(cur.left, res);
        traversal(cur.right, res);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traversal(root, res);
        return res;
    }

}

public class Tree_problem {
    public static void main(String args[]){
        Solution2 s = new Solution2();
        Node root = new Node(1);
        Node node_2 = new Node(2);
        Node node_3 = new Node(3);
        Node node_4 = new Node(4);
        Node node_5 = new Node(5);
        Node node_7 = new Node(7);
        root.left = node_2;
        root.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        node_5.right = node_7;
        s.connect(root);

    }

}
