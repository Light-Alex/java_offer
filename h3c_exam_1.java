import java.util.HashMap;

public class h3c_exam_1 {
    public static void main(String[] args) {
        
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 请实现一个输入联想功能
     * @param str string字符串 查找字符串
     * @return string字符串
     */
    public static String character_auto_complete (String str) {
        // write code here
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("M", "Monday");
        map.put("T", "Tuesday Thursday");
        map.put("W", "Wednesday");
        map.put("F", "Friday");
        map.put("S", "Saturday Sunday");
        // String s = "hello";
        // s.contains(s);

        if(map.containsKey(str)){
            return map.get(str);
        }else{
            return "No match";
        }
    }
}