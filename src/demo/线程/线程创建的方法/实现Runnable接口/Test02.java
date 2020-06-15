package demo.线程.线程创建的方法.实现Runnable接口;

/**
 * 当Runnable接口的实现类对象只使用一次时，可以直接使用该接口的匿名内部类对象来作为实参
 */
public class Test02 {

    public static void main(String[] args) {
        //调用放方法时，实参传的是接口匿名内部类对象
        Thread t22 = new Thread(new Runnable() {
            //在匿名内部类中重写接口的抽象方法
            @Override
            public void run() {
                //指定子线程要执行的代码
                for (int i = 0; i < 100; i++) {
                    System.out.println("sub thread : " + i);
                }
            }
        });
        //启动线程
        t22.start();

        //main线程
        for (int i = 0; i < 100; i++) {
            System.out.println("main --> " + i);
        }
    }
}
