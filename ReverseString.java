public class ReverseString {
    public static void main(String[] args) {
        String s = "hello2";
        char[] charArray = s.toCharArray();
        reverseString(charArray, 0, s.length() - 1);
        System.out.println(String.valueOf(charArray));
    }

    public static void reverseString(char[] charArray, int left, int right){
        if(left >= right){
            return;
        }

        char c = charArray[left];
        charArray[left] = charArray[right];
        charArray[right] = c;

        reverseString(charArray, ++left, --right);
    }
}