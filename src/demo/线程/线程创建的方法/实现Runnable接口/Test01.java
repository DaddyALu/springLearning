package demo.线程.线程创建的方法.实现Runnable接口;

/**
 * 创建线程方法二
 */
public class Test01 {

    public static void main(String[] args) {

        // 3）创建线程对象
        Prime p = new Prime();  //Runnable接口的实现类对象
        //Thread(Runnable)构造方法的形参是接口，在调用方法时传递该接口的实现类对象
        Thread t2 = new Thread(p);  //线程对象的创建

        // 4）开启线程
        t2.start();

        //在main线程执行
        for (int i = 0; i < 100; i++) {
            System.out.println("main --> " + i);
        }

        //可以使用实现类对象创建多个线程（相较于使用匿名内部类对象作为实参的好处，不用重复编写相同的代码）
        Thread t3 = new Thread(p);
        t3.start();

    }
}
