package demo.IO流.转换流;

import java.io.*;

/**
 * 转换流：文本文件与当前环境编码不兼容时使用（例如当前环境为utf-8，要操作的文件为GBK）
 *
 * InputStreamReader 和 OutputStreamWriter
 */
public class Test01 {

    public static void main(String[] args) throws IOException {
        m2();
        m1();
    }

    //当前环境使用utf-8编码，要操作文本文件hhh.txt中使用GBK编码

    //读（字节转换成字符）  -- 文件到程序
    private static void m1(){
        String path = "/Users/luchengsong/Desktop/笔记/JavaLearning/src/files/hhh.txt";
        try(
                //建立字节流通道
                InputStream is = new FileInputStream(path);
                //使用utf-8编码，将is字节流中的字节数据转换为字符流
                InputStreamReader isr = new InputStreamReader(is,"GBK");  //这里的字符集类型为要读取的文本文件的字符集类型
                ){
            int cc = isr.read();
            while (cc != -1){
                System.out.print((char)cc);
                cc = isr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //写（字符转换成字节）  -- 程序到文件
    private static void m2() throws IOException {
        String path = "/Users/luchengsong/Desktop/笔记/JavaLearning/src/files/hhh.txt";
        OutputStream os = new FileOutputStream(path,true);
        //将当前utf-8编码的字符，转换成GBK编码的字节在存入文件中
        OutputStreamWriter osw = new OutputStreamWriter(os,"GBK");

        osw.write("\n");
        osw.write('a');
        osw.write("bcABC你好");


        osw.close();

//        os.close();  // os流要在osw流之后关闭，因为osw中用到了os
                // 但是这里不需要关闭os流，osw流关闭后，os流也会被关闭

    }

}
