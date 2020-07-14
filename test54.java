/**
 * 题目：翻转单词顺序列
 * 题目描述：牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */

// 方法：交换前后元素的顺序

public class test54 {
    public static void main(String[] args) {
        String str = new String(" ");
        test54 t = new test54();
        System.out.println(t.ReverseSentence(str));
        
        // // false
        // System.out.println(str == " ");
        // // 1
        // System.out.println(str.length());
        // // true
        // System.out.println(str.equals(" "));
    }

    public String ReverseSentence(String str) {
        if(str == null || str.length() < 1){
            return "";
        }

        String[] stringArray = str.split(" ");

        if(stringArray.length == 0){
            return str;
        }

        for(int i = 0; i < stringArray.length / 2; i++){
            String temp = stringArray[i];
            stringArray[i] = stringArray[stringArray.length - 1 - i];
            stringArray[stringArray.length - 1 - i] = temp;
        }

        return String.join(" ", stringArray);
    }
}