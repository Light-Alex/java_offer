public class leetcode_3 {
    public static void main(String[] args) {

        leetcode_3 l = new leetcode_3();
        System.out.println(l.findKthBit(2, 3));
    }

    public char findKthBit(int n, int k) {
        
        String temp = "0";
        for(int i = 1; i < n; i++){

            char[] tempArray = temp.toCharArray();
            for(int j = 0; j < tempArray.length; j++){
                if(tempArray[j] == '0'){
                    tempArray[j] = '1';
                }else{
                    tempArray[j] = '0';
                }
            }
            
            
            swapString(tempArray);
            temp += "1";
            temp += new String(tempArray);
            
        }
        
        return temp == "" ? '0' : temp.charAt(k-1);
    }

    public void swapString(char[] charArray){
        for(int i = 0; i < charArray.length / 2; i++){
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = temp;
        }
    }
}