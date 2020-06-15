package demo.线程.线程创建的方法.实现Calllable接口;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * //call()方法有返回值，根据Callable接口泛型指定返回值类型
 * //当我们不需要子线程完成任务后返回一个值，就使用实现Runnable接口的方式来创建线程
 *     //例如，当我们查看新闻时，如果网络不好，会先给我们显示出文字，再慢慢显示图片，这就是异步加载；
 *     //   先用一个线程用于显示文字，再用另一个线程下载图片，然后将该图片返回。
 */

// 1）实现Calloable接口
public class Prime implements Callable<Integer> {

    // 2）重写抽象方法call()方法
    @Override
    public Integer call() throws Exception {
        int result = new Random().nextInt(100);  //生成一个0～100之间的随机数
        System.out.println("执行子线程，完成计算，结果为 ： "+result);
        return result;
    }
}
