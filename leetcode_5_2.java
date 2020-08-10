import java.util.ArrayList;
import java.util.Arrays;

/**
 * 方法二：对数组进行分段，统计连续数字出现的次数
 * "00110011" -> {2, 2, 2, 2} 则重复子串出现的次数为：min(2, 2) + min(2, 2) + min(2, 2) = 6;
 */

public class leetcode_5_2 {
    public static void main(String[] args) {
        leetcode_5_2 ll = new leetcode_5_2();
        String s = "10101";
        System.out.println(ll.countBinarySubstrings(s));
    }

    public int countBinarySubstrings(String s) {
        int count = 0;
        char[] charArray = s.toCharArray();
        if(charArray.length <= 1){
            return count;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        int tempNum = 0;
        char temp = charArray[0];
        for(char c : charArray){
            if(c == temp){
                tempNum++;
            }else{
                list.add(tempNum);
                tempNum = 1;
                temp = c;
            }
        }

        list.add(tempNum);

        for(int i = 0; i < list.size() - 1; i++){
            count += Math.min(list.get(i), list.get(i+1));
        }

        return count;
    }

    public void printArray(char[] charArray){
        for(char c : charArray){
            System.out.print(c + " ");
        }
        System.out.println();
    }

}