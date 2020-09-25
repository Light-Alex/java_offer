import java.util.ArrayList;

public class h3c_exam_2 {
    public static void main(String[] args) {
        
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 
     * @param val long长整型 
     * @return long长整型
     */
    public long MidFactor (long val) {
        // write code here
        ArrayList<Long> list = new ArrayList<>();
        for(long i = 1; i <= val; i++){
            if(val % i == 0){
                list.add(i);
            }
        }

        int len = list.size();
        if(len % 2 == 0){
            return list.get(len / 2 - 1);
        }else{
            return list.get(len / 2);
        }
    }
}