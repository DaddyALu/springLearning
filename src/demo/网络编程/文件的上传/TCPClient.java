package demo.网络编程.文件的上传;

import java.io.*;
import java.net.Socket;

/**
 * 文件的上传
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {

        upLoad("src/files/aaa.txt","127.0.0.1",8888);

    }

    //文件的上传
    public static void upLoad(String srcFilename, String host, int port) {  //源文件地址，服务器地址，服务器端口
        try (  // try资源块，可以自动关闭流
               FileInputStream fis = new FileInputStream(srcFilename);
               Socket socket = new Socket(host,port);
               OutputStream os = socket.getOutputStream();
               InputStream is = socket.getInputStream();
        ) {
            byte[] bytes = new byte[1024 * 8];  //每次复制1m
            int len = 0;

            //读本地的文件，写到网络上（上传）
            while ((len = fis.read(bytes)) != -1) {  //读
                os.write(bytes, 0, len);  //写
            }
            //读取本地文件时，读到-1结束循环，但是这个-1并不会写给服务器，就会导致服务器读取客户端上传的文件时，永远读取不到结束标记，read()方法进入阻塞状态；
            //结束输出，给服务器写一个结束标记
            socket.shutdownOutput();

            //读网络的答复，输出到屏幕上
            while ((len = is.read(bytes)) != -1) {
                System.out.println(new String(bytes,0,len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
