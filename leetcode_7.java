/**
 * 题目：最长公共子序列
 * 
 * 方法：需要维护一个状态方程
 */
public class leetcode_7 {
    public static void main(String[] args) {
        leetcode_7 ll = new leetcode_7();
        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(ll.longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] status = new int[len1+1][len2+1];

        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);

                if(c1 == c2){
                    status[i+1][j+1] = status[i][j] + 1;
                }else{
                    status[i+1][j+1] = Math.max(status[i+1][j], status[i][j+1]);
                }
            }
        }

        return status[len1][len2];
    }
}