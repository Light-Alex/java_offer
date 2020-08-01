import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目: 真假轨迹
 * 
 * 输入描述：
 * 每个样例输入如下
 * 第一行2个值，n1(1<n1<=1000000)表示推送的轨迹条数目
 * n2(1<n2<1000000)表示调用接口获取的轨迹数目
 * 接下来会有n1个数字(0<=x<=10000000)表示时间
 * X1, X2, X3, ..., Xn1
 * 接下来会有n2个数字(0<=x<=10000000)表示时间
 * Y1, Y2, Y3, ..., Yn2
 * 
 * 输出描述：
 * 求合并后的最长轨迹条目数
 * 示例1：
 * 输入：
 * 5 6
   1 2 3 4 9
   4 5 6 7 8 10

   输出：
   10

   说明：
   样例解析：[1 2 3 4 9] 取前半段 [1 2 3 4], [4 5 6 7 8 10] 取后半段，
   这样可得到最长轨迹[1 2 3 4 4 5 6 7 8 10], 长度为10
 */

public class shopee_test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            int[] arr1 = new int[n1];
            int[] arr2 = new int[n2];
            for(int i = 0; i < n1; i++){
                arr1[i] = sc.nextInt();
            }
            for(int i = 0; i < n2; i++){
                arr2[i] = sc.nextInt();
            }

            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(arr1[0]);
            int temp = arr1[0];
            for(int i = 1; i < arr1.length; i++){
                if(arr1[i] >= temp && arr1[i] <= arr2[0]){
                    list.add(arr1[i]);
                }else{
                    break;
                }
            }
            list.add(arr2[0]);
            temp = arr2[0];
            for(int i = 1; i < arr2.length; i++){
                if(arr2[i] >= temp){
                    list.add(arr2[i]);
                }else{
                    break;
                }
            }

            System.out.println(list.size());
        }
    }
}