import java.util.Scanner;

public class dianxin_exam_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(getUgly(num));
    }

    private static int getUgly(int i){
        int min = 0;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int[] a = new int[i];
        a[0] = 1;
        for(int count = 1; count < i; count++){
            min = min(a[i2] * 2, a[i3] * 3, a[i5] * 5);
            a[count] = min;
            while(a[i2] * 2 <= min){
                i2++;
            }
            while(a[i3] * 3 <= min){
                i3++;
            }
            while(a[i5] * 5 <= min){
                i5++;
            }
        }
        return a[i-1];
    }

    private static int min(int a, int b, int c){
        int temp = a > b ? b : a;
        return temp > c ? c : temp;
    }

    public static boolean isUgly(int num){
        if(num < 1){
            return false;
        }else{
            while(num % 2 == 0){
                num = num / 2;
            }
            while(num % 3 == 0){
                num = num / 3;
            }
            while(num % 5 == 0){
                num = num / 5;
            }

            if(num == 1){
                return true;
            }else{
                return false;
            }
        }
    }
}