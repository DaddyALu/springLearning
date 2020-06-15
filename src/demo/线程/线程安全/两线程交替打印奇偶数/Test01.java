package demo.线程.线程安全.两线程交替打印奇偶数;

public class Test01 {

    public static void main(String[] args) {

        PrintNum p = new PrintNum();

        //这里的两个线程可以分别封装成一个类

        //奇数打印线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    p.printOdd();
                }
            }
        }).start();

        //偶数打印线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    p.printEven();
                }
            }
        }).start();

    }
}
