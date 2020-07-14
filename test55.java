/**
 * 题目: 扑克牌顺子
 * 题目描述: LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 */

/**
 * 方法: 对数组进行排序, 统计0的数目, 若前后元素差值>1, 则用多出来的部分去抵消0, 若多出来的部分多于0的数目则返回false
 * 1、若数组的长度 < 5, 则返回false
 * 2、若存在相同的非0元素，则返回false
 * 3、对数组进行排序，统计0的数目zeroCount, 从zeroCount(第一个非零元素)往后遍历, 计算相邻元素的差值，差值=0, 返回false, 差值=1，继续往后遍历，差值>1, 多出1的部分用0的数目来抵, 0的数目<0了则返回false
 */

public class test55 {
    public static void main(String[] args) {
        
    }

    public boolean isContinuous(int [] numbers) {
        if(numbers.length < 5){
            return false;
        }

        // 对numbers数组排序
        quickSort(numbers, 0, numbers.length - 1);

        int zeroCount = 0;

        for(int i : numbers){
            if(i == 0){
                zeroCount++;
            }else{
                break;
            }
        }

        for(int i = zeroCount; i < numbers.length - 1; i++){
            if(numbers[i + 1] - numbers[i] == 0){
                return false;
            }else if(numbers[i + 1] - numbers[i] == 1){
                continue;
            }else{
                int difference = numbers[i + 1] - numbers[i] - 1;
                zeroCount -= difference;
                if(zeroCount < 0){
                    return false;
                }
            }
        }

        return true;
    }

    // 快速排序
    public void quickSort(int[] array, int left, int right){
        if(left >= right){
            return;
        }

        int first = left;
        int last = right;
        int temp = array[left];

        while(first < last){
            while(first < last && array[last] >= temp){
                last--;
            }
            if(first < last){
                array[first++] = array[last];
            }

            while(first < last && array[first] <= temp){
                first++;
            }
            if(first < last){
                array[last--] = array[first];
            }
        }

        array[first] = temp;

        quickSort(array, left, first - 1);
        quickSort(array, first + 1, right);
    }
}