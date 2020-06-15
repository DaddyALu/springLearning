package demo.线程.线程创建的方法.继承Thread;

// 1）定义类，继承Thread
public class SubThread extends Thread {

    // 2）重写run()方法，run()方法体中的代码就是子线程要执行的代码
    @Override
        //command + n 快捷键展开可重写的方法列表
    public void run() {
        //在子线程，打印100行字符串
        for (int i = 0; i < 100; i++) {
            System.out.println("sub thread :" + i);
        }
    }
}
