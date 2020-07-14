/**
 * 题目：替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

/**
 * 方法三：把字符串转换为字符数组, str.toCharArray()
 */


public class test5_3 {
    public static void main(String[] args) {
        test5_3 t = new test5_3();
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(t.replaceSpace(str));
    }

    public String replaceSpace(StringBuffer str) {
        String str1 = str.toString();
        char c[] = str1.toCharArray();
        String result = "";

        for(int i = 0; i < c.length; i++){
            if(c[i] == ' '){
                result += "%20";
            }else{
                result += c[i];
            }
        }

        return result;
    }
}