// 饿汉式
class Student1 {
    private Student1(){}

    private static final Student1 s = new Student1();

    public static Student1 getInstance(){
        return s;
    }
}

// 懒汉式
class Student2 {
    private Student2(){}

    private static Student2 s = null;

    public static Student2 getInstance(){
        if(s == null){
            s = new Student2();
        }

        return s;
    }
}

// 双重检查模式
class Student3 {
    private Student3(){}

    private static volatile Student3 s = null;

    public static Student3 getInstance(){

        if(s == null){
            synchronized(Student3.class){
                if(s == null){
                    s = new Student3();
                }
                
            }
        }

        return s;
    }
}

// 静态内部类
class Student4 {
    private Student4(){}

    private static class NewInstance{
        private static final Student4 s = new Student4();
    }

    public static Student4 getInstance(){
        return NewInstance.s;
    }
}