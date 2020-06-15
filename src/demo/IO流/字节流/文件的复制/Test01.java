package demo.IO流.字节流.文件的复制;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {

    public static void main(String[] args) {

        String src = "/Users/luchengsong/Desktop/笔记/JavaLearning/src/files";
        copyFile01(src + "/aaa.txt", src + "/ccc.txt");  //一个字节一个字节的复制
        copyFile02(src + "/aaa.txt", src + "/ddd.txt");  //一个字节数组一个字节数组的复制

    }

    //一次复制一个字节，当文件内容较大时（比如视频），十分耗时；手动关闭流
    public static void copyFile01(String srcFilename, String destFilename) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFilename);
            fos = new FileOutputStream(destFilename);
            int cc = fis.read();
            while (cc != -1) {
                fos.write(cc);
                cc = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {  //手动关闭流
            if (fis != null) {  //避免空指针异常
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {  //避免空指针异常
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //一次复制一个字节数组；自动关闭流；如果目标文件已存在，以添加内容的方式复制文件，而不是覆盖
    public static void copyFile02(String srcFilename, String destFilename) {
        try (
                FileInputStream fis = new FileInputStream(srcFilename);
                FileOutputStream fos = new FileOutputStream(destFilename, true);
        ) {
            byte[] bytes = new byte[1024 * 8];  //每次复制1m
            int len = fis.read(bytes);
            while (len != -1) {
                fos.write(bytes, 0, len);
                len = fis.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}