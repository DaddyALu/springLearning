package demo.网络编程.模拟BS服务器.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  http://127.0.0.1:8088/src/web/login.html
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {

        //1）新建端口，获取请求
        ServerSocket server = new ServerSocket(8088);

        //让服务器一直处于监听状态
        while (true){
            Socket socket = server.accept();

            //回写的html如果有别的引用（例如图片、css、js等），就会单独开启一个线程，去读取这些引用的文件
            //每次接收到请求，开启新线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        InputStream is = socket.getInputStream();
                        //2）读取客户端请求
                        /*
                        byte[] bytes1 = new byte[1024*8];
                        int len1 = 0;
                        while ((len1 = is.read(bytes1)) != -1){
                            System.out.println(new String(bytes1,0,len1));
                        }
                        */
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));  //将is网络字节输入流对象转为字符缓冲流
                        String line = br.readLine();  //读出客户端请求信息的第一行 --> "GET /src/web/login.html HTTP/1.1"
                        System.out.println(line);  //输入所要请求的地址
                        String[] arr = line.split(" ");  //按空格切割字符串 --> "/src/web/login.html"
                        String path = arr[1].substring(1);  //去除中间部分的内容，保留去掉第1个字符后的内容 --> "src/web/login.html"

                        //3）创建"读取根据得到的路径所对应的html文件"的输入流
                        FileInputStream fis = new FileInputStream(path);

                        //4）创建"通过网络向客户端写内容"的输出流
                        OutputStream os = socket.getOutputStream();

                        //5）写入HTTP响应头，固定写法
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        //必须写入空行，否则浏览器不解析
                        os.write("\r\n".getBytes());

                        //6）一读一写，将html文件复制到客户端
                        byte[] bytes = new byte[1024*8];
                        int len = 0;
                        while ((len = fis.read(bytes)) != -1){
                            os.write(bytes,0,len);
                        }

                        //7）释放资源
                        fis.close();
                        socket.close();

                    } catch (IOException e){
                        e.printStackTrace();
                    }

                }
            }).start();

        }
    }
}
