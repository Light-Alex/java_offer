import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 * 题目：采购员
 * 
 * 题目描述：
 * 2020年春节之际，新冠肺炎爆发，国内医疗资源大量紧缺。小明作为一位采购员，被派到国外采购紧缺物资。由于国内需要的物资种类很多，不同品牌种类的
 * 物资在疫情中的使用价值也不同，在了解商品情况后，小明开始为采购哪些物资才最合适而烦恼。假如给定了采购预算T，每种物资的价格Pn和使用价值Wn，每种物资的可采购数量不限，
 * 你能帮他快速决定出应该采购的物资吗？要求采购物资的总价格不能超过采购预算，在这个前提下给出的采购列表使得这批物资的使用价值最大。
 * 
 * 输入描述：
 * 每个测试输入包含一个测试用例，第一行是总预算，第二行是物资种类总数n；
 * 后面有n行数据，每行代表一种物资的价格和使用价值，被空格分隔
 * 例如：第三行数据中，第一列是物资1的价格p1，第二列是物资2的使用价值
 * 
 * 输出描述：
 * 输出采购物资能达到的最高使用价值，格式是单独的一行数值
 * 
 * 示例：
 * 输入：
 * 100
   5
   77 92
   22 22
   29 36
   50 46
   99 90

   输出：
   114

   说明：
   100预算、5种商品情况下，购买1个商品一 和 一个商品二 可以达到最大使用价值114
   
   示例2:
   
   输入：
   200
   8
   79 83
   58 81
   86 54
   110 150
   62 52
   45 48
   68 62
   30 22
   
   输出：
   253
 */

public class test1 {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      while (sc.hasNext()){
          int budget = sc.nextInt();
          int count = sc.nextInt();
          ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
          for(int i = 0; i < count; i++){
              ArrayList<Integer> temp = new ArrayList<Integer>();
              temp.add(sc.nextInt());
              temp.add(sc.nextInt());
              list.add(temp);
          }

          double[] a = new double[list.size()];

          for(int i = 0; i < a.length; i++){
              a[i] = list.get(i).get(1) / list.get(i).get(0);
          }

          Collections.sort(list, new Comparator<ArrayList<Integer>>() {
              @Override
              public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                  return new Double ((o2.get(1).doubleValue() / o2.get(0))).compareTo(new Double ((o1.get(1).doubleValue() / o1.get(0))));
              }
          });


      }
  }
}