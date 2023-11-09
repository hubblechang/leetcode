## 注意事项
1. 注意在写`&&`条件时，要注意条件的顺序，比如下面这个判断单词起始终点位置的代码
```
while(end < s.length() && s.charAt(end) != ' '){
    end ++;
}
```
2. 用char连成string的方法
```
String str = "";
while (!deque.isEmpty()) {
    str = deque.pop() + str;
}
```
3. 题目中包含取余的问题
```
return (int) ((long)max_sub_width * max_sub_height * 1L % div);
```

4. Comparator比较器

**Java默认是升序**
```agsl
< return -1
= return 0
> return 1
```
如果想要降序，返回相反的
```agsl
< return 1
= return 0
> return -1
```

## 数组

```
import java.util.concurrent.ThreadLocalRandom;


class Array { 
    // Your program begins with a call to main(). 
    // Prints "Hello, World" to the terminal window. 

    /* 随机访问元素 */
    int randomAccess(int[] nums) {
        // 在区间 [0, nums.length) 中随机抽取一个数字
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
        // 获取并返回随机元素
        int randomNum = nums[randomIndex];
        return randomNum;
    }

    /* 在数组的索引 index 处插入元素 num */
    void insert(int[] nums, int num, int index) {
        // 把索引 index 以及之后的所有元素向后移动一位
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        // 将 num 赋给 index 处元素
        nums[index] = num;
    }

    /* 删除索引 index 处元素 */
    void remove(int[] nums, int index) {
        // 把索引 index 之后的所有元素向前移动一位
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    /* 遍历数组 */
    void traverse(int[] nums) {
        int count = 0;
        // 通过索引遍历数组
        for (int i = 0; i < nums.length; i++) {
            count++;
        }
        // 直接遍历数组
        for (int num : nums) {
            count++;
        }
    }

    /* 在数组中查找指定元素 */
    int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    /* 扩展数组长度 */
    int[] extend(int[] nums, int enlarge) {
        // 初始化一个扩展长度后的数组
        int[] res = new int[nums.length + enlarge];
        // 将原数组中的所有元素复制到新数组
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        // 返回扩展后的新数组
        return res;
    }


    public static void main(String args[]) 
    { 
        int[] nums = {0,1,2,3,4,5};
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
        // 获取并返回随机元素
        int randomNum = nums[randomIndex];
        System.out.println(randomNum);
        System.out.println("Hello, World"); 
    } 
}
```
## 链表

### **Caution：** Java的值传递和对象传递
+ 对象传递（数组、类、接口）是引用传递

传递的并不是实际的对象，而是对象的引用，外部对引用对象的改变也会反映到源对象上，因为引用传递的时候，实际上是将实参的地址值复制一份给形参。
+ 原始类型数据（整形、浮点型、字符型、布尔型）传递是值传递

传递对象的一个副本，即使副本被改变，也不会影响源对象，因为值传递的时候，实际上是将实参的值复制一份给形参。

### **Caution：** 一定要注意没有赋值的对象和空对象null的区别！！！
```
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
```


```
/* 链表节点类 */


class LinkedList{
    static class ListNode {
        int val;        // 节点值
        ListNode next;  // 指向下一节点的引用
        ListNode(int x) { val = x; }  // 构造函数
    }

    /* 双向链表节点类 */
    class ListNode {
        int val;        // 节点值
        ListNode next;  // 指向后继节点的引用
        ListNode prev;  // 指向前驱节点的引用
        ListNode(int x) { val = x; }  // 构造函数
    }


    /* 在链表的节点 n0 之后插入节点 P */
    void insert(ListNode n0, ListNode P) {
        ListNode n1 = n0.next;
        P.next = n1;
        n0.next = P;
    }

    /* 访问链表中索引为 index 的节点 */
    ListNode access(ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            if (head == null)
                return null;
            head = head.next;
        }
        return head;
    }

    /* 在链表中查找值为 target 的首个节点 */
    int find(ListNode head, int target) {
        int index = 0;
        while (head != null) {
            if (head.val == target)
                return index;
            head = head.next;
            index++;
        }
        return -1;
    }



    /* 删除链表的节点 n0 之后的首个节点 */
    void remove(ListNode n0) {
        if (n0.next == null)
            return;
        // n0 -> P -> n1
        ListNode P = n0.next;
        ListNode n1 = P.next;
        n0.next = n1;
    }



    public static void main(String args[]){
        /* 初始化链表 1 -> 3 -> 2 -> 5 -> 4 */
        // 初始化各个节点
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        // 构建引用指向
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(n0.val);
    }
}
```

