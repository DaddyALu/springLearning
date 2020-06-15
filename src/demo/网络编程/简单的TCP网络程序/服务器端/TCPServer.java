package demo.网络编程.简单的TCP网络程序.服务器端;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  TCP通信的服务器端，接收客户端的请求，读取客户端发送的数据，给客户端回写数据
 *
 *  表示服务器的类：
 *      java.net.ServerSocket类：此类实现了服务器端套接字
 *
 *  构造方法：
 *      ServerSocket（int port）创建绑定到特定端口的服务器套接字
 *
 *  成员方法：
 *      Socket accept() 监听并接受到此套接字的连接
 *
 *  注意：
 *      1）服务器端必须明确一件事，必须知道是哪个客户端请求的服务器；
 *      2）所以可以使用accept()方法，获取到请求的客户端对象Socket；
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {
        //1）创建ServerSocket对象，和系统要指定的端口号
        ServerSocket server = new ServerSocket(8888);

        //2）使用ServerSocket对象中的方法accept()，获取请求的客户端对象Socket
        Socket socket = server.accept();

        //3）使用Socket对象中的getInputStream()方法获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();

        //4）读取客户端发送的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));

        //5）使用Socket对象中的getOutputStream()方法获取网络字节输入流OutputStream对象
        OutputStream os = socket.getOutputStream();

        //6）给客户端回写数据
        os.write("服务器已收到！".getBytes());

        //7）释放资源
        socket.close();
        server.close();

    }

}
