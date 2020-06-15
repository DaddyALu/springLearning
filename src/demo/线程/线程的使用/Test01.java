package demo.线程.线程的使用;

public class Test01 {

    public static void main(String[] args) {

        //线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName()+" --> "+i);
                }
            }
        },"线程t1");  //通过构造方法指定线程名称
//        t1.setName("线程t1");  //也可以通过setName方法来指定线程名
        t1.setDaemon(true);  //设置t1为守护线程，当JVM中只存在守护线程时，JVM就会退出
        t1.start();

        //线程2
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName()+" ++> "+i);
                }
            }
        }).start();  //没有指定该线程的名字，默认名为Thread-0，之后未命名的线程名以此类推

        //main线程
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName()+" **> "+i);
        }

        System.out.println(t1.isAlive());  //判断线程是否终止。当线程的run()方法执行介绍，该线程就终止。

    }
}
