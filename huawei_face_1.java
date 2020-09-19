import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class huawei_face_1{
    public static void main(String[] args) {

        int[][] array = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

        for(int[] arr : array){
            int index = arr[0];
            int score = arr[1];
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            if(!map.containsKey(index)){
                tempList.add(score);
                map.put(index, tempList);
            }else{
                map.get(index).add(score);
            }
        }

        for(int i : map.keySet()){
            // Collections.sort(map.get(i));
            Collections.sort(map.get(i), new Comparator<Integer>(){

                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
                
            });
        }

        // System.out.println(map);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i : map.keySet()){
            int sum = 0;
            // int len = map.values().size();
            int len = map.get(i).size();
            int count = 0;
            for(int j = len - 1; j >= 0; j--){
                sum += map.get(i).get(j);
                count++;
                if(count == 5){
                    break;
                }
            }
            
            int avr = sum / 5;
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(avr);
            result.add(temp);
        }

        System.out.println(result);
    }


}