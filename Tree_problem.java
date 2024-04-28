import java.util.*;
import java.util.LinkedList;
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
    public Node(Integer _val) {
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
//    public static TreeNode buildTreeFromLevelOrder(int[] levelOrder) {
//        if(levelOrder.length == 0){
//            return null;
//        }
//        int order = 1;
//        TreeNode root = new TreeNode(levelOrder[0]);
//        while ()
//
//        return root;
//    }

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> current = new LinkedList<>();
        current.add(root);
        Queue<TreeNode> next = new LinkedList<>();
        do{
            List<Integer> _cur = new LinkedList<>();
            next.clear();
            while (!current.isEmpty()){
                TreeNode _node = current.poll();
                _cur.add(_node.val);
                if(_node.left != null){next.add(_node.left);}
                if(_node.right != null){next.add(_node.right);}
            }
            res.add(_cur);
            current.addAll(next);

        }while (!current.isEmpty());
        return res;
    }

    public void inverseNode(TreeNode node){
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        invertTree(node.left);
        invertTree(node.right);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        inverseNode(root);
        return root;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res_list = new LinkedList<>();
        Stack<List<Integer>> res = new Stack<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> current = new LinkedList<>();
        current.add(root);
        Queue<TreeNode> next = new LinkedList<>();
        do{
            List<Integer> _cur = new LinkedList<>();
            next.clear();
            while (!current.isEmpty()){
                TreeNode _node = current.poll();
                _cur.add(_node.val);
                if(_node.left != null){next.add(_node.left);}
                if(_node.right != null){next.add(_node.right);}
            }
            res.add(_cur);
            current.addAll(next);

        }while (!current.isEmpty());
        while (!res.isEmpty()){
            res_list.add(res.pop());
        }
        return res_list;
    }

    public TreeNode construct_layer(int[] a){
        TreeNode root = new TreeNode(a[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int idx = 1;
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(idx<a.length && a[idx]!=-1){
                t.left = new TreeNode(a[idx]);
                q.add(t.left);
            }
            idx++;
            if(idx<a.length && a[idx]!=-1){
                t.right = new TreeNode(a[idx]);
                q.add(t.right);
            }
            idx++;
        }
        return root;
    }

    public String level_string(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> a = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            a.add(t.val);
            if(t.left != null){
                q.add(t.left);
            }
            if (t.right != null){
                q.add(t.right);
            }
        }
        return a.toString();
    }

    public List<Integer> rightSideView(TreeNode root) {
        /*小心树高不一致的情况*/
        List<Integer> res = new LinkedList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> current = new LinkedList<>();
        current.add(root);
        Queue<TreeNode> next = new LinkedList<>();
        do{
            List<Integer> _cur = new LinkedList<>();
            next.clear();
            while (!current.isEmpty()){
                TreeNode _node = current.poll();
                _cur.add(_node.val);
                if(_node.left != null){next.add(_node.left);}
                if(_node.right != null){next.add(_node.right);}
            }
            res.add(_cur.get(_cur.size() - 1));
            current.addAll(next);

        }while (!current.isEmpty());
        return res;

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> current = new LinkedList<>();
        current.add(root);
        Queue<TreeNode> next = new LinkedList<>();
        do{
            List<Integer> _cur = new LinkedList<>();
            next.clear();
            while (!current.isEmpty()){
                TreeNode _node = current.poll();
                _cur.add(_node.val);
                if(_node.left != null){next.add(_node.left);}
                if(_node.right != null){next.add(_node.right);}
            }
            double mean = 0;
            for (int i = 0; i < _cur.size(); i++) {
                mean += _cur.get(i);
            }
            mean /= _cur.size();
            res.add(mean);
            current.addAll(next);

        }while (!current.isEmpty());
        return res;

    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> current = new LinkedList<>();
        current.add(root);
        Queue<TreeNode> next = new LinkedList<>();
        do{
            List<Integer> _cur = new LinkedList<>();
            next.clear();
            while (!current.isEmpty()){
                TreeNode _node = current.poll();
                _cur.add(_node.val);
                if(_node.left != null){next.add(_node.left);}
                if(_node.right != null){next.add(_node.right);}
            }
            Integer max = Integer.MIN_VALUE;
            for (int i = 0; i < _cur.size(); i++) {
                if(_cur.get(i) > max){
                    max = _cur.get(i);
                }
            }
            res.add(max);
            current.addAll(next);

        }while (!current.isEmpty());
        return res;
    }

    public Node connect_116(Node root) {
        Node iter = root;

        if(root == null){
            return null;
        }
        Queue<Node> current = new LinkedList<>();
        current.add(iter);
        Queue<Node> next = new LinkedList<>();
        do{
            next.clear();
            while (!current.isEmpty()){
                Node _node = current.poll();
                _node.next = current.peek();
                if(_node.left != null){next.add(_node.left);}
                if(_node.right != null){next.add(_node.right);}
            }
            current.addAll(next);
        }while (!current.isEmpty());
        return root;
    }

    int MAX_DEPTH = 0;

    public void depthCount(TreeNode cur, int formerDepth){
        if(cur != null){
            int curDepth = formerDepth + 1;
            MAX_DEPTH = Integer.max(curDepth, MAX_DEPTH);
            depthCount(cur.left, curDepth);
            depthCount(cur.right, curDepth);
        }
    }
    public int maxDepth(TreeNode root) {
        depthCount(root, 0);
        return MAX_DEPTH;
    }

    int MIN_DEPTH = Integer.MAX_VALUE;

    public void minDepthCount(TreeNode cur, int curDepth) {
        if(cur == null) {

        } else if (cur.left == null && cur.right == null) {
            MIN_DEPTH = Integer.min(MIN_DEPTH, curDepth+1);
        }else {
            minDepthCount(cur.left, curDepth +1);
            minDepthCount(cur.right, curDepth +1);
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        minDepthCount(root, 0);
        return MIN_DEPTH;
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * No.222
     */

    private int count_by_layer(List<TreeNode> cur){
        int res = cur.size();
        List<TreeNode> next = new ArrayList<>();
        if(cur.size() == 0){
            return 0;
        }
        for (int i = 0; i < cur.size(); i++) {
            if(cur.get(i).left!=null){next.add(cur.get(i).left);}
            if(cur.get(i).right!=null){next.add(cur.get(i).right);}
        }
        return res + count_by_layer(next);

    }
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
       return count_by_layer(new ArrayList<>(Arrays.asList(root)));
    }

    /**
     *
     * No.110
     */
    private int tree_height(TreeNode node){
        if(node == null){
            return 0;
        }
        else if(node.left == null && node.right == null){
            return 1;
        }else if(node.left == null){
            return tree_height(node.right)+1;
        }else if(node.right == null){
            return tree_height(node.left)+1;
        }else {
            return Integer.max(tree_height(node.left), tree_height(node.right)) + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return (Math.abs(tree_height(root.left) - tree_height(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public List<String> convert(Queue<List<TreeNode>> paths){
        List<String> res = new ArrayList<>();
        while (!paths.isEmpty()){
            List<TreeNode> a = paths.poll();
            String cur = new String();
            for (int i = 0; i < a.size(); i++) {
                cur += (Integer.toString(a.get(i).val) + "->");
            }
            res.add(cur.substring(0, cur.length()-2));
        }
        return res;
    }

    boolean res = false;
    public boolean hasPathSum(TreeNode root, int target){
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            int size = q.size();
            if(t.left != null ){
                t.left.val = t.left.val + t.val;
                q.add(t.left);
            }
            if (t.right != null) {
                t.right.val = t.right.val + t.val;
                q.add(t.right);
            }
            if(t.left == null && t.right == null){
                if(t.val == target){
                    res = true;
                }
            }
        }
        return res;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        Queue<List<TreeNode>> paths = new LinkedList<>();
        paths.add(new ArrayList<>(Arrays.asList(root)));
        Queue<List<TreeNode>> paths_end = new LinkedList<>();
        while (! paths.isEmpty()){
            List<TreeNode> a = paths.poll();
            TreeNode last = a.get(a.size()-1);
            if(last.left == null && last.right == null){
                paths_end.add(a);
            }
            else {
                if(last.left != null){List<TreeNode> i = new ArrayList<>(a);i.add(last.left);paths.add(i);}
                if(last.right != null){List<TreeNode> i = new ArrayList<>(a);i.add(last.right);paths.add(i);}
            }
        }
        return convert(paths_end);

    }

    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val == val){
            return root;
        }
        else {
            TreeNode tmp1 = null;
            TreeNode tmp2 = null;
            if(root.left!=null){
                tmp1 = searchBST(root.left, val);
            }
            if(root.right!=null){
                tmp2 = searchBST(root.right, val);
            }
            if (tmp1 != null){
                return tmp1;
            }else {
                return tmp2;
            }
        }
    }

    public static int count = 0;
    public static boolean isLeaf(TreeNode node){
        if(node.left == null && node.right ==null){
            return true;
        }
        return false;
    }
    public static int countScore(TreeNode root){
        if(!isLeaf(root.left) && !isLeaf(root.right)){
            return Math.max(countScore(root.left), countScore(root.right)) + 1;
        } else if (isLeaf(root.left)) {
            return countScore(root.right) + 1;
        } else if (isLeaf(root.right)) {
            return countScore(root.left) + 1;
        }else {
            return 0;
        }
    }

    public TreeNode constructFull(int LAYER){
        TreeNode root = new TreeNode();
        Queue<TreeNode> cur_layer = new LinkedList<>();
        Queue<TreeNode> next_layer = new LinkedList<>();
        cur_layer.add(root);
        for (int i = 0; i < LAYER; i++) {
            while(!cur_layer.isEmpty()){
                TreeNode node = cur_layer.poll();
                node.left = new TreeNode();
                node.right =new TreeNode();
                next_layer.add(node.left);
                next_layer.add(node.right);
            }
            cur_layer.addAll(next_layer);
        }
        dfs_value(root);

        return root;
    }

    public int dfs_value(TreeNode root) {
        if(root.left == null && root.right == null){
            root.val = 1;
        }else {
            root.val = dfs_value(root.left) + dfs_value(root.right);
        } return root.val;
    }

    public static void layerTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 将根节点加入队列

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // 从队列中移除并返回队列头部的元素
            System.out.print(current.val + " "); // 访问当前节点的值

            if (current.left != null) {
                queue.offer(current.left); // 将当前节点的左子节点加入队列
            }
            if (current.right != null) {
                queue.offer(current.right); // 将当前节点的右子节点加入队列
            }
        }
    }
    
    public int maxLength(String s, int k){
//        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int start = 0;
        while(start<s.length()){
            if(s.charAt(start) == '0'){
                start++;
            }else {
                int end = start+1;
                while (end<s.length() && s.charAt(end) != '0'){
                    end++;
                }
                q.add(end-start);
                start = end;
            }
        }
        for (int i = 0; i < k; i++) {
            int a = q.poll();
            if(a%2 == 1){
                q.add((a-1) / 2);
                q.add((a-1) / 2);
            }
            else {
                q.add((a-1) / 2);
                q.add((a-1) / 2 + 1);
            }
        }
        return q.poll();
    }

}

public class Tree_problem {
    public static void main(String args[]){
        Solution2 s = new Solution2();
        TreeNode root = new TreeNode(3);
        TreeNode node_2 = new TreeNode(9);
        TreeNode node_3 = new TreeNode(20);
        TreeNode node_4 = new TreeNode(15);
        TreeNode node_5 = new TreeNode(7);
        root.left = node_2;
        root.right = node_3;
        node_3.left = node_4;
        node_3.right = node_5;
        s.levelOrder(root);
        Integer[] a = new Integer[]{1,2,2,3,3,null,null,4,4};
        System.out.println(Arrays.toString(a));
        root = new TreeNode(0);
        node_2 = new TreeNode(1);
        node_3 = new TreeNode(2);
        root.right = node_2;
        node_2.right = node_3;
        s.isBalanced(root);
        TreeNode has_path = s.construct_layer(new int[]{5,4,8,11,-1,13,4,7,2,-1,-1,-1,1});
        System.out.println(s.hasPathSum(has_path, 22));

        TreeNode full = s.constructFull(3);
        Solution2.layerTraversal(full);
        System.out.println();
        System.out.println(s.maxLength("000111111111000111011111111", 3));
    }

}
