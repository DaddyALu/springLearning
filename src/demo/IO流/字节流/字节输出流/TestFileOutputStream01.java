package demo.IO流.字节流.字节输出流;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream01 {

    public static void main(String[] args) {
        m1();
    }

    private static void m1(){

        // 1、如果要写入的文件不存在，则新建一个文件；
        // 2、如果文件已存在，则写入的内容会覆盖原内容；
        // 3、如果在建立流通道的时候，在文件地址后加入参数"true"，则是以追加内容的方式打开文件，即内容不会覆盖，而是添加。
        try (
                //使用try资源块，自动关闭流
                FileOutputStream fos = new FileOutputStream("/Users/luchengsong/Desktop/笔记/JavaLearning/src/files/bbb.txt")
                ){
            //默认从文件的某位开始写，不会自动另起一行

            //一次写一个字节
            fos.write(66);  //B
            fos.write(67);  //C
            fos.write(68);  //D
            fos.write('\n');

            //不成功
            fos.write(Integer.parseInt("1"));  //1

            //一次写一个字节数组
            byte[] bytes = "ZXCzxc321".getBytes();
            fos.write(bytes);
            fos.write(10);  // 字节码中，10对应的是换行；所以这里相当于\n

            //将字节数组中的部分内容写入文件
            fos.write(bytes,0,2);  //从第0个开始写，写2个
            fos.write('\n');

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
