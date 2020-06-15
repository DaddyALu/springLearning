package demo.网络编程.简单的TCP网络程序.客户端;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *  TCP通信的客户端：向服务器发送连接请求，给服务器发送数据，读取服务器回写的数据
 *
 *  表示客户端的类：
 *      java.net.Socket类：此类实现了客户端套接字（也可以直接叫"套接字"）。
 *      套接字：套接字是两台机器间通信的端点，包含了IP地址和端口号的一个网络单位（计算机）
 *
 *  构造方法：
 *      Socket（String host，int port）创建一个客户端套接字，并将它连接到指定主机上的指定端口号
 *      参数：
 *          host：服务器主机的名称/服务器的IP地址
 *          port：服务器的端口号
 *
 *  成员方法：
 *      InputStream getInputStream() 返回此套接字的输入流
 *      OutputStream getOutputStream() 返回此套接字的输出流
 *      void close() 关闭此套接字
 *
 *  注意：
 *      1，客户端和服务器进行交互，必须使用Socket中提供的网络流，不能使用自己创建的流对象
 *      2，当创建Socket对象时，就会去请求服务器，并且通过三次握手和服务器建立通路
 *          1)如果此时服务器没有启动，就会抛出异常Connection refused (Connection refused)
 *          2)如果服务器已经启动，就可以正常进行交互
 */
public class TCPClient {


    public static void main(String[] args) throws IOException {

        //1）创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1",8888);

        //2）使用Socket对象中的getOutputStream()方法获取网络字节输入流OutputStream对象
        OutputStream os = socket.getOutputStream();

        //3）给服务器发送数据
        os.write("你好服务器～".getBytes());

        //4）使用Socket对象中的getInputStream()方法获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();

        //5）读取服务器回写的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));

        //6）释放资源
        socket.close();

    }

}
