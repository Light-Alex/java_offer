import java.util.ArrayList;

public class leetcode_2 {
    public static void main(String[] args) {
        leetcode_2 l = new leetcode_2();
        String s = "leEeetcode";
        l.makeGood(s);
    }

    public String makeGood(String s) {
        char[] charArray = s.toCharArray();
        ArrayList<Character> newCharArray = new ArrayList<Character>();
        for(char c : charArray){
            newCharArray.add(c);
        }

        while(hasDuplicate(newCharArray)){
            
            for(int i = 0; i < newCharArray.size(); i++){
                if(i < newCharArray.size() - 1 && Math.abs(newCharArray.get(i) - newCharArray.get(i+1)) == 32){
                    newCharArray.remove(i);
                    newCharArray.remove(i);
                    break;
                }else{
                    continue;
                }
            }
        }

        String result = "";
        for(char c : newCharArray){
            result += c;
        }

        return result;
    }

    public static boolean hasDuplicate(ArrayList<Character> charArray){
        for(int i = 0; i < charArray.size() - 1; i++){
            if(Math.abs(charArray.get(i) - charArray.get(i+1)) == 32){
                return true;
            }
        }

        return false;
    }
}