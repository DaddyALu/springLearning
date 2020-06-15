package demo.IO流.字符流.字符输入流;

import java.io.FileReader;
import java.io.IOException;

public class TestFileReader01 {

    public static void main(String[] args) {
        m1();
        System.out.println("\n");
        m2();
    }


    //一次读取一个字节
    private static void m1(){
        String src = "/Users/luchengsong/Desktop/笔记/JavaLearning/src/files";
        try (
                //建立流通道
                FileReader fr = new FileReader(src+"/fff.txt");
                ){
            //read()方法一次读取一个字符，返回该字符的码值，读到文件末尾返回-1；可以读取中文，不会出现乱码
            int cc = fr.read();
            while (cc != -1){
                System.out.print((char)cc);
                cc = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //一次读取一个字符数组（ char[] ）
    private static void m2(){
        String src = "/Users/luchengsong/Desktop/笔记/JavaLearning/src/files";
        try (
                FileReader fr = new FileReader(src+"/fff.txt")
                ) {
            char[] chars = new char[1024];  //注意，这里不是byte[]
            int len = fr.read(chars);
            while (len != 0){
                System.out.println(new String(chars,0,len));  //将读到的字符转换为字符串打印
                len = fr.read(chars);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
