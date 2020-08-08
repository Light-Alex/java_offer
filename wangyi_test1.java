import java.util.Scanner;

/**
 * 题目：素数的个数
 * 
 */
public class wangyi_test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long count = sc.nextInt();
            long result = 0;
            // HashMap<Long, Long> map = new HashMap<Long, Long>();
            for(long i = 0; i < count; i++){
                long a = sc.nextInt();
                result += numOfResult(a);
            }
            System.out.println(result);
        }
    }

    public static long numOfResult(long num){
        if(num <= 1){
            return 0;
        }

        long result = num / 2;

        return result;
    }
}