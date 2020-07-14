/**
 * 题目: 把字符串转换成整数
 * 题目描述: 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 
 * 例子:
 * 输入:
 * +2147483647
   1a33

   输出:
   2147483647
   0
 */

/**
 * 方法: 将字符串转化为字符数组, 遍历该字符数组, 如果有符号位需要考虑符号位, 如果遇到数字字符则转化为整型(乘以相应的位数加入总数中)，如果遇到非数字字符则返回0
 * 例子：2147483647, 2 * Math.pow(10, charArray.length - i - 1)
 */

public class test57 {
    public static void main(String[] args) {
        String str = "+123";
        test57 t = new test57();
        System.out.println(t.StrToInt(str));
    }

    public int StrToInt(String str) {
        if(str == null || str.length() < 1){
            return 0;
        }

        char[] charArray = str.toCharArray();

        // 符号位
        int sign = 0;

        // 结果
        int result = 0;

        if(charArray[0] == '+'){
            sign = 1;
        }

        if(charArray[0] == '-'){
            sign = -1;
        }

        for(int i = Math.abs(sign); i < charArray.length; i++){
            if(charArray[i] >= '0' && charArray[i] <= '9'){
                // 注意：直接用(int) charArray[i]会返回字符的ASCLL码
                result += (charArray[i] - '0') * Math.pow(10, charArray.length - i - 1);   
            }else{
                return 0;
            }
        }

        return sign != 0 ? result * sign : result;
    }
}