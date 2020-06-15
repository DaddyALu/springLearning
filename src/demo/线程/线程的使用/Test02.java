package demo.线程.线程的使用;

public class Test02 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName()+" --> "+i);
                }
            }
        },"线程t1");

        System.out.println("11 : " + t1.getState());  // NEW

        t1.start();

        System.out.println("22 : " + t1.getState());  // RUNNABLE
        
        //main线程
        for (int i = 1; i <= 200; i++) {
            System.out.println(Thread.currentThread().getName()+" --> "+i);
        }

        System.out.println("33 : " + t1.getState());  // TERMINATED

    }
}
