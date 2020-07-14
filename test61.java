import java.util.Arrays;

/**
 * 题目：表示数值的字符串
 * 题目描述：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */

/**
 * 方法：判断字符串中是否含有'e'或'E'
 * 1、若字符串中含有'e'或'E', 则以这个'e'或'E'位分界线将字符串分成前后两个部分，分别判断前面部分是否是小数(或整数)以及后面部分是否是整数即可
 * 2、若字符串中不含有'e'或'E'，则直接判断该字符串是不是一个小数或整数即可
 */

public class test61 {
    public static void main(String[] args) {
        char[] str = "123.45e+6".toCharArray();
        test61 t = new test61();
        System.out.println(t.isNumeric(str));
    }

    public boolean isNumeric(char[] str) {
        if(str.length < 1 || charCount(str, 'e') + charCount(str, 'E') > 1){
            return false;
        }

        int eIndex = 0;
        for(; eIndex < str.length; eIndex++){
            if(str[eIndex] == 'e' || str[eIndex] == 'E'){
                break;
            }
        }
        System.out.println(eIndex);
        // 字符串中含有e或E
        if(eIndex < str.length){
            // 判断前面部分是否是小数(或整数)以及后面部分是否是整数
            return isDecimal(Arrays.copyOfRange(str, 0, eIndex)) && isInteger(Arrays.copyOfRange(str, eIndex + 1, str.length));
        // 字符串中不含有e或E，则判断该数是不是一个整数或小数
        }else{
            return isDecimal(str);
        }
    }

    // 统计某个字符的数目
    public int charCount(char[] str, char target){
        int count = 0;
        for(char c : str){
            if(c == target){
                count++;
            }
        }
        return count;
    }

    // 判断一个字符串是不是整数
    public boolean isInteger(char[] str){
        if(str.length < 1 || (str.length == 1 && str[0] == '+') || (str.length == 1 && str[0] == '-')){
            return false;
        }

        // 是否有符号位
        int sign = 0;

        if(str[0] == '+' || str[0] == '-'){
            sign = 1;
        }

        for(int i = sign; i < str.length; i++){
            if(str[i] < '0' || str[i] > '9'){
                return false;
            }
        }

        return true;
    }

    // 判断一个字符串是不是小数(或者整数)
    public boolean isDecimal(char[] str){
        if(str.length < 1 || (str.length == 1 && str[0] == '+') || (str.length == 1 && str[0] == '-') || charCount(str, '.') > 1){
            return false;
        }

        // 是否有符号位
        int sign = 0;

        if(str[0] == '+' || str[0] == '-'){
            sign = 1;
        }

        for(int i = sign; i < str.length; i++){
            if((str[i] < '0' || str[i] > '9') && str[i] != '.'){
                return false;
            }
        }

        return true;
    }
}