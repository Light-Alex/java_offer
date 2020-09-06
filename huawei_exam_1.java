import java.util.ArrayList;
import java.util.Scanner;

public class huawei_exam_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        char index = 'a';

        while(sc.hasNext()){
            String s = sc.next();
            if(s.length() == 1){
                index = s.charAt(0);
                break;
            }
            list.add(s);
            count++;
        }

        if(count > 20){
            for(String s : list){
                System.out.println(s);
            }
        }

        String comp = sc.next();
        String temp = "";
        for(char c : comp.toCharArray()){
            if(c < index){
                temp += c;
            }
        }

        for(String s : list){
            String compS = "";
            for(char c : s.toCharArray()){
                if(c < index){
                    compS += c;
                }
            }
            if(compS.contains(temp)){
                System.out.println(s);
            }
        }
        
    }
}