package demo.线程.线程安全.线程同步;

public class Test01 {

    public static void main(String[] args) {

        Test01 test01 = new Test01();

        //线程A
        new Thread(new Runnable() {
            @Override
            public void run() {
                test01.m1();
            }
        }).start();

        //线程B
        new Thread(new Runnable() {
            @Override
            public void run() {
                test01.m2();
            }
        }).start();

        //线程C
        new Thread(new Runnable() {
            @Override
            public void run() {
                Test01.m3();
            }
        }).start();

    }


    private static final Object OBJ = new Object();  //常量

    private void m1(){
        System.out.println("m1方法开始执行");
//        synchronized (OBJ){    //经常定义一个常量对象，作为锁对象
//        synchronized (this){     //有时也会使用this，来作为锁对象，这里调用m1和m2方法的都是test01对象，所以可以实现同步
        synchronized (Test01.class){        //有时也会使用当前类的运行时类对象，来作为锁对象
            for (int i = 0; i < 100; i++) {
                System.out.println("m1 --> " + i);
            }
        }
        System.out.println("m1方法结束执行");
    }

    private void m2(){
        System.out.println("m2方法开始执行");
//        synchronized (OBJ){
//        synchronized (this){
        synchronized (Test01.class){
            for (int i = 0; i < 100; i++) {
                System.out.println("m2 ******> " + i);
            }
        }
        System.out.println("m2方法结束执行");
    }

    //直接用synchronized修饰方法，使整个方法体作为同步代码块，默认锁对象是this对象
    //将该方法定义为静态方法，此时默认的锁对象，就是当前类的运行时类对象Test.01
    private static synchronized void m3(){  //静态方法
        System.out.println("m3方法开始执行");   //此时该输出必定是在某个方法输出结束语句后才输出
        for (int i = 0; i < 100; i++) {
            System.out.println("m3 ======> " + i);
        }
        System.out.println("m3方法结束执行");
    }

}
