package demo.IO流.字节流.字节输入流;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 测试IO流读取文件
 */
public class TestFileInputStream01 {

    public static void main(String[] args) throws IOException {

        //1、建立流通道1，指定将要读取的文件
        FileInputStream fis = new FileInputStream("/Users/luchengsong/Desktop/笔记/JavaLearning/src/files/aaa.txt");  //rtf格式编码输出有问题
            //文件内容：ABCabc123

        //2、读取文件1
        int cc = fis.read();  // 每次读取一个字节，返回该字节的字节码，读到文件末尾时（读不到字节时），返回-1
        while (cc != -1){
            char c = (char)cc;  // cc得到的是ASCII码值，要强转型得到文件实际的内容
            System.out.print(c);  // 输出结果为"ABCabc123"
            cc = fis.read();  // 读取下一个字节
        }

        //3、关闭流通道
        fis.close();


        System.out.println("\n--------------------------------------------------");


        //1、要重新建立流通道2，因为上面以及把fis读完了
        FileInputStream fis1 = new FileInputStream("/Users/luchengsong/Desktop/aaa.txt");
            //文件内容：ABCabc123

        //2、读取文件2
        byte[] bytes = new byte[4];  // 读取很多字节，存放到字节数组中，返回读取到的字节数；如果读到了文件的末尾，返回-1
                                    // 这里每次读取4个字节，因为数组长度只有4

//        int len = fis1.read(bytes);  // 读取到"ABCa"
//        System.out.println(len);
//        System.out.println(Arrays.toString(bytes));
//
//        len = fis1.read(bytes);  // 读取到"bc12"，覆盖数组里原来的内容
//        System.out.println(len);
//        System.out.println(Arrays.toString(bytes));
//
//        len = fis1.read(bytes);  // 读取到"3"
//        System.out.println(len);
//        System.out.println(Arrays.toString(bytes));  //此时只读到1个字节，所以只覆盖了数组中的第1个元素，别的元素保持为上一次读取到的内容
//
//        len = fis1.read(bytes);  // 读不到字节，表示到了末尾，返回-1
//        System.out.println(len);
//        System.out.println(Arrays.toString(bytes));  //数组中的元素保持为上一次读取的内容

        int len = fis1.read(bytes);  //读取文件，返回读到的字节数
        while (len != -1){
            //从文件中读取了len个字节，存放到bytes数组中
            System.out.println(new String(bytes,0,len));  //将bytes数组中，从第0个开始，往后的len个字节转为字符串
                        //不能直接用 "new String(bytes)" 去读取整个数组，因为最后一次读取到的不一定填满数组，会将上一次读取的内容又输出一遍
            len = fis1.read(bytes);  //继续读取
        }

        //3、关闭流通道
        fis1.close();

    }

}
