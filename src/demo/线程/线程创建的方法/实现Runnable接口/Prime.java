package demo.线程.线程创建的方法.实现Runnable接口;

// 1）定义Runnable接口的实现类 (方法一中，定义了一个继承Thread的方法，而实际上Thread类就是一个Runnable接口的实现类)
public class Prime implements Runnable{

    // 2）重写run()方法，run方法体就是用户线程执行的代码
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("sub thread : " + i);
        }
    }

}
