import java.util.Scanner;

public class dianxin_exam_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sArray = s.split(",");
        int len = sArray.length;
        
        System.out.println(maxSum(sArray, len - 1));
    }

    public static int maxSum(String[] sArray, int len){
        if(len == 0){
            return Integer.valueOf(sArray[0]);
        }else if(len == 1){
            return Math.max(Integer.valueOf(sArray[0]), Integer.valueOf(sArray[1]));
        }else{
            int a = maxSum(sArray, len - 2) + Integer.valueOf(sArray[len]);
            int b = maxSum(sArray, len - 1);
            return Math.max(a, b);
        }
    }

    public static void printArray(String[] sArray){
        for(String s : sArray){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}