## 列表

```
import java.util.List;
import java.util.ArrayList;
/* ArrayList is a frequently-used subclass of List */
import java.util.Arrays;

class list{


    public static void main(String[] args){
        /* 初始化列表 */
        // 无初始值
        List<Integer> list1 = new ArrayList<>();
        // 有初始值（注意数组的元素类型需为 int[] 的包装类 Integer[]）
        Integer[] numbers = new Integer[] { 1, 3, 2, 5, 4 };
        List<Integer> list = new ArrayList<>(Arrays.asList(numbers));

        /* 访问元素 */
        int num = list.get(1);  // 访问索引 1 处的元素

        /* 更新元素 */
        list.set(1, 0);  // 将索引 1 处的元素更新为 0

        /* 清空列表 */
        list.clear();

        /* 尾部添加元素 */
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);

        /* 中间插入元素 */
        list.add(3, 6);  // 在索引 3 处插入数字 6

        /* 删除元素 */
        list.remove(3);  // 删除索引 3 处的元素

        /* 通过索引遍历列表 */
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count++;
        }

        /* 直接遍历列表元素 */
        count = 0;
        for (int n : list) {
            count++;
        }

    }
}
```

## 栈与队列（Stack and Queue）
### 栈
```
/* 初始化栈 */
Stack<Integer> stack = new Stack<>();

/* 元素入栈 */
stack.push(1);
stack.push(3);
stack.push(2);
stack.push(5);
stack.push(4);

/* 访问栈顶元素 */
int peek = stack.peek();

/* 元素出栈 */
int pop = stack.pop();

/* 获取栈的长度 */
int size = stack.size();

/* 判断是否为空 */
boolean isEmpty = stack.isEmpty();
```
### 队列
```
/* 初始化队列 */
Queue<Integer> queue = new LinkedList<>();

/* 元素入队 */
queue.offer(1);
queue.offer(3);
queue.offer(2);
queue.offer(5);
queue.offer(4);

/* 访问队首元素 */
int peek = queue.peek();

/* 元素出队 */
int pop = queue.poll();

/* 获取队列的长度 */
int size = queue.size();

/* 判断队列是否为空 */
boolean isEmpty = queue.isEmpty();
```
### 双向队列
```
/* 初始化双向队列 */
Deque<Integer> deque = new LinkedList<>();

/* 元素入队 */
deque.offerLast(2);   // 添加至队尾
deque.offerLast(5);
deque.offerLast(4);
deque.offerFirst(3);  // 添加至队首
deque.offerFirst(1);

/* 访问元素 */
int peekFirst = deque.peekFirst();  // 队首元素
int peekLast = deque.peekLast();    // 队尾元素

/* 元素出队 */
int popFirst = deque.pollFirst();  // 队首元素出队
int popLast = deque.pollLast();    // 队尾元素出队

/* 获取双向队列的长度 */
int size = deque.size();

/* 判断双向队列是否为空 */
boolean isEmpty = deque.isEmpty();
```
## 哈希表
```
/* 初始化哈希表 */
Map<Integer, String> map = new HashMap<>();

/* 添加操作 */
// 在哈希表中添加键值对 (key, value)
map.put(12836, "小哈");   
map.put(15937, "小啰");   

/* 查询操作 */
// 向哈希表输入键 key ，得到值 value
String name = map.get(15937);

/* 删除操作 */
// 在哈希表中删除键值对 (key, value)
map.remove(10583);


/* 遍历哈希表 */
// 遍历键值对 key->value
for (Map.Entry <Integer, String> kv: map.entrySet()) {
    System.out.println(kv.getKey() + " -> " + kv.getValue());
}
// 单独遍历键 key
for (int key: map.keySet()) {
    System.out.println(key);
}
// 单独遍历值 value
for (String val: map.values()) {
    System.out.println(val);
}
```

## String类
```
String a = new String();
char[] a_0 = new char[] {'a','b','c'};
String a = new String(a_0);

```