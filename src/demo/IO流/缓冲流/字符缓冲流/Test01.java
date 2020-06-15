package demo.IO流.缓冲流.字符缓冲流;

import java.io.*;

/**
 * 字符缓冲流（也称作处理流、包装流）
 *
 * BufferedReader 和 BufferedWriter
 */
public class Test01 {

    public static void main(String[] args) {
        m1();
        m2();
        m3();

//        Scanner sc = new Scanner(System.in);
//        System.out.println(sc.nextLine());
//        System.out.println(sc.nextInt());  //只能输入数字

    }


    //读
    private static void m1(){
        Reader in = null;  //使用根目录路径就可以
        BufferedReader br = null;
        try {
            in = new FileReader("src/files/aaa.txt");  //使用根目录路径就可以
            br = new BufferedReader(in);
            String line = br.readLine();//读取一行，读到末尾返回null
            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();  //当包装流关闭后，被包装的流也会被关闭
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //写
    private static void m2(){
        Writer out = null;
        BufferedWriter bw = null;
        try {
            out = new FileWriter("src/files/jjj.txt",true);  //使用根目录路径就可以
            bw = new BufferedWriter(out);

            bw.write("BufferedWriter输出\n");

            //执行flush()方法后，数据才会被写到文件中（如果程序没有写close()方法，或者缓存区没满的情况下）
//            bw.flush();  //将缓冲区的数据保存到文件中，清空缓冲区

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null){
                try {
                    //close方法中，也包含了清空缓存区的方法
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //类似复制
    private static void m3(){
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    // System.in是标准的输入设备，即键盘
                    // 它的类型是是字节流类型，底层代码："public final static InputStream in = null;"
                    // 所以这里要用InputStreamReader转换流，将其从字节转换成字符，因为缓冲流属于字符流
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/kkk.txt"));
                ){
            //读
            String line = br.readLine();
            while (line.length() > 0){  // 读取到的内容长度大于0，说明键盘确实输入了内容
                                // 所以，当我们处于新一行且不输入内容直接按回车换行时，就介绍了读取
                            // 即输入完内容后，连按两次回车，结束程序
                //写
                bw.write(line);
                bw.newLine();  //换行
                //继续读
                line = br.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
