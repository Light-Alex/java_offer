public class zijie {
    public static void main(String[] args) {
        int[] array = {-2, -1, 3, 6, -3, 4};

        System.out.println("最大子数组和: " + zijie.maxSum(array));
        System.out.println("最大子数组: ");
        zijie.printArray(zijie.maxSumArray(array));
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * 和最大的连续的子数组，返回maxSum
     * 例子: {-2, -1, 3, 6, -3, 4}
     * 返回: 10
     */
    public static int maxSum(int[] array){
        if(array == null || array.length < 1){
            return (Integer) null;
        }

        int maxSum = array[0];

        for(int i = 0; i < array.length; i++){
            int temp = 0;
            for(int j = i; j < array.length; j++){
                temp += array[j];
                maxSum = temp > maxSum ? temp : maxSum;
            }
        }

        return maxSum;
    }
    
    /**
     * 和最大的连续的子数组，返回该子数组
     * 例子: {-2, -1, 3, 6, -3, 4}
     * 返回: {3, 6, -3, 4}
     */
    public static int[] maxSumArray(int[] array){
        if(array == null || array.length < 1){
            return null;
        }

        int maxSum = array[0];
        int start = 0;
        int end = 1;

        for(int i = 0; i < array.length; i++){
            int temp = 0;
            for(int j = i; j < array.length; j++){
                temp += array[j];
                maxSum = temp > maxSum ? temp : maxSum;
                if(maxSum == temp){
                    start = i;
                    end = j + 1;
                }
            }
        }

        int[] maxSumArray = new int[end - start];
        int k = 0;
        
        for(int i = start; i < end; i++){
            maxSumArray[k++] = array[i];
        }

        return maxSumArray;
    }
}

/**
 * 单例模式
 */
// 饿汉式单例模式
class Singleton1 {
    // 构造函数私有化
    private Singleton1(){}

    // 类加载的时候即已经实例化
    private static final Singleton1 instence = new Singleton1();

    // 提供公有的实例获取方法
    public static Singleton1 getInstance(){
        return instence;
    }
}

// 懒汉式单例模式(非线程安全的)
class Singleton2 {
    // 构造函数私有化
    private Singleton2(){}

    // 类加载的时候没有实例化
    private static Singleton2 instance = null;

    // 提供公有的实例获取方法
    public static Singleton2 getInstance(){
        // 调用getInstance()方法时才为instance赋值
        if(instance == null){
            instance = new Singleton2();
        }

        return instance;
    }
}

// 懒汉式单例模式-双重检查模式(线程安全)
class Singleton3 {

    // 构造函数私有化
    private Singleton3() {}

    // volatile声明的作用即是内存变量共享的作用(实现可见性和有序性)
    private static volatile Singleton3 instance = null;

    // 提供公共的实例获取方法
    public static Singleton3 getInstance(){
        // 先判断instance变量是否为空，如果为空，再进入同步代码块，如果不判断，那么每次调用该方法时，不管该对象是否创建，都会进入同步代码块，线程开销大
        if(instance == null){
            synchronized(Singleton3.class){
                // 如果不做判断，当前线程即使创建了实例，下一个线程也不知道，就会继续创建一个实例
                if(instance == null){
                    instance = new Singleton3();
                }
            }
        }
        
        return instance;
    }
}

// 懒汉式单例模式-静态内部类实现(重点)
class Singleton4 {

    // 构造函数私有化
    private Singleton4(){}

    /**
     * 静态内部类和非静态内部类一样，都不会因为外部类的加载而加载，
     * 同时静态内部类的加载不需要依附外部类，在使用时才加载，不过在加载静态内部类的过程中也会加载外部类
     */
    // 静态内部类不会在一开始被加载，所以没有内存消耗问题
    // JVM加载静态内部类是线程安全的，只有在使用内部类才会去加载，所以线程是安全的
    private static class SingletonInstance {
        private static final Singleton4 instance = new Singleton4();
    }
    
    // 提供静态的公共实例获取方法(加同步锁)
    public static synchronized Singleton4 getInstance(){
        return SingletonInstance.instance;
    }
}

/**
 * SQL基础
 * https://github.com/Light-Alex/fullstack-tutorial/blob/master/notes/SQL.md
 * 1、INNER JOIN、LEFT JOIN、RIGHT JOIN、FULL JOIN
 * 概念: SQL中连接查询的四种方式，它们之间其实并没有太大的区别，仅仅是查询出来的结果有所不同
 * 
 * · INNER JOIN(内连接): 在两张表进行连接查询时，只保留两张表中完全匹配的结果集
 * ep: 
 * SELECT Persons.LastName, Persons.FirstName, Orders.OrderNo
 * FROM Persons
 * INNER JOIN Orders
 * ON Persons.Id_P = Orders.Id_P
 * ORDER BY Persons.LastName
 * 结果：此种连接方式，Orders表中Id_P字段在Persons表中找不到匹配的，则不会列出来
 * 
 * · LEFT JOIN(左连接): 在两张表中进行连接查询时，会返回左表所有的行，即使在右表中没有匹配的记录
 * ep:
 * SELECT Persons.LastName, Persons.FirstName, Orders.OrderNo
 * FROM Persons
 * LEFT JOIN Orders
 * ON Persons.Id_P = Orders.Id_P
 * ORDER BY Persons.LastName
 * 结果：左表(Persons表)中LastName为Bush的行的Id_P字段在右表(Orders表)中没有匹配，但查询结果仍然保留该行
 * 
 * · RIGHT JOIN(右连接): 在两张表中进行连接查询时，会返回右表中所有的行，即使在左表中没有匹配的记录
 * ep:
 * SELECT Persons.LastName, Persons.FirstName, Orders.OrderNo
 * FROM Persons
 * RIGHT JOIN Orders
 * ON Persons.Id_P = Orders.Id_P
 * ORDER BY Persons.LastName
 * 结果：右表(Orders表)中最后一条记录Id_P字段值为65，在左表(Persons)中没有记录与之匹配，但依然保留
 * 
 * · FULL JOIN(全连接): 在两张表中进行连接查询时，会返回两张表中所有的行，即使是没有匹配的行
 * ep:
 * SELECT Persons.LastName, Persons.FirstName, Orders.OrderNo
 * FROM Persons
 * FULL JOIN Orders
 * ON Persons.Id_P = Orders.Id_P
 * ORDER BY Persons.LastName
 * 结果：查询结果是两张表所有的行，包括没有匹配的行，也是LEFT JOIN(左连接)查询和RIGHT JOIN(右连接)查询的并集
 */

/**
 * Linux命令
 * · 在当前目录递归查找文件，是否有a.log
 * find ./ -name a.log
 * 
 * · 当前目录下包含'hello world'内容的文件
 * 方式一：grep -rn "hello world" ./ (r表示递归，n表示查询结果显示行号)
 * 方式二：find ./ -name "*.*" | xargs grep "hello world"
 * 方式三：find . | xargs grep -ri "hello world"(-i表示忽略字符大小写的差别) 或者 find . | grep -ri "hello world" -l (-l表示只显示文件名)
 */

/**
 * 进程和线程的区别：
 * https://zhuanlan.zhihu.com/p/46410285
 */