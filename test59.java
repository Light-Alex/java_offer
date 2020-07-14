/**
 * 题目：构建乘积数组
 * 题目描述：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */

/**
 * 方法：
 * A = {2, 3, 4, 5, 6}
 * 设B[0] = 1, B后面的数依次保存A前面乘积的结果(乘到倒数第二个数)
 * B = {1, 2, 6, 24, 120}, 然后从后往前更新B
 * 120 = 2 * 3 * 4 * 5, 不差值
 * 24 = 2 * 3 * 4, 差6
 * 6 = 2 * 3，差5 * 6
 * 2 = 2, 差 4 * 5 * 6
 * 1 = 1, 差 3 * 4 * 5 * 6
 */

public class test59 {
    public static void main(String[] args) {
        
    }

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if(A.length < 1){
            return B;
        }

        B[0] = 1;
        for(int i = 1; i < B.length; i++){
            B[i] = B[i-1] * A[i-1];
        }

        int temp = 1;
        for(int i = B.length - 2; i >= 0; i--){
            temp *= A[i+1];
            B[i] = B[i] * temp;
        }

        return B;
    }
}