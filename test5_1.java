/**
 * 题目：替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

// 方法一：
// 使用StringBuffer的一些库函数实现
// str.charAt(int index): 返回在index位置处的字符

public class test5_1 {
    public static void main(String[] args) {
        test5_1 t = new test5_1();
        StringBuffer out = new StringBuffer("We Are Happy");
        System.out.println(t.replaceSpace(out));
    }

    public String replaceSpace(StringBuffer str) {
        StringBuffer out = new StringBuffer();
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                out.append("%20");
            }else{
                out.append(str.charAt(i));
            }
        }

        return out.toString();
    }
}