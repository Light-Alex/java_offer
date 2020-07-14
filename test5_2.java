/**
 * 题目：替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

/**
 * 方法二：使用String的replaceAll()方法
 */


public class test5_2 {
    public static void main(String[] args) {
        test5_2 t = new test5_2();
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(t.replaceSpace(str));
    }

    public String replaceSpace(StringBuffer str) {
    	return str.toString().replaceAll(" ", "%20");
    }
}