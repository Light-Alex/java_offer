import java.util.ArrayList;
/**
 * 题目：和为S的连续正数序列
 * 题目描述：小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 
 * 输出描述：
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */

/**
 * 方法：
 * 定义两个指针pLow = 1, pHigh = 2, 计算pLow ~ pHight之间的和pSum
 * 若pSum < sum, 则pHigh++
 * 若pSum > sum, 则pLow++
 * 若pSum = sum, 则保存当前结果, 然后pLow++(或pSum++)继续寻找
 * 循环结束的条件是 pLow >= pHigh
 */
public class test51 {
    public static void main(String[] args) {
        test51 t = new test51();
        System.out.println(t.FindContinuousSequence(100));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(sum < 3){
            return result;
        }

        int pLow = 1;
        int pHigh = 2;

        while(pLow < pHigh){
            int pSum = (pLow + pHigh) * (pHigh - pLow + 1) >> 1;

            if(pSum < sum){
                pHigh++;
            }else if(pSum > sum){
                pLow++;
            }else{
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                for(int i = pLow; i <= pHigh; i++){
                    tempList.add(i);
                }
                result.add(tempList);
                pHigh++;
            }
        }

        return result;
    }
}