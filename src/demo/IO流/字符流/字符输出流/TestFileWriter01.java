package demo.IO流.字符流.字符输出流;

import java.io.*;

public class TestFileWriter01 {

    public static void main(String[] args) {
        m1();
    }

    private static void m1(){
        String src = "/Users/luchengsong/Desktop/笔记/JavaLearning/src/files";
        try (
                //流通道的创建写到try资源块，自动关闭流
                //文件如果不存在，则自动创建一个新文件
                FileWriter fw = new FileWriter(src+"/fff.txt",true)  //true参数表示文件已存在时不是完全覆盖内容，而是添加内容
        ) {

            //一次写一个字符
            fw.write(65);
            fw.write('B');
            fw.write('中');
            fw.write('\n');

            //一次写一个字符串
            fw.write("一次写一个字符串");
            fw.write(10);  // 字节码中，10对应的是换行；所以这里相当于\n

            //一次写一个字符数组
            char[] chars = "一次写一个，字符数组".toCharArray();  //将字符串转为字符数组
            fw.write(chars);
            fw.write('\n');

            //将字节数组中的部分内容写入文件
            fw.write(chars,0,7);  //从第0个开始写，写2个
            fw.write('\n');

        } catch (FileNotFoundException f){
            f.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

}
