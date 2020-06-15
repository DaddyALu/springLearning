package demo.反射.创建Class对象;

/**
 * 创建Class对象的方式
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1）每个类都有一个Class类型的class属性
        Class class1 = Test01.class;

        // 2）每个对象都有getClass()方法
        Class class2 = new Test01().getClass();

        // 3）Class.forName(类的完整类名：右键该类 --> Copy Reference);
        Class class3 = Class.forName("demo.反射.创建Class对象.Test01");

        System.out.println(class1);  //class demo.反射.创建Class对象.Test01
        System.out.println(class2 == class1);  //true
        System.out.println(class3 == class2);  //true

        // 4）用占位符作为泛型
        Class<?> class4 = int.class;
        Class<?> class5 = Integer.class;
        Class<?> class6 = Integer.TYPE;

        System.out.println(class4 == class5);  //false，一个是基本类型，一个是包装类
        System.out.println(class4 == class6);  //true

        // 5）Class.forName()返回Class对象时，会把参数指定的类加载到内存中
        Class<?> class7 = Person.class;  //没有执行Person类的静态代码块，说明Person类没有加载内存
        Class<?> class8 = Class.forName("demo.反射.创建Class对象.Person");  //执行了静态代码块，Person类加载了内存

        Person p = new Person();  //如果之前没有加载过Person，这里也会加载Person类，执行其静态代码块；一个进程中只会加载一次
        //另一个线程新建Person类对象，但是该类已经加载过，也不会再次加载
        new Thread(new Runnable() {
            @Override
            public void run() {
                Person p = new Person();
            }
        }).start();
    }
}
