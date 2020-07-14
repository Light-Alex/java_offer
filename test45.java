/**
 * 题目：把数组排成最小的数
 * 题目描述：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

/**
 * 方法：冒泡排序
 * 有数组{a, b, c}
 * 若a + b < b + a, 则把a排在前面
 * 例如3 32，因为 323 < 332，所以把32排在前面
 */
public class test45 {
    public static void main(String[] args) {
        test45 t = new test45();
        int[] numbers = {3334,3,3333332};
        System.out.println(t.PrintMinNumber(numbers));
    }

    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length < 1){
            return "";
        }

        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0; j < numbers.length - 1 - i; j++){
                // 这里使用Long，接收更大范围的数
                if(Long.parseLong(("" + numbers[j] + numbers[j+1])) > Long.parseLong(("" + numbers[j+1] + numbers[j]))){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        String result = "";
        for(int i : numbers){
            result += i;
        }
        return result;
    }
}