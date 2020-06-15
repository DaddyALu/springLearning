package demo.线程.线程创建的方法.实现Calllable接口;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 3）创建线程对象
        Prime p = new Prime();  //创建Callable接口实现类对象

        FutureTask<Integer> task = new FutureTask<>(p);
            // FutureTask<V>实现了RunnableFuture<V>，RunnableFuture<V>继承了Runnable；
            // 即，FutureTask类就是Runnable的实现类

        Thread t3 = new Thread(task);  //线程对象的创建

        // 4）开启新线程
        t3.start();

        //main线程
        System.out.println("当前线程是main线程，它可以获得子线程的执行结果");
        System.out.println("执行结果为："+task.get());
    }
}
