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