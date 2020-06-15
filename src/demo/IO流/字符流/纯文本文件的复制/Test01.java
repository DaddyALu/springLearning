package demo.IO流.字符流.纯文本文件的复制;

import java.io.FileReader;
import java.io.FileWriter;

public class Test01 {

    public static void main(String[] args) {
        String src = "/Users/luchengsong/Desktop/笔记/JavaLearning/src/files";
        copyFile(src+"/fff.txt",src+"/ggg.txt");

    }


    private static void copyFile(String srcPath, String destPath){
        try (
                FileReader fr = new FileReader(srcPath);
                FileWriter fw = new FileWriter(destPath);
        ) {
            char[] chars = new char[1024];
            //读
            int len = fr.read(chars);
            while (len != -1){
                //写
                fw.write(new String(chars,0,len));
                //继续往下读
                len = fr.read(chars);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
