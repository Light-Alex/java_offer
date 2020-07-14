import java.util.Arrays;

/**
 * 题目：正则表达式匹配
 * 题目描述：请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class test60 {
    public static void main(String[] args) {
        
    }

    public boolean match(char[] str, char[] pattern){
        // 如果str和pattern都为空，则返回true
        if(str.length == 0 && pattern.length == 0){
            return true;
        }

        // 如果str不为空, pattern为空则返回false
        else if(str.length != 0 && pattern.length == 0){
            return false;
        }

        // 如果str为空, pattern不为空则需要分情况讨论
        else if(str.length == 0 && pattern.length != 0){
            // 如果pattern的第一个字符为'*'则返回false
            if(pattern[0] == '*'){
                return false;
            }

            // 如果pattern的长度大于1, 同时pattern的第二个字符为'*', 则str不变, pattern后移两位递归判断，相当于'*'视它前面的那个字符出现了0次
            if(pattern.length > 1 && pattern[1] == '*'){
                return match(str, Arrays.copyOfRange(pattern, 2, pattern.length));
            // 其余情况返回false
            }else{
                return false;
            }
        }

        // 如果str和pattern都不为空
        else{
            // 如果pattern的第二个字符为'*'
            if(pattern.length > 1 && pattern[1] == '*'){
                // 如果str的第一个字符与pattern的第一个字符不相等, 同时pattern的第一个字符不为'.'，则str不变，将pattern后移两位, 相当于'*'视它前面的那个字符出现了0次
                if(pattern[0] != '.' && str[0] != pattern[0]){
                    return match(str, Arrays.copyOfRange(pattern, 2, pattern.length));
                /**
                 * 如果str的第一个元素与pattern的第一个元素相同，或pattern的第一个元素为'.'(即str和pattern第一位匹配), pattern的第二个元素为'*'，这个时候分两种情况：
                 * 1、pattern向后移两位，str不变，相当于pattern的第二个字符'*'视它前面那个元素不存在
                 * 2、str向后移动一位，pattern不变，相当于pattern前两位匹配了一次str的第一位，因为'*'表示前面那个元素出现了0次或多次, 所以还可以继续匹配str中的元素, 故pattern不变
                 */
                }else{
                    return match(str, Arrays.copyOfRange(pattern, 2, pattern.length)) || match(Arrays.copyOfRange(str, 1, str.length), pattern);
                }
            }
            // 如果pattern的第二个字符不为'*'，则str和pattern按位进行匹配
            else{
                // 如果pattern的第一个元素和str的第一个元素相等 或 pattern的第一个元素为'.'，则将str和pattern同时向后移动一位，表示第一位匹配了
                if(pattern[0] == '.' || str[0] == pattern[0]){
                    return match(Arrays.copyOfRange(str, 1, str.length), Arrays.copyOfRange(pattern, 1, pattern.length));
                // 第一位不匹配则返回false
                }else{
                    return false;
                }
            }
        }
    }
}