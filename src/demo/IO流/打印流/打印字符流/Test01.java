package demo.IO流.打印流.打印字符流;

import java.io.*;

/**
 * 打印字符流
 */
public class Test01 {

    public static void main(String[] args) throws IOException {

        //字符流打印文件
        PrintWriter pw = new PrintWriter(new FileOutputStream("src/files/ppp.txt"));
        pw.write("这是字符打印流\n");

        //字符流打印异常到文件中
        try {
            FileInputStream fis = new FileInputStream("src/files/asdasd.txt");  //访问一个不存在的文件
        } catch (Exception e) {
            e.printStackTrace(pw);
        }

        //关闭流
        pw.close();
    }

}
