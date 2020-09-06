import java.util.ArrayList;
import java.util.Scanner;

public class huawei_exam_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] temp = s.split(";");
        String source = temp[0].toLowerCase();
        String target = temp[1].toLowerCase();
        
        String[] sourceWords = source.split(" ");
        String[] targetWords = target.split(" ");

        int len = targetWords.length;
        int count = len + 1;

        ArrayList<String> sourceList = new ArrayList<>();
        ArrayList<String> targetList = new ArrayList<>();

        for(int i = 0; i < len - 1; i++){
            targetList.add(targetWords[i]);
        }
        String tarLast = targetWords[len-1];
        int indexTar = 0;
        for(;indexTar < tarLast.length(); indexTar++){
            if(tarLast.charAt(indexTar) == ',' || tarLast.charAt(indexTar) == '.' || tarLast.charAt(indexTar) == '!' || tarLast.charAt(indexTar) == '?'){
                break;
            }
        }
        String tarLastWord = tarLast.substring(0, indexTar);
        String tarSign = tarLast.substring(indexTar);
        targetList.add(tarLastWord);

        int len2 = sourceWords.length;
        for(int i = 0; i < len2 - 1; i++){
            sourceList.add(sourceWords[i]);
        }
        String sourceLast = sourceWords[len2-1];
        int indexSour = 0;
        for(;indexSour < sourceLast.length(); indexSour++){
            if(sourceLast.charAt(indexSour) == ',' || sourceLast.charAt(indexSour) == '.' || sourceLast.charAt(indexSour) == '!' || sourceLast.charAt(indexSour) == '?'){
                break;
            }
        }
        String sourceLastWord = sourceLast.substring(0, indexSour);
        String sourceSign = sourceLast.substring(indexSour);
        sourceList.add(sourceLastWord);

        int diff = 0;
        int sourceLen = sourceList.size();
        int targetLen = targetList.size();

        if(sourceLen == targetLen){
            for(int i = 0; i < sourceLen; i++){
                if(!sourceList.get(i).equals(targetList.get(i))){
                    diff += 2;
                }
            }
        }else if(sourceLen < targetLen){
            // int sourceI = 0;
            // int targetI = 0;
            diff += targetLen - sourceLen;
        }else{
            diff += sourceLen - targetLen;
        }

        char[] char1 = sourceSign.toCharArray();
        char[] char2 = tarSign.toCharArray();
        int len11 = char1.length;
        int len22 = char2.length;
        for(int i = 0; i < len11 && i < len22; i++){
            if((char1[i] == '?' && char2[i] != '?') || (char2[i] == '?' && char1[i] != '?')){
                diff++;
            }
        }
        diff += Math.abs(len11 - len22);

        System.out.print("(" + diff + "," + count + ")");
    }
}