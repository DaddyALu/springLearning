package demo.线程.线程安全.Timer定时器类;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main.....begin.....");

        //创建定时器对象
//        Timer timer = new Timer();
        Timer timer = new Timer(true);  //将该定时器设置为守护线程

//        timer.schedule(task,time);  //指定时间，执行任务task
//        timer.schedule(task,delay);  //延迟delay毫秒后，执行task
//        timer.scheduleAtFixedRate(task,firstTime,period);  //指定第一次执行task的时间，之后每隔period毫秒再执行一次task

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        }, 3000, 1000);  //3秒后，每秒打印一次目前的时间

        //main线程睡眠10秒
        Thread.sleep(10000);  //上面的时间会打印7次
        System.out.println("main.....end.....");

    }
}
