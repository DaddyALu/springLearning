package demo.网络编程.文件的上传;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        //让服务器一直处于监听状态
        while (true){
            Socket socket = server.accept();
            //在接收较大的文件时需要花费一定的时间，不使用多线程技术的话，在这段时间内别的用户就不可以上传文件；
            //使用多线程（每次accept到客户端到请求，就新建一个线程），提高效率
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        //1）获取流
                        InputStream is = socket.getInputStream();
                        //2）指定目的地
                        File file = new File("src/demo/网络编程/文件的上传/upLoad");
                        if (!file.exists()){  //判断文件夹是否存在，不存在则新建一个
                            file.mkdirs();
                        }
                        String fileName = "DaddyALu"+System.currentTimeMillis()+new Random().nextInt(9999)+".txt";
                        FileOutputStream fos = new FileOutputStream(file+"/"+fileName);
                        //3）读取客户端上传的文件
                        byte[] bytes = new byte[1024*8];
                        int len = 0;
                        while ((len = is.read(bytes)) != -1){  //读客户端上传的文件
                            fos.write(bytes,0,len);  //写到服务器的硬盘
                        }
                        //4）给客户端回复
                        socket.getOutputStream().write("上传成功！".getBytes());  //os
                        //5）关闭资源
                        fos.close();
                        socket.close();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        //服务器就不用关闭了
        //server.close();
    }
}
