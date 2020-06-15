package demo.线程.线程创建的方法.继承Thread;

/**
 * 创建线程方法一
 */
public class MainTest {

    public static void main(String[] args) {

        // 3）创建线程对象
        SubThread t1 = new SubThread();

        // 4）开启(启动)新的线程
        t1.start();  //启动新的线程，它就会执行run()方法；类似于我们启动主线程，主线程会自动执行main()方法。
//        t1.run();  //run()方法就是普通的实例的调用，它不会开启新线程

        //当前线程是main线程
        for (int i = 0; i < 100; i++) {
            System.out.println("main -->" + i);
        }

        /**
         * 当前程序有main线程和t1线在同时执行，每次执行的结果可能不一样；
         *
         * 多线程程序中的线程，同时争抢CPU执行权，抢到后才会执行；
         *
         * 在单核的CPU中，某一个时刻CPU只能执行一个任务，因为CPU的执行速度非常快，可以快速地在各个线程之间切换 ，
         * 只是对于用户来说，感觉是多个线程在同时进行。
         *
         *      3GHz：CPU中的晶振器，每秒可以发出3G次震动（3*1024*1024*1024）
         *
         */

    }

}
