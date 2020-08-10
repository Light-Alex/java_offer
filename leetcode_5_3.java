import java.util.ArrayList;

/**
 * 方法三：
 * preCount 记录上一次连续数字出现的次数
 * curCount 记录这一次连续数字出现的次数
 * 每次遇到不同数字时，preCount = curCount, curCount = 1;
 * 若 preCount >= curCount, count++;
 */

public class leetcode_5_3 {
    public static void main(String[] args) {
        leetcode_5_3 ll = new leetcode_5_3();
        String s = "10101";
        System.out.println(ll.countBinarySubstrings(s));
    }

    public int countBinarySubstrings(String s) {
        int count = 0;
        char[] charArray = s.toCharArray();
        if(charArray.length <= 1){
            return count;
        }

        int preCount = 0;
        int curCount = 1;

        for(int i = 1; i < charArray.length; i++){
            if(charArray[i] == charArray[i-1]){
                curCount++;
            }else{
                preCount = curCount;
                curCount = 1;
            }

            if(preCount >= curCount){
                count++;
            }
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