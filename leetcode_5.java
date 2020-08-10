import java.util.Arrays;

/**
 * 方法一：暴力解法
 */

public class leetcode_5 {
    public static void main(String[] args) {
        leetcode_5 ll = new leetcode_5();
        String s = "10101";
        System.out.println(ll.countBinarySubstrings(s));
    }

    public int countBinarySubstrings(String s) {
        int count = 0;
        char[] charArray = s.toCharArray();
        if(charArray == null || charArray.length <= 1){
            return count;
        }

        for(int i = 0; i < charArray.length - 1; i++){
            for(int j = i + 1; j < charArray.length; j++){
                if(isDuplicate(Arrays.copyOfRange(charArray, i, j + 1))){
                    // System.out.println(1);
                    count++;
                    // printArray(Arrays.copyOfRange(charArray, i, j + 1));
                }
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

    public boolean isDuplicate(char[] charArray) {
        int count = 0;

        if(charArray.length % 2 != 0){
            return false;
        }

        if(charArray[0] == '0'){
            while(count < charArray.length && charArray[count] == '0'){
                count++;
            }

            for(int i = count; i < charArray.length; i++){
                if(charArray[i] == '1'){
                    count--;
                }else{
                    return false;
                }
            }

            if(count == 0){
                return true;
            }else{
                return false;
            }
        }else{
            while(count < charArray.length && charArray[count] == '1'){
                count++;
            }

            for(int i = count; i < charArray.length; i++){
                if(charArray[i] == '0'){
                    count--;
                }else{
                    return false;
                }
            }

            if(count == 0){
                return true;
            }else{
                return false;
            }
        }
        
    }
}