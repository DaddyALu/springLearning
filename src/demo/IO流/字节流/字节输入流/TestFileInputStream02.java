package demo.IO流.字节流.字节输入流;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * 1、测试手动处理异常，手动关闭流
 *
 * 2、测试自动关闭流(JDK7及往后版本)
 *
 */
public class TestFileInputStream02 {

    public static void main(String[] args) {

        m1();
        m2();

    }

    private static void m1(){
        // "option+command+t"快捷键抓取异常
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/luchengsong/Desktop/笔记/JavaLearning/src/files/aaa.txt");  //地址最前面也要加上"/"
            byte[] bytes = new byte[4];
            int len = fis.read(bytes);
            while (len != -1){
                System.out.println(new String(bytes,0,len));
                len = fis.read(bytes);  //继续读取，且继续获得读取到的数量
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){  //避免空指针异常
                try {
                    fis.close();  //手动关闭流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //从JDK7开始，流可以自动关闭
    private static void m2(){
        // 使用try资源块，自动释放
        try (FileInputStream fis = new FileInputStream("/Users/luchengsong/Desktop/aaa.txt")){
            byte[] bytes = new byte[4];
            int len = fis.read(bytes);
            while (len != -1){
                System.out.println(new String(bytes,0,len));
                len = fis.read(bytes);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
