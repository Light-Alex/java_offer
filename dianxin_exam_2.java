public class dianxin_exam_2 {
    public static void main(String[] args) {

        for(int a = 0; a < 10; a++){
            for(int b = 0; b < 10; b++){
                for(int c = 0; c < 10; c++){
                    for(int d = 0; d < 10; d++){
                        String s1 = "" + a + b + c + d;
                        String s2 = "" + b + c + d + a;
                        int num1 = Integer.valueOf(s1);
                        int num2 = Integer.valueOf(s2);
                        if(num1 + num2 == 8888){
                            System.out.println(a + " " + b + " " + c + " " + d);
                        }
                    }
                }
            }
        }
    }
}