package demo.线程.线程安全.两线程交替打印奇偶数;

public class PrintNum {

    private int num = 0;

    //打印奇数
    public synchronized void printOdd(){
        //当目前是偶数时，等待
        while (num%2 == 0){
            try {
                this.wait();  //this为当前对象，也是线程同步块的锁对象
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //打印奇数
        System.out.println(Thread.currentThread().getName()+" --> "+num);
        num++;
        //通知打印偶数(将偶数线程唤醒，然后就算接下来是奇数打印线程获得CPU，也因为num目前为偶数而进入wait)
        this.notify();
    }

    //打印偶数
    public synchronized void printEven(){
        //当目前是奇数时，等待
        while (num%2 == 1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //打印偶数
        System.out.println(Thread.currentThread().getName()+" ====> "+num);
        num++;
        //通知打印奇数
        this.notify();
    }
}
