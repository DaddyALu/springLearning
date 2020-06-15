package demo.IO流.打印流.打印字节流;


import java.io.*;

/**
 * 打印字节流 PrintStream
 */
public class Test01 {

    public static void main(String[] args) throws IOException {

        // 1）打印内容到文件中
        OutputStream os = new FileOutputStream("src/files/lll.txt");
        PrintStream ps = new PrintStream(os);
        ps.print("Hello");
        ps.println("  World");

        // 2）System类的out成员，就是PrintStream类型的打印流
        //System.out默认系统的输出设备，是显示器
        System.out.println("默认在显示器上打印信息");
        //可以修改System.out的打印方向
        System.setOut(ps);
        System.out.println("这一行就不是打印在屏幕上，而是打印到ps流中，即lll.txt文件中");
        System.out.println("这一行也不是");

        // 3）经常把异常信息保存到日志文件中
        try {
            FileInputStream fis = new FileInputStream("src/files/asdasd.txt");  //访问一个不存在的文件
        } catch (Exception e) {
            //通常我们调用该方法，把异常信息打印到屏幕上
            //e.printStackTrace();

            //在部署后，我们会把异常信息打印到日志文件中
            e.printStackTrace(ps);
        }

        ps.close();
    }

}
