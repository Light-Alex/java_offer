/**
 * 题目：数值的整数次方
 * 题目描述：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class test42 {
    public static void main(String[] args) {
        
    }

    public double Power(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }

        double result = 1.0;

        if(exponent > 0){
            for(int i = 0; i < exponent; i++){
                result *= base;
            }
        }else{
            for(int i = 0; i < -exponent; i++){
                result *= base;
            }
            result = 1 / result;
        }

        return result;
    }
}