/**
 * 题目：字符串相乘
 * 
 * 题目描述：给定两个以字符串形式表示的非负整数 num1 和 num2，
 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例：
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 
 * 注意：不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */

/**
 * 方法：使用加法运算，num2中的每一位按位与num1每一位相乘，模拟乘法运算的过程
 * 若num1中和num2中有一个为"0"则直接返回0
 */

public class leetcode_11 {
    public static void main(String[] args) {
        leetcode_11 ll = new leetcode_11();
        // String num1 = "123";
        // String num2 = "56";
        String num1 = "0";
        String num2 = "0";
        System.out.println(ll.multiply(num1, num2));
    }

    public void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null){
            return "0";
        }

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();

        // 保存乘法结果
        int[] result = new int[len1 + len2];

        for(int i = len1 - 1; i >= 0; i--){
            for(int j = len2 - 1; j >= 0; j--){
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j)  - '0') + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        // 将数组转为字符串，忽略前面的0
        String res = "";
        int flag = 0;
        for(int i : result){
            if(i == 0 && flag == 0){
                continue;
            }else{
                res += i;
                flag = 1;
            }
        }
        
        return res;
    }
}