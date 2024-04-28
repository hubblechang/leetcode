package interview20240421;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int target = sc.nextInt();
        String[] inputs = input.split(" ");
        int[] nums = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(nums);

        List<Character> res = new ArrayList<>();
        res.add('S');
        // String res = "S";
        int left = 0;
        int right = nums.length-1;
        int index = (left+right)/2;
        while(index>=0 && index <=nums.length-1 && left < nums.length && right >=0){
            if(nums[index] == target){
                // res += "Y";
                res.add('Y');
                break;
            } else if (index == 0 || index == nums.length - 1) {
                break;
            } else if (nums[index] > target) {
                // res += "L";
                right = index -1;
                index = (left+right)/2;
                if(index<0 || index >nums.length-1){
                    break;
                }
                res.add('L');

            } else if (nums[index] < target) {
                // res += "R";
                left = index +1;
                index = (left+right)/2;
                if(index<0 || index >nums.length-1){
                    break;
                }
                res.add('R');
            }
        }
        if(res.get(res.size() -1) == 'Y'){
            // System.out.println(res.toString());
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
            }
        }else {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
            }
            System.out.print("N");
            // System.out.println(res.toString() + "N");
        }

    }
}
